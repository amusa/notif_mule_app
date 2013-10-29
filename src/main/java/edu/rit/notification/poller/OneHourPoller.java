package edu.rit.notification.poller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import org.mule.api.annotations.Schedule;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.rit.notification.binding.PollingLoopback;
import edu.rit.notification.entity.ClassSchedule;

@Service
public class OneHourPoller implements Pollable<ClassSchedule> {
	private Queue<ClassSchedule> queue;
	private PollingLoopback loopback;
	TreeMap<String, List<ClassSchedule>> timeTable;

	Timer timer = new Timer();
	
	public OneHourPoller() {
		queue = new LinkedList<ClassSchedule>();
		/*timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
			    poll();
			  }
			}, 20*1000);*/
	}

	//@Override
	//@Scheduled(fixedDelay = 10000)
	//@Schedule(interval=5000)
	public synchronized void poll() {
		// add polling to this method to retrieve class due in one hour
		System.out.println("Once hour Poller Poll() is called");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 5);
		Date now = cal.getTime();
		String now24 = "0800";//getMilitaryTime(now);
		String first = timeTable.firstKey();
		
		System.out.println("FirstKey: " + first);
		
		if (first.equals(timeTable.floorKey(now24))) {
			System.out.println("match found...");
			Entry<String, List<ClassSchedule>> entry = timeTable
					.pollFirstEntry();
			System.out.println("********FirstEntry: " + entry);
			loopback.putScheduleList(entry.getValue());
		}

		/*
		 * while(!queue.isEmpty()){
		 * System.out.println("Sending to perminute queue"); ClassSchedule c =
		 * queue.poll(); System.out.println("loopback interface is " +
		 * loopback); loopback.putScheduleEvent(c); }
		 */
	}

	@Override
	public synchronized void receive(List<ClassSchedule> schedules) {
		timeTable = new TreeMap<String, List<ClassSchedule>>();

		List<ClassSchedule> list;

		System.out.println("OneHourPoller: Received class schedule list...");
		for (ClassSchedule c : schedules) {
			System.out.println("Enqueing One day queue...");
			String mt = null;
			try {
				mt = getMilitaryTime(c.getStartTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = timeTable.get(mt);
			if (list == null) {
				list = new ArrayList<ClassSchedule>();
				list.add(c);
				timeTable.put(mt, list);
			} else {
				list.add(c);
			}
			// queue.offer(c);

		}
		
	}
	

	private String getMilitaryTime(String time) throws ParseException {
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		Date date = timeFormat.parse(time);
		return getMilitaryTime(date);

	}

	private String getMilitaryTime(Date date) {
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new
																// calendar
																// instance
		calendar.setTime(date); // assigns calendar to given date
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		String strHour = ((hour < 10 ? "0" : "") + hour)
				+ ((minute < 10 ? "0" : "") + minute);
		return strHour;
	}

	public PollingLoopback getLoopback() {
		return loopback;
	}

	public void setLoopback(PollingLoopback loopback) {
		this.loopback = loopback;
	}

}
