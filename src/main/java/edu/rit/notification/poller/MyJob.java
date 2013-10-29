package edu.rit.notification.poller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class MyJob implements Job {
	//@Autowired
	//private OneHourPoller poller;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Job exectuted...");
		//poller.poll();
		
	}

}
