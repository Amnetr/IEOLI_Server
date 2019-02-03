package com.ieoli.service;

import java.util.HashSet;
import java.util.List;

import com.ieoli.entity.ResultEntity;

public interface ResultsService {

	public boolean insertResult(ResultEntity result);
	public List<ResultEntity> getResultByTextID(int textid);
	public HashSet<Integer> usernotlike(List<Integer> taskid, int userid);
	public HashSet<Integer> donotneed(List<Integer> taskid);
	public List<ResultEntity> downloadRes(List<Integer> taskid);
	public void deleteResultByID(int id);
	public void updateResult(ResultEntity result);
	public List<ResultEntity> getResultByTaskID(int taskid, int textid);
	public void setTrue(ResultEntity result);
}
