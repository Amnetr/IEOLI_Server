package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.service.TaskService;
@Controller
public class UploadTasks {
	@Resource
	TaskService ms;
	@RequestMapping("/UploadModels")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String id = request.getParameter("taskid");
		String description  = request.getParameter("description");
		int mid = Integer.parseInt(id);
		if(mid==-1)
		{
			ms.insertTask(description);
		}else {
			ms.updateTask(mid, description);
		}
		/*
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/jsp/editTask.jsp");
		return mav;
		*/
		response.getWriter().write("success");
	}
}
