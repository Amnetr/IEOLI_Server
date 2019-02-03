package com.ieoli.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.dao.TaskEntityMapper;
import com.ieoli.entity.TaskEntity;
import com.ieoli.entity.TaskEntityExample;
import com.ieoli.service.TaskService;

@Service("taskservice")
public class TaskSeriviceImpl implements TaskService {

	@Resource
	TaskEntityMapper mapper;
	@Override
	public List<TaskEntity> getTasks() {
		// TODO Auto-generated method stub
		 List<TaskEntity> lists;
		 TaskEntityExample me = new TaskEntityExample();
		 me.createCriteria();
		 me.or().andTaskdescriptionIsNotNull();
		 lists = mapper.selectByExample(me);
		 return lists;
	}
	@Override
	public void insertTask(String description) {
		// TODO Auto-generated method stub
		TaskEntity meEntity = new TaskEntity();
		meEntity.setTaskdescription(description);
		mapper.insert(meEntity);
		
	}
	@Override
	public void updateTask(int id, String description) {
		// TODO Auto-generated method stub
		TaskEntity meEntity = new TaskEntity();
		meEntity.setTaskid(id);
		meEntity.setTaskdescription(description);
		mapper.updateByPrimaryKey(meEntity);
	}
	@Override
	public List<TaskEntity> getTaskByIds(List<Integer> ids) {
		TaskEntityExample tee= new TaskEntityExample();
		tee.createCriteria().andTaskidIn(ids);
		return mapper.selectByExample(tee);
	}

}
