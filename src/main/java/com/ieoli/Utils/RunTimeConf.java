package com.ieoli.Utils;

import java.util.Timer;
import java.util.TimerTask;

import com.ieoli.service.TextsService;


public class RunTimeConf extends TimerTask{
private long timeclose=0;
private int textid = 0;
private Timer timer;

public RunTimeConf(Timer timer,int teid) {
    this.timer = timer;
    timeclose = System.currentTimeMillis()+60*3600*1000;
    textid=teid;
}
public void run() {
	// TODO Auto-generated method stub
	if(System.currentTimeMillis()>timeclose)
	{
		TextsService ts = (TextsService) SpringInit.getApplicationContext().getBean("textsservice");
		ts.offline(textid);
		//
		System.out.print("closed!!!!");
		timeclose=0;
		this.timer.cancel();
	}
	//System.out.println(timeclose);
}

}