package edu.rit.notification.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.rit.notification.entity2.Student;
import edu.rit.notification.dao.StudentDAO;

@Repository
public class StudentDAOImpl extends GenericDAOImpl<Student, Integer> implements StudentDAO  {

	@Override
	public Student findByUID(String uid) {
		Query query = getCurrentSession().createQuery("from Student where uid = :uid ");
		query.setParameter("uid", uid);
		Student student = (Student)query.uniqueResult();
		return student;
	}

	
}
