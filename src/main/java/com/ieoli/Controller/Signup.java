package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ieoli.Utils.EncoderPlus;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

@Controller
public class Signup {
	@Resource
	UserService userService;
@RequestMapping("Signup")
public  void getCode(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	int yanzheng = (int)session.getAttribute("code");
	String code = request.getParameter("code");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String actor = request.getParameter("actor");
	UserEntity user = new UserEntity();
	user.setUsername(username);
	user.setUserpassword(EncoderPlus.getMD5(password));
	user.setUsertype(Integer.parseInt(actor));//sasfaf
	user.setRightanswer(0);
	user.setWronganswer(0);
	String failed = "existed";
	if(userService.getUserByUsername(username)!=null)
	{
		response.getOutputStream().write(failed.getBytes());
return;
	}
	if(Integer.parseInt(code)==yanzheng)
	{
		userService.Signup(user);
	
		String st="success";
		response.getOutputStream().write(st.getBytes());
		
	}else {
		
		String st="wrongcode";
		response.getOutputStream().write(st.getBytes());
	}
	
	//yanzheng为发到邮箱的验证码
}
}
