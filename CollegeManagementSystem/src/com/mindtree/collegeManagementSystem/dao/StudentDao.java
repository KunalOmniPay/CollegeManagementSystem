package com.mindtree.collegeManagementSystem.dao;

import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.Student;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;

public interface StudentDao {

	String addStudent(Student studentData) throws CollegeManagementDaoException;

	List<Student> getStudentByCollegeName(String name, int strength) throws CollegeManagementDaoException;

	List<Student> getStudentDataBasedOnCollegeAndSubject(String college, String subject) throws CollegeManagementDaoException;

}
