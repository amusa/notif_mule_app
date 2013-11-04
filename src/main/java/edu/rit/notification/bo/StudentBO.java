package edu.rit.notification.bo;

import edu.rit.notification.entity2.Student;

public interface StudentBO extends GenericBO<Student, Integer> {
	public Student findByUID(String uid);

}
