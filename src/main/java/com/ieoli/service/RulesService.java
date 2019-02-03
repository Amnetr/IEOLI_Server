package com.ieoli.service;

import java.util.List;

import com.ieoli.entity.RuleEntity;

public interface RulesService {

	public void insertRule(RuleEntity rule);
	public List<RuleEntity> getRuleByModelID(int textid);
	public void deleteRuleByID(int id);
	public void updateRule(RuleEntity rule);
	public RuleEntity getRuleByID(int ruleid);
	
}
