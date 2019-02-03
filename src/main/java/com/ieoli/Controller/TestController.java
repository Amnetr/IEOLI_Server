package com.ieoli.Controller;

import java.util.Date;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.Utils.KeepingTimer;

@Controller
public class TestController {
	@RequestMapping(value="/keep")
	void handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		Timer timer = new Timer();
		KeepingTimer kt= new KeepingTimer(new Date(), timer);
		timer.schedule(kt, new Date(),3600*1000*7+50);
	}
}
