package com.ieoli.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.Utils.PropertyUtil;
import com.ieoli.dao.ResultEntityMapper;
import com.ieoli.dao.RuleEntityMapper;
import com.ieoli.dao.TextEntityMapper;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.ResultEntityExample;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.TextEntityExample;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TextsService;
@Service("textsservice")
public class TextsServiceImpl implements TextsService {
	
	@Resource
	private TextEntityMapper textMapper;
	@Resource
	private RuleEntityMapper ruleMapper;
	@Resource
	private ResultEntityMapper resultMapper;
	@Resource
	private ResultsService rs;

	@Override
	public TextEntity getTextByID(int id) {
		// TODO Auto-generated method stub
		return textMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void updateText(TextEntity text){
		
		textMapper.updateByPrimaryKeySelective(text);
	}

	@Override
	public List<TextEntity> getHandledText(int modelid) {
		// TODO Auto-generated method stub
		ResultEntityExample ree=new ResultEntityExample();
		int condition = Integer.parseInt(PropertyUtil.getProperty("condition"));
		if(condition==0)
		{
			ree.createCriteria().andModelidEqualTo(modelid).andIsstricttrueEqualTo(true);
		}else {
			ree.createCriteria().andModelidEqualTo(modelid).andIseasytrueEqualTo(true);
		}
		
		List<ResultEntity> re=resultMapper.selectByExample(ree);
		HashSet<Integer> testids=new HashSet<Integer>();
		for(int i=0;i<re.size();i++){
			testids.add(re.get(i).getTextid());
		}
		List<TextEntity> texts=new ArrayList<TextEntity>();
		Iterator<Integer> it=testids.iterator();
		while(it.hasNext()){
			texts.add(textMapper.selectByPrimaryKey(it.next()));
		}
		return texts;
	}

	@Override
	public void generateFile(int textid,int resultid,String path) throws IOException {
		// TODO Auto-generated method stub
		String article=textMapper.selectByPrimaryKey(textid).getArticle();
		String label=resultMapper.selectByPrimaryKey(resultid).getLabel();
		String word[]=article.split("\\$");
		String labels[]=label.split("\\$");
		int sort[]=new int[labels.length];
		//Arrays.sort(labels);
		//去除单词编号
		for(int i=0;i<labels.length;i++){
			String withoutNum[]=labels[i].split("&");
			labels[i]=withoutNum[1];
			sort[i]=Integer.parseInt(withoutNum[0])-1;
		}
		//附上标签
		for(int i=0;i<sort.length;i++){
			word[sort[i]]=word[sort[i]]+"&"+labels[i];
		}
		
		File text=new File(path);
		FileOutputStream outputStream = new FileOutputStream(text);
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
		for(int i=0;i<word.length;i++){
			bufferedWriter.write(word[i]+"\r\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	

	@Override
	public void insertFile(TextEntity text) {
		// TODO Auto-generated method stub
		textMapper.insert(text);
	}

	@Override
	public List<TextEntity> getTexts() {
		// TODO Auto-generated method stub
		TextEntityExample textExample=new TextEntityExample();
		textExample.createCriteria();
		List<TextEntity> texts=textMapper.selectByExampleWithBLOBs(textExample);
		return texts;
	}

	@Override
	public TextEntity getTextsByUser(int userid,List<Integer> taskid) {
		// TODO Auto-generated method stub
		TextEntityExample tee = new TextEntityExample();
		tee.createCriteria().andOnlineEqualTo(0);
		List<TextEntity> alltext =textMapper.selectByExampleWithBLOBs(tee);
		List<TextEntity> te=new ArrayList<TextEntity>();
		HashSet<Integer> usernotlike=rs.usernotlike(taskid, userid);
		HashSet<Integer> noneed= rs.donotneed(taskid);
		for(TextEntity entity :alltext)
		{
			if(!(usernotlike.contains(entity.getTextid())||noneed.contains(entity.getTextid())))
			{
				te.add(entity);
			}
		}
		List<Integer> textsid=new ArrayList<Integer>();
		for(int i=0;i<te.size();i++){
			textsid.add(te.get(i).getTextid());
		}
		int number;
		Random random =new Random(System.currentTimeMillis());
		if(textsid.size()>1)
		{
			number = random.nextInt(textsid.size());
		}else if(textsid.size()>0)
		{
			number=0;
		}else {
			return null;
		}
		TextEntity pEntity = textMapper.selectByPrimaryKey(textsid.get(number));
		pEntity.setOnline(1);
		textMapper.updateByPrimaryKeySelective(pEntity);
		return  pEntity;
	}

	@Override
	public List<TextEntity> getTextByIDs(List<Integer> textids) {
		TextEntityExample tee= new TextEntityExample();
		tee.createCriteria().andTextidIn(textids);
		return textMapper.selectByExampleWithBLOBs(tee);
	}

	@Override
	public void offline(int textid) {
		TextEntity te= new TextEntity();
		te.setTextid(textid);
		te.setOnline(0);
		textMapper.updateByPrimaryKeySelective(te);		
	}

}
