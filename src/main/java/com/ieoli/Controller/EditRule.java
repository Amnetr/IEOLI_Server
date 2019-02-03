package com.ieoli.Controller;

import java.util.ArrayList;
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
import com.ieoli.entity.UserEntity;
import com.ieoli.service.RulesService;

@Controller
public class EditRule {
	
@Resource
private RulesService rs;
@RequestMapping("editresult")
void handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	String id = request.getParameter("rule");
	String description  = request.getParameter("description");
	String regex="";//Parsing description to regex;
	int userid = ((UserEntity)session.getAttribute("user")).getUserid();
	RuleEntity re= new RuleEntity();
	re.setDescription(description);
	re.setRegex(regex);
	re.setRuleid(Integer.parseInt(id));
	re.setUserid(userid);
	rs.updateRule(re);
	/*
	List<TextEntity> list=(List<TextEntity>) session.getAttribute("text");
	List<TextEntity> wordlist=new ArrayList<TextEntity>();
	int index = (int) session.getAttribute("index");
	if(list.size()<2)
	{
		wordlist.addAll(list);
		
	}else {
		wordlist.add(list.get(index%list.size()));
		wordlist.add(list.get((index+1)%list.size()));
	}*/
	response.getWriter().write("success");
}
}
