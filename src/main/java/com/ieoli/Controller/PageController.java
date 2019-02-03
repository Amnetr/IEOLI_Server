package com.ieoli.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ieoli.Utils.MailConfig;
import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.TaskEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.RulesService;
import com.ieoli.service.TaskService;
import com.ieoli.service.TextsService;

@Controller
public class PageController{
@Resource
ModelService ms;
@Resource
TaskService ts;
@Resource
TextsService tts;
@Resource
private RulesService rs;
	@RequestMapping(value="/page")
	protected void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String a = request.getParameter("path");
		//String pages = "/WEB-INF/jsp/"+a+".jsp";
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName(pages);
		HashMap<String,Object> hm = new HashMap<>();
		switch(a)
		{
		case "showHandledText":
			int taskid=Integer.parseInt(request.getParameter("taskid"));
			List<TextEntity> texts=tts.getHandledText(taskid);
			session.setAttribute("model", taskid);
			//mav.setViewName("/WEB-INF/jsp/download.jsp");
			//mav.addObject("Texts",texts);
			hm.put("Texts",texts);
			break;
		case "download":
		case "edittask":
			//	mav.addObject("user",session.getAttribute("user"));
			//case "upload-text":
			//case "chakanModel":
			List<TaskEntity> tlists = ts.getTasks();
			//mav.addObject("list", tlists);
			hm.put("list",tlists);
			break;
		case "showHandledRule":	
			int modelid=Integer.parseInt(request.getParameter("modelid"));
			List<RuleEntity> rules = rs.getRuleByModelID(modelid);
			//mav.setViewName("/WEB-INF/jsp/showrule.jsp");
			//mav.addObject("Rules",rules);
			hm.put("Rules",rules);
			break;
		case "showrule":
		case "editelement":
			List<ModelEntity> mlists = ms.getModels();
			//mav.addObject("list", mlists);
			hm.put("list",mlists);
			break;
		case "nextpage":
			//mav.setViewName("/WEB-INF/jsp/elementextract.jsp");
			int index = (int) session.getAttribute("index");
			List<TextEntity> list=(List<TextEntity>) session.getAttribute("text");
			List<TextEntity> wordlist=new ArrayList<TextEntity>();
			if(list.size()<2)
			{
				wordlist.addAll(list);
				
			}else {
				wordlist.add(list.get(index%list.size()));
				wordlist.add(list.get((index+1)%list.size()));
			}
		index=index+2;
		session.setAttribute("index", index);
		//mav.addObject("list", wordlist);
			hm.put("list",wordlist);
		break;
		case "beforepage":
			//mav.setViewName("/WEB-INF/jsp/elementextract.jsp");
			int indexx = (int) session.getAttribute("index");
			List<TextEntity> listt=(List<TextEntity>) session.getAttribute("text");
			List<TextEntity> wordlistt=new ArrayList<TextEntity>();
			if(indexx<2)
			{
				indexx = indexx +listt.size();
			}
			if(listt.size()<2)
			{
				wordlistt.addAll(listt);
				
			}else {
				wordlistt.add(listt.get((indexx-1)%listt.size()));
				wordlistt.add(listt.get((indexx-2)%listt.size()));
			}
			indexx=indexx-2;
		session.setAttribute("index", indexx);
		//mav.addObject("list", wordlistt);
			hm.put("list",wordlistt);
		break;
		}
		//return mav;
		response.getWriter().write(JSON.toJSONString(hm));
	}
}
