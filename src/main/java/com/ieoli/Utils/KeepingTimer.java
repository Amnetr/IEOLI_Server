package com.ieoli.Utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

public class KeepingTimer extends TimerTask{
private Date currentTime;
private Timer timer;
public KeepingTimer(Date date,Timer t){
currentTime=date;	
timer = t;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long current= System.currentTimeMillis();
		long hourbet = (current-currentTime.getTime())/(1000*3600);
		if(hourbet>=7)
		{
			UserService as = (UserService)SpringInit.getApplicationContext().getBean("userservice");
			UserEntity ue = new UserEntity();
			ue.setUsername("sadad");
			ue.setUserpassword("sda");
			as.login(ue);
		}
		System.out.print("connected!");
	}

}
