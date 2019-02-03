package com.ieoli.service;

import java.util.List;

import com.ieoli.entity.TaskEntity;

public interface TaskService {
	List<TaskEntity> getTasks();
	//TaskEntity getTaskByID(int id);
	void insertTask(String description);
	void updateTask(int id, String description);
	List<TaskEntity> getTaskByIds(List<Integer> ids);
}
