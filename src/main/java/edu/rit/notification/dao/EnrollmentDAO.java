package edu.rit.notification.dao;

import edu.rit.notification.entity2.Enrollment;

public interface EnrollmentDAO extends GenericDAO<Enrollment, Integer> {
      public void subscribe(String studentId, String classNumber);
}
