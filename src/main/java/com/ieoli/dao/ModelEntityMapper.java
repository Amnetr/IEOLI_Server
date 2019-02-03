package com.ieoli.dao;

import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.ModelEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelEntityMapper {
    int countByExample(ModelEntityExample example);

    int deleteByExample(ModelEntityExample example);

    int deleteByPrimaryKey(Integer modelid);

    int insert(ModelEntity record);

    int insertSelective(ModelEntity record);

    List<ModelEntity> selectByExample(ModelEntityExample example);

    ModelEntity selectByPrimaryKey(Integer modelid);

    int updateByExampleSelective(@Param("record") ModelEntity record, @Param("example") ModelEntityExample example);

    int updateByExample(@Param("record") ModelEntity record, @Param("example") ModelEntityExample example);

    int updateByPrimaryKeySelective(ModelEntity record);

    int updateByPrimaryKey(ModelEntity record);
}