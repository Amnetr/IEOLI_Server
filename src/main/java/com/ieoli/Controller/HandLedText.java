package com.ieoli.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.RulesService;
import com.ieoli.service.TextsService;

@Controller
public class HandLedText {
	@Resource
	private RulesService ts;
	@Resource
	ModelService ms;
	@SuppressWarnings("null")
	@RequestMapping("/ShowHandLedText")
	public void ShowHandLedText(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		
		
		response.setCharacterEncoding("UTF-8");
		//ModelAndView mav = new ModelAndView();
		String modelid = request.getParameter("modelid");
		List<ModelEntity> lists = ms.getModels();
		//mav.addObject("list", lists);
		List<RuleEntity> rules = ts.getRuleByModelID(Integer.parseInt(modelid));
		HashMap<String,Object> hm = new HashMap<>();
		hm.put("lists",lists);
		hm.put("rules",rules);
		response.getWriter().write(JSON.toJSONString(hm));
		//mav.addObject("rules",rules);
		//mav.setViewName("WEB-INF/jsp/download.jsp");
		//return mav;
	}
}
