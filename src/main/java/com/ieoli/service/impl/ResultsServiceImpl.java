package com.ieoli.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.Utils.PropertyUtil;
import com.ieoli.Utils.ResultIndex;
import com.ieoli.dao.ResultEntityMapper;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.ResultEntityExample;
import com.ieoli.service.ResultsService;
@Service("resultsservice")
public class ResultsServiceImpl implements ResultsService {

	@Resource
	private ResultEntityMapper resultMapper;
	
	@Override
	public boolean insertResult(ResultEntity result) {
		// TODO Auto-generated method stub
		ResultEntityExample ree = new ResultEntityExample();
		ree.createCriteria().andTextidEqualTo(result.getTextid()).andUseridEqualTo(result.getUserid()).andModelidEqualTo(result.getModelid()).andUsefulEqualTo(true);
		if(resultMapper.selectByExample(ree).isEmpty())
		{
			resultMapper.insert(result);
			return true;
		}else {
			//resultMapper.updateByExampleSelective(result, ree);
			return false;
		}
		

	}

	@Override
	public List<ResultEntity> getResultByTextID(int textid) {
		// TODO Auto-generated method stub
		ResultEntityExample resultExample=new ResultEntityExample();
		resultExample.createCriteria().andTextidEqualTo(textid).andUsefulEqualTo(true);
		List<ResultEntity> results=resultMapper.selectByExampleWithBLOBs(resultExample);
		
		return results;
	}

	@Override
	public void deleteResultByID(int id) {
		// TODO Auto-generated method stub
		ResultEntity resultEntity =new ResultEntity();
		resultEntity.setResultid(id);
		resultEntity.setUseful(false);
		resultMapper.updateByPrimaryKeySelective(resultEntity);
	}

	@Override
	public void updateResult(ResultEntity result) {
		// TODO Auto-generated method stub
		resultMapper.updateByPrimaryKeySelective(result);
	}

	@Override
	public List<ResultEntity> getResultByTaskID(int taskid, int textid) {
		// TODO Auto-generated method stub
		ResultEntityExample resultExample=new ResultEntityExample();
		resultExample.createCriteria().andTextidEqualTo(textid).andModelidEqualTo(taskid).andUsefulEqualTo(true);
		List<ResultEntity> results=resultMapper.selectByExampleWithBLOBs(resultExample);
		
		return results;
	}

	//return textids
	@Override
	public HashSet<Integer> usernotlike(List<Integer> taskid, int userid) {
		ResultEntityExample ree= new ResultEntityExample();
		ree.createCriteria().andUseridEqualTo(userid).andModelidIn(taskid).andUsefulEqualTo(true);//userid这个人对taskid内任务的结果
		List<ResultEntity> results=resultMapper.selectByExample(ree);
		HashSet<Integer> textids = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (ResultEntity res : results)//遍历所有结果，将结果保存到map中，map中存 textid 出现次数， 若出现次数与task相等，则将textid放入return
		{
			if(!map.containsKey(res.getTextid()))
			{
				map.put(res.getTextid(), 1);
			}else {
				map.put(res.getTextid(), map.get(res.getTextid())+1);
			}
		}
		for(Entry<Integer, Integer> etr:map.entrySet())
		{
			if(etr.getValue()==taskid.size())
			{
				textids.add(etr.getKey());
			}
		}
		return textids;
	}

	@Override
	public HashSet<Integer> donotneed(List<Integer> taskid) {
		// TODO Auto-generated method stub
		ResultEntityExample ree= new ResultEntityExample();
		int condition = Integer.parseInt(PropertyUtil.getProperty("condition"));
		if(condition==0)
		{
			ree.createCriteria().andModelidIn(taskid).andIsstricttrueEqualTo(true).andUsefulEqualTo(true);//taskid内任务的结果
		}else {
			ree.createCriteria().andModelidIn(taskid).andIseasytrueEqualTo(true).andUsefulEqualTo(true);//taskid内任务的结果
		}
		
		List<ResultEntity> results=resultMapper.selectByExample(ree);
		HashSet<Integer> textids = new HashSet<>();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (ResultEntity res : results)
		{
			if(!map.containsKey(res.getTextid()))
			{
				HashSet<Integer> tasks = new HashSet<>();
				tasks.add(res.getModelid());
				map.put(res.getTextid(), tasks);
			}else
			{
				HashSet<Integer> tasks=map.get(res.getTextid());
				tasks.add(res.getModelid());
				map.put(res.getTextid(), tasks);
			}
		}
		for(Entry<Integer,  HashSet<Integer>> etr:map.entrySet())
		{
			if(etr.getValue().size()==taskid.size())
			{
				textids.add(etr.getKey());
			}
		}
		return textids;
	}

	@Override
	public List<ResultEntity> downloadRes(List<Integer> taskid) {
		ResultEntityExample ree= new ResultEntityExample();
		int condition = Integer.parseInt(PropertyUtil.getProperty("condition"));
		if(condition==0)
		{
			ree.createCriteria().andModelidIn(taskid).andIsstricttrueEqualTo(true).andUsefulEqualTo(true);//taskid内任务的结果
		}else {
			ree.createCriteria().andModelidIn(taskid).andIseasytrueEqualTo(true).andUsefulEqualTo(true);//taskid内任务的结果
		}
	
		List<ResultEntity> results=resultMapper.selectByExampleWithBLOBs(ree);
		HashMap<ResultIndex, ResultEntity> map = new HashMap<>();
		for(ResultEntity result:results)
		{
			ResultIndex index= new ResultIndex(result.getTextid(), result.getModelid());
			if(!map.containsKey(index))
			{
				map.put(index, result);
			}
		}
		//利用重载hashcode并放入map ，对结果进行去重
		//////需要筛选出符合条件的result
		HashMap<Integer,HashSet<ResultEntity>> groupbytaskid= new HashMap<>();
		for(int id:taskid)
		{
			HashSet<ResultEntity> temp = new HashSet<>();
			for(Entry<ResultIndex, ResultEntity> entry:map.entrySet())
			{
				if(entry.getValue().getModelid()==id)
				{
					temp.add(entry.getValue());
				}
			}
			groupbytaskid.put(id, temp);
		}
		HashSet<ResultEntity> initSet = groupbytaskid.get(taskid.get(0));
		HashSet<Integer> textids = new HashSet<>();
		for(ResultEntity q:initSet)
		{
			textids.add(q.getTextid());
		}
		for(Entry<Integer,HashSet<ResultEntity>> e:groupbytaskid.entrySet())
		{
			HashSet<ResultEntity> cur =e.getValue();
			HashSet<Integer> curtextid = new HashSet<>();
			for(ResultEntity q:cur)
			{
				curtextid.add(q.getTextid());
			}
			textids.retainAll(curtextid);
		}
		//获得了所有合法的textid
		ArrayList<ResultEntity> toR= new ArrayList<>();
		for(ResultEntity result:results)
		{
			if(textids.contains(result.getTextid()))
			{
				toR.add(result);
			}
		}
		return toR;
	}

	@Override
	public void setTrue(ResultEntity result) {
		ResultEntityExample ree = new ResultEntityExample();
		ree.createCriteria().andTextidEqualTo(result.getTextid()).andUseridEqualTo(result.getUserid()).andModelidEqualTo(result.getModelid());
		int condition = Integer.parseInt(PropertyUtil.getProperty("condition"));
		if(condition==0)
		{
			result.setIsstricttrue(true);
		}else {
			result.setIseasytrue(true);
		}
		
		resultMapper.updateByExampleSelective(result,ree);
		
	}

	

}
