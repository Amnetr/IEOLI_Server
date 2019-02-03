package com.ieoli.Controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.Utils.MailUtil;
import com.ieoli.service.UserService;

@Controller
public class SendMailController {
	@Resource
	UserService userService;
@RequestMapping("SendMail")
public  void getCode(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	String mail = request.getParameter("username");
	session.setAttribute("username", mail);
	String failed="failed";
	if(mail ==""||mail==null)
	{
		response.getOutputStream().write(failed.getBytes());
		return;
	}
	int number;
	Random random =new Random(System.currentTimeMillis());
	number = random.nextInt()%9000;
	if(number<0)
	{
		number = -number;
	}
	number +=1000;
	String subject = "医学要素提取系统验证码";
	String html = "您的验证码是：  "+number;
	try{
		session.setAttribute("code", number);
		MailUtil.sendMail(mail, subject, html);
		String a = "Success";
		response.getOutputStream().write(a.getBytes());
	}catch(Exception e)
	{
		response.getOutputStream().write(failed.getBytes());
		e.printStackTrace();
	}
		
}
}
