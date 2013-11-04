package edu.rit.notification.service;

import java.util.List;

import javax.jws.WebService;

import edu.rit.notification.model.ClassSchedule;
import edu.rit.notification.model.EnrollmentRequest;
import edu.rit.notification.model.EnrollmentResponse;
import edu.rit.notification.model.SubscriptionRequest;
import edu.rit.notification.model.SubscriptionResponse;
import edu.rit.notification.entity2.Student;

@WebService
public interface StudentInfoSys {
	public Student getStudentProfile(String studentId); 
	public boolean studentIsEnrolled(String studentId, String classNumber);
	public List<Student> getStudentsEnrolled(String classNumber);
	public EnrollmentResponse enrollStudent(EnrollmentRequest request) throws Exception;
	public SubscriptionResponse subscribe(SubscriptionRequest request) throws Exception;
}
