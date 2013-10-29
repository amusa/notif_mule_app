package edu.rit.notification.poller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.rit.notification.binding.PollingLoopback;
import edu.rit.notification.entity.ClassSchedule;

@Service
public class PerMinutePoller implements Pollable<ClassSchedule> {
	private Queue<ClassSchedule> queue;
	private PollingLoopback loopback;

	public PerMinutePoller() {
		queue = new LinkedList<ClassSchedule>();
	}

	//@Override
	//@Scheduled(fixedDelay = 5000)
	public synchronized void poll() {
		// add polling to this method to retrieve class due in one hour
		System.out.println("Per Minute Poller Poll() is called");
		
		while(!queue.isEmpty()){
			System.out.println("Sending to timeout queue");
			ClassSchedule c = queue.poll();
			loopback.putScheduleEvent(c);
		}
	}

	@Override
	public synchronized void receive(List<ClassSchedule> schedules) {
		System.out.println("PerMinutePoller: Received class schedule list...");
		// TODO Auto-generated method stub
		for (ClassSchedule c : schedules) {
			System.out.println("Enqueing One hour queue...");
			queue.offer(c);

		}

	}

	public PollingLoopback getLoopback() {
		return loopback;
	}

	public void setLoopback(PollingLoopback loopback) {
		this.loopback = loopback;
	}

}
