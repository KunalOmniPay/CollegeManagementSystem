package com.mindtree.collegeManagementSystem.service;

import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.Student;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeManagementServiceException;

public interface StudentService {

	String addStudent(Student studentData) throws CollegeManagementServiceException;

	List<Student> getStudentByCollegeName(String name, int i) throws CollegeManagementServiceException;

	List<Student> getStudentDataBasedOnCollegeAndSubject(String college, String subject) throws CollegeManagementServiceException;

	List<Student> sortStudentList( List<Student> studentList);

}
