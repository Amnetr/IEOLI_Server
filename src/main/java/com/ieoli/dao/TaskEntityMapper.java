package com.ieoli.dao;

import com.ieoli.entity.TaskEntity;
import com.ieoli.entity.TaskEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskEntityMapper {
    int countByExample(TaskEntityExample example);

    int deleteByExample(TaskEntityExample example);

    int deleteByPrimaryKey(Integer taskid);

    int insert(TaskEntity record);

    int insertSelective(TaskEntity record);

    List<TaskEntity> selectByExample(TaskEntityExample example);

    TaskEntity selectByPrimaryKey(Integer taskid);

    int updateByExampleSelective(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    int updateByExample(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    int updateByPrimaryKeySelective(TaskEntity record);

    int updateByPrimaryKey(TaskEntity record);
}