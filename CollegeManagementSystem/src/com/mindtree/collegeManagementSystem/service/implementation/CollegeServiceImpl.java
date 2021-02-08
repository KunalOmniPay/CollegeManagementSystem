package com.mindtree.collegeManagementSystem.service.implementation;

import java.util.Collections;
import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.dao.CollegeDao;
import com.mindtree.collegeManagementSystem.dao.implementation.CollegeDaoImpl;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeManagementServiceException;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeServiceException;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;
import com.mindtree.collegeManagementSystem.service.CollegeService;


public class CollegeServiceImpl implements CollegeService {
	private static CollegeDao collegeDao = new CollegeDaoImpl(); 
	@Override
	public String addCollege(String collegeName) throws CollegeManagementServiceException {
		String message="";
		try {
			message = collegeDao.addCollege(collegeName);
		} catch (CollegeManagementDaoException e) {
			throw new CollegeServiceException(e.getMessage());
			
		}
		return message;
		
	}
	@Override
	public void updateStrength(String collegeName) throws CollegeManagementServiceException {

		try {
			collegeDao.updateCount(collegeName);
		} catch (CollegeManagementDaoException e) {
			throw new CollegeServiceException(e.getMessage());
		}
	}
	@Override
	public College getCollege(String collegeName) throws CollegeManagementServiceException {
		College college=null;
		try {
			college=collegeDao.getCollege(collegeName);
			return college;
		} catch (CollegeManagementDaoException e) {
			throw new CollegeServiceException(e.getMessage());
		}
		
	}
	@Override
	public List<College> getAllCollege() throws CollegeManagementServiceException {
		List<College> college = null;
		try {
			college=collegeDao.getAllCollege();
			return college;
		} catch (CollegeManagementDaoException e) {
			throw new CollegeServiceException(e.getMessage());
		}
	}
	@Override
	public List<College> sortCollegeList(List<College> collegeList) {
		for (int i = 0; i < collegeList.size() - 1; i++) {
			for (int j = 0; j < collegeList.size() - i - 1; i++) {
				if (collegeList.get(j).getStrengthOfStudents()==collegeList.get(j+1).getStrengthOfStudents()) {
					int a = collegeList.get(j).getName().compareTo(collegeList.get(j+1).getName());
					if (a > 0) {
						Collections.swap(collegeList, j, j+1);
					}
				}
			}
		}
		return collegeList;
	}


}
