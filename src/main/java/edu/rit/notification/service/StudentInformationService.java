package edu.rit.notification.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.rit.notification.entity.ClassSchedule;
import edu.rit.notification.entity.Student;
import edu.rit.notification.model.EnrollmentRequest;
import edu.rit.notification.model.SubscriptionRequest;
import edu.rit.notification.model.SubscriptionResponse;

@WebService(serviceName = "StudentInformationService")
public interface StudentInformationService {

	@WebMethod(operationName = "getEnrollement")
	public List<Student> getEnrollement(
			@WebParam(name = "enrollmentRequest") EnrollmentRequest request);

	@WebMethod(operationName = "getStudentSubscribed")
	public List<Student> getStudentSubscribed(
			@WebParam(name = "classNumber") String classNumber);

	@WebMethod(operationName = "getStudentEnrolled")
	public List<Student> getStudentEnrolled(
			@WebParam(name = "classNumber") String classNumber);

	@WebMethod(operationName = "getStudentProfile")
	public Student getStudentProfile(@WebParam(name = "uid") String uid);
	
	
	@WebMethod(operationName = "getClassScheduleForToday")
	public List<ClassSchedule> getClassScheduleForToday();
	
	 @WebMethod(operationName = "subscribe")
	 public SubscriptionResponse subscribe(@WebParam(name = "subscriptionRequest") SubscriptionRequest request); 
}
