package com.ieoli.dao;

import com.ieoli.entity.TextEntity;
import com.ieoli.entity.TextEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TextEntityMapper {
    int countByExample(TextEntityExample example);

    int deleteByExample(TextEntityExample example);

    int deleteByPrimaryKey(Integer textid);

    int insert(TextEntity record);

    int insertSelective(TextEntity record);

    List<TextEntity> selectByExampleWithBLOBs(TextEntityExample example);

    List<TextEntity> selectByExample(TextEntityExample example);

    TextEntity selectByPrimaryKey(Integer textid);

    int updateByExampleSelective(@Param("record") TextEntity record, @Param("example") TextEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") TextEntity record, @Param("example") TextEntityExample example);

    int updateByExample(@Param("record") TextEntity record, @Param("example") TextEntityExample example);

    int updateByPrimaryKeySelective(TextEntity record);

    int updateByPrimaryKeyWithBLOBs(TextEntity record);

    int updateByPrimaryKey(TextEntity record);
}