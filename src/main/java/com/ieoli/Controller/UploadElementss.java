package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.service.ModelService;
@Controller
public class UploadElementss {
	@Resource
	ModelService ms;
	@RequestMapping("/UploadElements")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String id = request.getParameter("modelid");
		String description  = request.getParameter("description");
		int section=Integer.parseInt(request.getParameter("section"));
		int mid = Integer.parseInt(id);
		if(mid==-1)
		{
			ms.insertModel(description,section);
		}else {
			ms.updateModel(mid, description,section);
		}
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/jsp/editelement.jsp");
		response.getWriter().write("success");
	}
}
