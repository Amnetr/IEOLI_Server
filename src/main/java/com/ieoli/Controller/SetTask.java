package com.ieoli.Controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.Utils.RunTimeConf;
import com.ieoli.entity.TaskEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.TaskService;
import com.ieoli.service.TextsService;
@Controller
public class SetTask {
	@Resource
	TaskService tks;
	@Resource
	TextsService ts;
	@RequestMapping(value= "/setTask")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String ids = request.getParameter("models");
		String[] idar = ids.split(",");
		ArrayList<Integer> idl = new ArrayList<>();
		for(String id:idar)
		{
			idl.add(Integer.parseInt(id));
		}
		UserEntity user=(UserEntity)session.getAttribute("user");
		int userid=user.getUserid();
		TextEntity te = ts.getTextsByUser(userid,idl);
	TextEntity tebef = (TextEntity)session.getAttribute("text");
		HashMap<String,Object> hm = new HashMap<>();
	if(tebef!=null)
	{
		ts.offline(tebef.getTextid());
		((Timer)session.getAttribute("timer")).cancel();
	}

		if(te==null)
		{
			//ModelAndView maf = new ModelAndView();
			//maf.addObject("result", "没有文本需要打标签");
			//maf.setViewName("/WEB-INF/jsp/task.jsp");//打标签页面
			//return maf;
			hm.put("Result","NoText");
		}else {
			session.setAttribute("text", te);
			session.setAttribute("model", ids);
			List<TaskEntity> tasks= tks.getTaskByIds(idl);
			String[] stringlist;
			String article = te.getArticle();
			stringlist  = article.split("\\$");
			ArrayList<String> wordList = new ArrayList<String>();
			for(int i = 0 ; i<stringlist.length;i++)
			{
				String[] temp = stringlist[i].split("\\_");
				wordList.add(temp[0]);
			}
			//ModelAndView mav = new ModelAndView();
			//mav.addObject("tasks",tasks);
			//mav.addObject("list", wordList);
			//mav.setViewName("/WEB-INF/jsp/dabiaoqian.jsp");//打标签页面
			hm.put("tasks",tasks);
			hm.put("list",wordList);
			 Timer timer = new Timer();
				RunTimeConf rtc = new RunTimeConf(timer, te.getTextid());
			 timer.schedule(rtc, new Date(),10000);
			 session.setAttribute("timer", timer);
			//return mav;
		}
		response.getWriter().write(JSON.toJSONString(hm));
	}
}
