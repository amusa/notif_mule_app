package edu.rit.notification.dao;

import edu.rit.notification.entity2.Student;

public interface StudentDAO extends GenericDAO<Student, Integer>{
	public Student findByUID(String uid);
}
