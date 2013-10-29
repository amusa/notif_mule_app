package edu.rit.notification.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rit.notification.bo.EnrollmentBO;
import edu.rit.notification.dao.EnrollmentDAO;
import edu.rit.notification.entity2.Enrollment;


@Service("enrollmentBO")
@Transactional(readOnly = true)
public class EnrollmentBOImpl implements EnrollmentBO {
	@Autowired
	private EnrollmentDAO enrollmentDAO;

	@Override
	public void delete(Enrollment entity) throws Exception {
		enrollmentDAO.remove(entity);

	}

	@Override
	public Enrollment find(Integer id) throws Exception {

		return enrollmentDAO.findById(id);
	}

	@Override
	public List<Enrollment> findAll() throws Exception {

		return enrollmentDAO.findAll();
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public Enrollment persist(Enrollment entity) throws Exception {
		return enrollmentDAO.merge(entity);
	}

	@Override
	public void subscribe(String studentId, String classNumber) {
		System.out.println("**********In EnrollentBOImpl.subscribe()*************");
		enrollmentDAO.subscribe(studentId, classNumber);
		
	}


}
