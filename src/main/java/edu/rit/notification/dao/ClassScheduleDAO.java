package edu.rit.notification.dao;

import edu.rit.notification.entity2.ClassSchedule;

public interface ClassScheduleDAO extends GenericDAO<ClassSchedule, Integer> {
   public ClassSchedule findByClassNumber(String classNumber);
}
