package com.ieoli.service;

import java.util.List;

import com.ieoli.entity.ModelEntity;

public interface ModelService {

	List<ModelEntity> getModels();
	void insertModel(String description, int section);
	void updateModel(int id, String description, int section);
	ModelEntity getModelByID(int id);
}
