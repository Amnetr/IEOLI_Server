package com.ieoli.Controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//import org.apache.ibatis.annotations.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.RulesService;
import com.ieoli.service.TextsService;

@Controller
public class SubmitResult {

@Resource
RulesService rs;
@Resource
TextsService ts;
@RequestMapping("submitresult")
protected void handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
		String code = request.getParameter("code");//操作符，0表示测试，返回提取到的要素结果。其他值表示提交结果。
		String description= request.getParameter("description");
		
		
		String regex=SubmitResult.replace(description);// parse into regex
				
		Pattern pat = Pattern.compile(regex);
		if(code.equals("0"))//test
		{
			String article= request.getParameter("article");
			String[] articles=article.split("#");
			Matcher mat;
			String rule = "";
			for(int i =0;i<articles.length;i++)
			{
				mat=pat.matcher(articles[i]);
				if(mat.find())
				{
					rule+="|"+mat.group()+"|";
				}
			}
				
			
			response.getWriter().write(rule);
			
		}else if(code.equals("1")){
			// submit
			RuleEntity re= new RuleEntity();
			re.setModelid((int)session.getAttribute("modelid"));
			re.setDescription(description);
			re.setRegex(regex);
			re.setUserid(((UserEntity)session.getAttribute("user")).getUserid());
			List<TextEntity> texts=ts.getTexts();
			double right = 0;
			double all = texts.size();
			for(int i = 0 ; i <texts.size();i++)
			{
				String art= texts.get(i).getArticle();
				if (pat.matcher(art).find())
				{
					right=right+1;
				}
			}
			double rate = right/all;
			re.setRate(rate);
			rs.insertRule(re);
			response.getWriter().write("success");
			
			
		}else{
			//update
			String rid= request.getParameter("ruleid");
			int id=Integer.parseInt(rid);
			RuleEntity re=rs.getRuleByID(id);
			re.setDescription(description);
			re.setRegex(regex);
			re.setLastupdatetime(new Date());
			List<TextEntity> texts=ts.getTexts();
			double right = 0;
			double all = texts.size();
			for(int i = 0 ; i <texts.size();i++)
			{
				String art= texts.get(i).getArticle();
				if (pat.matcher(art).find())
				{
					right=right+1;
				}
			}
			double rate = right/all;
			re.setRate(rate);
			rs.updateRule(re);
			response.getWriter().write("success");
			
		}
}
public static String replace(String a){

	String temp = a ;
	String regex1 = "\u6570\u5b57";
	String regex2 = "\\(";
	String regex3 = "\\)";
	String regex4 = "\\[[\u4e00-\u9fa5]+\\]";
	String regex5 = "\u6c49\u5b57";
	String regex6 = "\u5b57\u7b26\u4e32";
	String regex7 = "\\\\n";
	String rep1 = "\\\\d";
	String rep2 = "\\{";
	String rep3 = "\\}";
	String rep5 = "\\[\\\\u4e00-\\\\u9fa5\\]";
	String rep6 = "\\[\\\\u4e00-\\\\u9fa5_a-zA-Z0-9]";
	String rep7 = "\\|";
	
	
	//变换数字类型
	Pattern p = Pattern.compile(regex1);
	Matcher m = p.matcher(temp);
	temp = m.replaceAll(rep1);
	
	//变换括号
    p = Pattern.compile(regex2);
	m = p.matcher(temp);
	temp = m.replaceAll(rep2);
    p = Pattern.compile(regex3);
	m = p.matcher(temp);
	temp = m.replaceAll(rep3);
	
	//中文规则转码
    p = Pattern.compile(regex4);
    m = p.matcher(temp);
    StringBuffer sb1 = new StringBuffer();
    while(m.find()){
       m.appendReplacement(sb1,gbEncoding(m.group()));
    }
    m.appendTail(sb1);
    temp = sb1.toString();

    p = Pattern.compile("\\\\u005b");
    m = p.matcher(temp);
	temp = m.replaceAll("");
	p = Pattern.compile("\\\\u005d");
	m = p.matcher(temp);
	temp = m.replaceAll("");
	
	p = Pattern.compile("\\[");
	m = p.matcher(temp);
	temp = m.replaceAll("");   //改前为////
	p = Pattern.compile("\\]");
	m = p.matcher(temp);
	temp = m.replaceAll("");
		
	//中文、字符串类型转换
	p = Pattern.compile(regex5);
	m = p.matcher(temp);
	temp = m.replaceAll(rep5);
	p = Pattern.compile(regex6);
	m = p.matcher(temp);
	temp = m.replaceAll(rep6);
	
	//变换换行
    p = Pattern.compile(regex7);
	m = p.matcher(temp);
	temp = m.replaceAll(rep7);
	
	//字符串类型转换			
	p = Pattern.compile("\\{\\}");
	m = p.matcher(temp);
	StringBuffer sb2 = new StringBuffer();
		while(m.find()){   	
			m.appendReplacement(sb2,"+");	        
		}
	m.appendTail(sb2);
	temp = sb2.toString();
	
	return temp;
};


public static String gbEncoding(final String gbString) {
    char[] utfBytes = gbString.toCharArray();
    String unicodeBytes = "";
    for (int i = 0; i < utfBytes.length; i++) {
        String hexB = Integer.toHexString(utfBytes[i]);
        if (hexB.length() <= 2) {
            hexB = "00" + hexB;
        }
        unicodeBytes = unicodeBytes + "\\\\u" + hexB;
    }
    return unicodeBytes;
}

}
