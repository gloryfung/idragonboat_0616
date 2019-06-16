package com.idragonboat.timetask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Jobs implements Job{
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	    Date date=new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    System.out.println("Time:"+sf.format(date));
	    System.out.println("够钟睡觉了");
	 
	  }
}
