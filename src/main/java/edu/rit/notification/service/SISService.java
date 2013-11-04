package edu.rit.notification.service;


import javax.jws.WebService;

import edu.rit.notification.entity2.Student;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "StudentInformationService", portName = "StudentInformationServicePort", endpointInterface = "edu.rit.notification.service.StudentInformationService", targetNamespace = "http://service.notification.rit.edu/", wsdlLocation = "WEB-INF/wsdl/SIS/localhost_8080/SIS/StudentInformationService.wsdl")
public interface SISService {

    public java.util.List<Student> getStudentSubscribed(java.lang.String classNumber);

    public java.util.List<Student> getStudentEnrolled(java.lang.String classNumber);

    public Student getStudentProfile(java.lang.String uid);
    
}

