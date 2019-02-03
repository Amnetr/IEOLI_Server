package com.ieoli.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.dao.RuleEntityMapper;
import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.RuleEntityExample;
import com.ieoli.service.RulesService;
@Service("rulesservice")
public class RulesServiceImpl implements RulesService {

	@Resource
	private RuleEntityMapper ruleMapper;
	
	@Override
	public void insertRule(RuleEntity rule) {
		// TODO Auto-generated method stub
		ruleMapper.insert(rule);

	}

	public List<RuleEntity> getRuleByModelID(int textid) {
		// TODO Auto-generated method stub
		RuleEntityExample ruleExample=new RuleEntityExample();
		ruleExample.createCriteria().andModelidEqualTo(textid);
		List<RuleEntity> rules=ruleMapper.selectByExample(ruleExample);
		
		return rules;
	}

	@Override
	public void deleteRuleByID(int id) {
		// TODO Auto-generated method stub
		ruleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateRule(RuleEntity rule) {
		// TODO Auto-generated method stub
		ruleMapper.updateByPrimaryKeySelective(rule);
	}

	@Override
	public RuleEntity getRuleByID(int ruleid) {
		// TODO Auto-generated method stub
		
		return ruleMapper.selectByPrimaryKey(ruleid);
	}

}
