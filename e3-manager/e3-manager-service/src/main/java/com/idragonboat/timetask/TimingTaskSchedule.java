package com.idragonboat.timetask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimingTaskSchedule implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			DemoTimeTask.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			DemoTimeTask.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
