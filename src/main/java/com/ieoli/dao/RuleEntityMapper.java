package com.ieoli.dao;

import com.ieoli.entity.RuleEntity;
import com.ieoli.entity.RuleEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleEntityMapper {
    int countByExample(RuleEntityExample example);

    int deleteByExample(RuleEntityExample example);

    int deleteByPrimaryKey(Integer ruleid);

    int insert(RuleEntity record);

    int insertSelective(RuleEntity record);

    List<RuleEntity> selectByExample(RuleEntityExample example);

    RuleEntity selectByPrimaryKey(Integer ruleid);

    int updateByExampleSelective(@Param("record") RuleEntity record, @Param("example") RuleEntityExample example);

    int updateByExample(@Param("record") RuleEntity record, @Param("example") RuleEntityExample example);

    int updateByPrimaryKeySelective(RuleEntity record);

    int updateByPrimaryKey(RuleEntity record);
}