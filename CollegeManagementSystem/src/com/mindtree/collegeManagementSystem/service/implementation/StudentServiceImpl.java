package com.mindtree.collegeManagementSystem.service.implementation;

import java.util.Collections;
import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.Student;
import com.mindtree.collegeManagementSystem.dao.StudentDao;
import com.mindtree.collegeManagementSystem.dao.implementation.StudentDaoImpl;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeManagementServiceException;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeServiceException;
import com.mindtree.collegeManagementSystem.exception.ServiceException.StudentServiceException;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;
import com.mindtree.collegeManagementSystem.service.StudentService;

public class StudentServiceImpl implements StudentService {
	public static StudentDao studentDao = new StudentDaoImpl();
	@Override
	public String addStudent(Student studentData) throws CollegeManagementServiceException {
		String message="";
		try {
			message=studentDao.addStudent(studentData);
		} catch (CollegeManagementDaoException e) {
			throw new StudentServiceException(e.getMessage());
		}
		return message;
	}
	@Override
	public List<Student> getStudentByCollegeName(String name, int strength) throws CollegeManagementServiceException {
		List<Student> studentList=null;
		try {
			studentList=studentDao.getStudentByCollegeName(name, strength);
		} catch (CollegeManagementDaoException e) {
			throw new StudentServiceException(e.getMessage());
		}
		return studentList;
	}
	@Override
	public List<Student> getStudentDataBasedOnCollegeAndSubject(String college, String subject)
			throws CollegeManagementServiceException {
		List<Student> student=null;
		try {
			student = studentDao.getStudentDataBasedOnCollegeAndSubject(college, subject);
			return student;

		} catch (CollegeManagementDaoException e) {
			throw new StudentServiceException(e.getMessage());
		}
	}
	@Override
	public List<Student> sortStudentList(List<Student> studentList) {
		
		for (int i = 0; i < studentList.size() - 1; i++) {
			for (int j = 0; j < studentList.size() - i - 1; i++) {
				if (studentList.get(j).getAge()==studentList.get(j+1).getAge()) {
					int a = studentList.get(j).getName().compareTo(studentList.get(j+1).getName());
					if (a > 0) {
						Collections.swap(studentList, j, j+1);
					}
				}
			}
		}
		
		
		return studentList;
	}

}
