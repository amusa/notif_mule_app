package edu.rit.notification.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rit.notification.bo.StudentBO;
import edu.rit.notification.dao.StudentDAO;
import edu.rit.notification.entity2.Student;

@Service("studentBO")
@Transactional(readOnly = true)
public class StudentBOImpl implements StudentBO{
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Student persist(Student entity) throws Exception {
		
		return studentDAO.persist(entity);
	}

	@Override
	public void delete(Student entity) throws Exception {
		studentDAO.remove(entity);
		
	}

	@Override
	public Student find(Integer id) throws Exception {
		
		return studentDAO.findById(id);
	}

	@Override
	public List<Student> findAll() throws Exception {
		
		return studentDAO.findAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findByUID(String uid) {
		
		return studentDAO.findByUID(uid);
	}

}
