package edu.rit.notification.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.rit.notification.dao.ClassScheduleDAO;
import edu.rit.notification.entity2.ClassSchedule;
import edu.rit.notification.entity2.Student;

@Repository
public class ClassScheduleDAOImpl extends GenericDAOImpl<ClassSchedule, Integer> implements ClassScheduleDAO {

	@Override
	public ClassSchedule findByClassNumber(String classNumber) {
		Query query = getCurrentSession().createQuery("from ClassSchedule where classNumber = :classNumber ");
		query.setParameter("classNumber", classNumber);
		ClassSchedule classSchedule = (ClassSchedule)query.uniqueResult();
		return classSchedule;
	}

}
