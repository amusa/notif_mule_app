package edu.rit.notification.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rit.notification.bo.ClassScheduleBO;
import edu.rit.notification.bo.EnrollmentBO;
import edu.rit.notification.bo.StudentBO;
import edu.rit.notification.entity2.ClassSchedule;
import edu.rit.notification.entity2.Enrollment;
import edu.rit.notification.entity2.Student;
import edu.rit.notification.model.EnrollmentRequest;
import edu.rit.notification.model.EnrollmentResponse;
import edu.rit.notification.model.Status;
import edu.rit.notification.model.SubscriptionRequest;
import edu.rit.notification.model.SubscriptionResponse;
import edu.rit.notification.service.StudentInfoSys;

@Service
public class StudentInfoSysImpl implements StudentInfoSys {
	@Autowired
	private StudentBO studentBO;

	@Autowired
	private EnrollmentBO enrollmentBO;
	
	@Autowired
	private ClassScheduleBO classScheduleBO;
	
	@Override
	public Student getStudentProfile(String studentId) {
		System.out.println("********In getStudentProfile() method*******");
		// TODO replace with database call
//		Student student = new Student();
//		student.setuId(studentId);
//		student.setFirstName("Firstname");
//		student.setLastName("Lastname");
//		student.setEmail("firstname.lastname@email.com");
//		student.setPhoneNumber("5945030450");
        
		return studentBO.findByUID(studentId);
	}

	@Override
	public boolean studentIsEnrolled(String studentId, String classNumber) {
		// TODO replace with database calls
		Random rand = new Random();
		return rand.nextInt(2) == 1 ? true : false;
	}

	@Override
	public List<Student> getStudentsEnrolled(String classNumber) {
		System.out.println("********In getStudentsEnrolled() method*******");
		
		ClassSchedule classSchedule = classScheduleBO.findByClassNumber(classNumber);
		
//		List<Student> studentList = new ArrayList<Student>();
//		//populate students from database
//		//use a map of list
//		studentList.add(new Student("990801234", "Adam", "Jones", "adam.jones@email.com", "949493494"));
//		studentList.add(new Student("990105678", "Peter", "Brown", "pbrown.@hotmail.com", "2345645645"));
//		studentList.add(new Student("994305741", "Ola", "Rock", "ola.rock@rit.com", "078675449"));
//		studentList.add(new Student("990305942", "Ben", "Chris", "ben.chris@email.com", "456465645"));
		
		System.out.println("Number of students enrolled: " + classSchedule.getEnrolledStudents().size() );
 		
		return classSchedule.getEnrolledStudents();
	}

	@Override
	public EnrollmentResponse enrollStudent(EnrollmentRequest request)throws Exception {
		Enrollment enrollment = new Enrollment();
		//TODO: populate enrollment entity
		enrollmentBO.persist(enrollment);

        EnrollmentResponse response = new EnrollmentResponse();
        response.setStatus(Status.OK);
		return response;
	}

	@Override
	public SubscriptionResponse subscribe(SubscriptionRequest request)
			throws Exception {
		System.out.println("*******In StudentInfoSystImpl.subscribe() Method********"+ request);
		SubscriptionResponse response = new SubscriptionResponse();
		if(enrollmentBO != null){
			System.out.println("*******EnrollmentBO is NOT null***********");
		    enrollmentBO.subscribe(request.getStudentId(), request.getClassNumber());		
	        response.setStatus(Status.OK);
	        response.setResponse("Success");
			
		}else{
			System.out.println("***********EnrollmentBO is null***********");
			response.setStatus(Status.FAIL);
			response.setResponse("failure");
		}
		return response;
	}

}
