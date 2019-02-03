package com.ieoli.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import com.ieoli.entity.TextEntity;
import com.ieoli.service.TextsService;

public class TextBehavior {

	@Resource
	private TextsService ts;
	public void update(TextEntity text){
		ts.updateText(text);
	}
	public TextEntity getByID(int id){
		return ts.getTextByID(id);
	}
	public void generateFile(int textid,int resultid,String path) throws FileNotFoundException, IOException{
		ts.generateFile(textid, resultid, path);
	}
}
