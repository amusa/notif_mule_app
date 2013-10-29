package edu.rit.notification.bo;

import edu.rit.notification.entity2.Enrollment;

public interface EnrollmentBO extends GenericBO<Enrollment, Integer> {
	public void subscribe(String studentId, String classNumber);
}
