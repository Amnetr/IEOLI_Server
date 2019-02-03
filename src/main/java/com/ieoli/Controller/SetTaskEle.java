package com.ieoli.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.RulesService;
import com.ieoli.service.TextsService;
@Controller
public class SetTaskEle {
	String subsection="/p";
	String subword="\\$";
	@Resource
	TextsService ts;
	@Resource
	RulesService rs;
	@Resource
	ModelService ms;
	@RequestMapping(value= "/setTaskEle")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		int id = Integer.parseInt(request.getParameter("models"));
		//UserEntity user=(UserEntity)session.getAttribute("user");
		//int userid=user.getUserid();
		List<TextEntity> te = ts.getTexts();
		List<RuleEntity> rules=rs.getRuleByModelID(id);
		session.setAttribute("rules", rules);
		session.setAttribute("modelid", id);
		//ModelAndView mav = new ModelAndView();
		HashMap<String,Object> hm = new HashMap<>();
		//mav.addObject("rules",rules);
		hm.put("rules",rules);
		if(te==null)
		{
			
		//	mav.addObject("result", "未上传文本");
		//	mav.setViewName("/WEB-INF/jsp/element.jsp");//打标签页面
			hm.put("result","NoText");
		//	return mav;
		}else {
			List<RuleEntity> rule= rs.getRuleByModelID(id);
			//session.setAttribute("text", te);
			session.setAttribute("rules", rule);
			List<TextEntity> wordList = new ArrayList<TextEntity>();
			
			//2018.6.2更新 抽取某段
			int section=ms.getModelByID(id).getSection();
			for(int i=0;i<te.size();i++){
				String[] subs=te.get(i).getArticle().split(subsection);
				if(subs.length>=section){
					String[] words=subs[section-1].split(subword);
					String para="";
					for(int j=0;j<words.length;j++){
						
						para+=words[j].split("_")[0];
					}
				    te.get(i).setArticle(para);
					wordList.add(te.get(i));
				}
			}
			session.setAttribute("text", wordList);
			List<TextEntity> upload = new ArrayList<TextEntity>();
			if(wordList.size()<2)
			{
				upload.addAll(wordList);
				session.setAttribute("index", 0);
			}else {
				upload.add(wordList.get(0));
				upload.add(wordList.get(1));
				session.setAttribute("index", 2);
			}
			//mav.addObject("list", upload);
			hm.put("list",upload);
			//mav.setViewName("/WEB-INF/jsp/elementextract.jsp");//打标签页面
			//return mav;
		}
		response.getWriter().write(JSON.toJSONString(hm));
	}
}
