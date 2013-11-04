package edu.rit.notification.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.rit.notification.dao.EnrollmentDAO;
import edu.rit.notification.entity2.Enrollment;

@Repository
public class EnrollmentDAOImpl extends GenericDAOImpl<Enrollment, Integer>
		implements EnrollmentDAO {

	@Override
	public void subscribe(String studentId, String classNumber) {
		System.out.println("*********In EnrollmentDAOImpl.subscribe()*************");
		Query query = getCurrentSession()
				.createQuery(
						"update Enrollment set subscribe = :subscribe where uId = :uid and classNumber = :cn");
		query.setParameter("uid", studentId);
		query.setParameter("subscribe", -1);
		query.setParameter("cn", classNumber);
		query.executeUpdate();
	}

}
