package edu.rit.notification.bo;

import edu.rit.notification.entity2.ClassSchedule;

public interface ClassScheduleBO extends GenericBO<ClassSchedule, Integer> {
	public ClassSchedule findByClassNumber(String classNumber);
}
