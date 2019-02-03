package com.ieoli.Controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.Utils.PropertyUtil;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TaskService;
import com.ieoli.service.TextsService;
import com.ieoli.service.UserService;

@Controller
public class SubmitHT {
	@Resource
	private TextsService ts;
	//private TextBehavior textBehavior;
	@Resource
	private UserService us;
	//private UserBehavior userBehavior;
	@Resource
	private ResultsService rs;
	@Resource
	private TaskService tts;
	@RequestMapping(value="/submitHT")
	public void insertResult(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String result=request.getParameter("result");
		
		UserEntity User=(UserEntity)session.getAttribute("user");
		int userid=User.getUserid();
		
		TextEntity Text=(TextEntity)session.getAttribute("text");
		int textid=Text.getTextid();
		ts.offline(textid);
		String[] models=((String) session.getAttribute("model")).split(",");
		List<Integer> modelids= new ArrayList<Integer>();
		for(String temp:models)
		{
			modelids.add(Integer.parseInt(temp));
		}
		//modelid-结果列表
		HashMap<Integer, List<ResultEntity>> map  = new HashMap<>();
		for(int modelid :modelids)
		{
			map.put(modelid, rs.getResultByTaskID(modelid, textid));
		}
		HashMap<Integer,String> resultMap = getlabel(result);
		for(Entry<Integer, String> cur:resultMap.entrySet())//逐个模型评价
		{
			ResultEntity re= new ResultEntity();
			re.setLabel(cur.getValue());
			re.setModelid(cur.getKey());
			re.setTextid(textid);
			re.setUserid(userid);
			re.setUseful(true);
			boolean ok = rs.insertResult(re);
			if(ok)
			{
				//进入评估阶段
				List<ResultEntity> preResult = map.get(cur.getKey());
				int cond= 0;//反应是否有正确的
				for(ResultEntity pre: preResult)
				{
					if(evaluate(cur.getValue(), pre.getLabel(), Text.getArticle()))
					{
						cond=1;
						rs.setTrue(re);
						rs.setTrue(pre);
						break;
					}
				}
				if(cond==0)
				{
					if(preResult.size()==1)
					{
						//donothing
					}else {
						//delete
						for(ResultEntity pre: preResult)
						{
							rs.deleteResultByID(pre.getResultid());
						}
					}
				}
			}
		}
		response.getWriter().write("Success");
	}
	
	private boolean evaluate(String labela,String labelb,String text){
		int condition = Integer.parseInt(PropertyUtil.getProperty("condition")); //(0为严格模式，1为宽松模式)
		switch (condition) {
		case 0:
			return MD5(labela).equals(MD5(labelb));
		default:
			HashSet<String> awords= getwords(labela, text);
			HashSet<String> bwords= getwords(labelb, text);
			HashSet<String> awordsi= getwords(labela, text);
			HashSet<String> bwordsi= getwords(labelb, text);
			awords.removeAll(bwords);
			bwordsi.removeAll(awordsi);
			if(awords.isEmpty()&&bwordsi.isEmpty())
			{
				return true;
			}else
			{
				return false;
			}
			
			
		}
	}
	private HashSet<String> getwords(String labela,String text)
	{
		String[] texts= text.split("\\$");
		HashSet<String> wordsa= new HashSet<>();
		String[] labelsa = labela.split("\\$");
		ArrayList<String> start = new ArrayList<>();
		ArrayList<String> end = new ArrayList<>();
		for(String label:labelsa)
		{
			if(label.split("_")[2].equals("d"))
			{
				int index=Integer.parseInt(label.split("&")[0]);
				wordsa.add(texts[index-1]);
			}else if(label.split("_")[2].equals("s")){
				start.add(label);
			}else {
				end.add(label);
			}
		}
		for(String star:start)
		{
			int startindex= Integer.parseInt(star.split("&")[0]);
			String label = star.split("&")[1];
			label=label.substring(0,label.length()-1);
			for(String en:end)
			{
				int endindex =  Integer.parseInt(en.split("&")[0]);
				String labelend=  en.split("&")[1];
				labelend=labelend.substring(0,labelend.length()-1);
				if(endindex>startindex&&label.equals(labelend))
				{
					wordsa.add(getSequence(startindex, endindex, texts));
				}
			}
			
		}
		return wordsa;
	}
	private String getSequence(int start,int end,String[] texts)
	{
		String toR="";
		for(int i = start;i<=end;i++)
		{
			toR+=texts[i-1];
		}
		return toR;
	}
	private HashMap<Integer, String> getlabel(String result){
		String result1[]=result.split("\\$");
		String labels = "";
		HashMap<Integer, String> gpbymodel = new HashMap<>();
		for(int i=1;i<result1.length;i++){
			if(result1[i].contains("&")){
				String a[]=result1[i].split("\\&");
				for(int j = 1 ; j<a.length;j++)
				{
					String label = a[j];
					String jieduan = a[j].split("_")[0];
					String model = a[j].split("_")[1];
					String type = a[j].split("_")[2];
					if(gpbymodel.containsKey(Integer.parseInt(model)))
					{
						String cur =gpbymodel.get(Integer.parseInt(model));
						cur += "$" +i+"&"+ label;
						gpbymodel.put(Integer.parseInt(model), cur);
					}else {
						gpbymodel.put(Integer.parseInt(model), i+"&"+label);
					}
				}
				
			}
		}
		
		return gpbymodel;
		
	}
	
	 private  static String MD5(String s) {  
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
	        try {  
	            byte[] btInput = s.getBytes("utf-8");  
	            // 获得MD5摘要算法的 MessageDigest 对象  
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	            // 使用指定的字节更新摘要  
	            mdInst.update(btInput);  
	            // 获得密文  
	            byte[] md = mdInst.digest();  
	            // 把密文转换成十六进制的字符串形式  
	            int j = md.length;  
	            char str[] = new char[j * 2];  
	            int k = 0;  
	            for (int i = 0; i < j; i++) {  
	                byte byte0 = md[i];  
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
	                str[k++] = hexDigits[byte0 & 0xf];  
	            }  
	            return new String(str);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	
}
