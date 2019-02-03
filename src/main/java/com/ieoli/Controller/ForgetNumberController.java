package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.Utils.EncoderPlus;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

@Controller
public class ForgetNumberController {
@Resource
UserService userService;
	@RequestMapping("/forgetpassword")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		int code = (int)session.getAttribute("code");
		String passwordString = EncoderPlus.getMD5(request.getParameter("password"));
		String hiscode=request.getParameter("code");
		if(Integer.parseInt(hiscode)==code)
		{
			if(userService.getUserByUsername((String)session.getAttribute("username"))!=null)
			{
				UserEntity user = new UserEntity();
				user = userService.getUserByUsername((String)session.getAttribute("username"));
				user.setUserpassword(passwordString);
				userService.updateUser(user);
				response.getOutputStream().write("success".getBytes());
			}else {
				response.getOutputStream().write("existed".getBytes());
			}
			
		}else {
			response.getOutputStream().write("wrongcode".getBytes());
		}
		
	}
}
