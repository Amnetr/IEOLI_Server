package com.ieoli.dao;

import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.ResultEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultEntityMapper {
    int countByExample(ResultEntityExample example);

    int deleteByExample(ResultEntityExample example);

    int deleteByPrimaryKey(Integer resultid);

    int insert(ResultEntity record);

    int insertSelective(ResultEntity record);

    List<ResultEntity> selectByExampleWithBLOBs(ResultEntityExample example);

    List<ResultEntity> selectByExample(ResultEntityExample example);

    ResultEntity selectByPrimaryKey(Integer resultid);

    int updateByExampleSelective(@Param("record") ResultEntity record, @Param("example") ResultEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") ResultEntity record, @Param("example") ResultEntityExample example);

    int updateByExample(@Param("record") ResultEntity record, @Param("example") ResultEntityExample example);

    int updateByPrimaryKeySelective(ResultEntity record);

    int updateByPrimaryKeyWithBLOBs(ResultEntity record);

    int updateByPrimaryKey(ResultEntity record);
}