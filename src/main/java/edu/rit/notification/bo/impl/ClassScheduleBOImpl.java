package edu.rit.notification.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rit.notification.bo.ClassScheduleBO;
import edu.rit.notification.dao.ClassScheduleDAO;
import edu.rit.notification.entity2.ClassSchedule;

@Service("classScheduleBO")
@Transactional(readOnly = true)
public class ClassScheduleBOImpl implements ClassScheduleBO {

	@Autowired
	private ClassScheduleDAO classScheduleDAO;

	@Override
	public void delete(ClassSchedule entity) throws Exception {
		classScheduleDAO.remove(entity);

	}

	@Override
	public ClassSchedule find(Integer id) throws Exception {

		return classScheduleDAO.findById(id);
	}

	@Override
	public List<ClassSchedule> findAll() throws Exception {

		return classScheduleDAO.findAll();
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public ClassSchedule persist(ClassSchedule entity) throws Exception {
		return classScheduleDAO.merge(entity);
	}

	@Override
	public ClassSchedule findByClassNumber(String classNumber) {
		return classScheduleDAO.findByClassNumber(classNumber);
	}

}
