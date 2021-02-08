package com.mindtree.collegeManagementSystem.dao;

import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;

public interface CollegeDao {

	String addCollege(String collegeName) throws CollegeManagementDaoException;

	void updateCount(String collegeName) throws CollegeManagementDaoException;
	College getCollege(String collegeName) throws CollegeManagementDaoException;

	List<College> getAllCollege() throws CollegeManagementDaoException;

	

}
