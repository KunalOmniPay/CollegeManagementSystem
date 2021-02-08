package com.mindtree.collegeManagementSystem.service;

import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeManagementServiceException;

public interface CollegeService {

	String addCollege(String nextLine) throws CollegeManagementServiceException;

	void updateStrength(String collegeName) throws CollegeManagementServiceException ;

	College getCollege(String collegeName) throws CollegeManagementServiceException;

	List<College> getAllCollege() throws CollegeManagementServiceException;

	List<College> sortCollegeList(List<College> collegeList);

}
