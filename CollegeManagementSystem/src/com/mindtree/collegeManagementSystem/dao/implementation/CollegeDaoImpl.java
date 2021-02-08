package com.mindtree.collegeManagementSystem.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.dao.CollegeDao;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeDaoException;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;
import com.mindtree.collegeManagementSystem.exception.daoException.ConnectionFailedException;
import com.mindtree.collegeManagementSystem.utility.JdbcConnection;

public class CollegeDaoImpl implements CollegeDao {

	@Override
	public String addCollege(String collegeName) throws CollegeManagementDaoException {
		
		String message = "";
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new CollegeDaoException(e.getMessage());

		}
		String query = "insert into college values(?,0)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, collegeName);
			ps.executeUpdate();
			message = "College Added successfully";

		} catch (SQLException e) {
			throw new CollegeDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public void updateCount(String collegeName) throws CollegeManagementDaoException {
		
		String message = "";
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new CollegeDaoException(e.getMessage());

		}
		College college=getCollege(collegeName);
		String query = "update college set strength=? where college_name = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, college.getStrengthOfStudents()+1);
			ps.setString(2, collegeName);
			ps.executeUpdate();
			message = "College updated successfully";

		} catch (SQLException e) {
			throw new CollegeDaoException(e.getMessage());
		}
		
	}

	public College getCollege(String collegeName) throws CollegeManagementDaoException {
		
		String message = "";
		College college=null;
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new CollegeDaoException(e.getMessage());

		}
		String query = "select * from college where college_name=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, collegeName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			college=new College(rs.getString(1), rs.getInt(2));
			

		} catch (SQLException e) {
			throw new CollegeDaoException(e.getMessage());
		}
		return college;
	}

	@Override
	public List<College> getAllCollege() throws CollegeManagementDaoException {
		List <College> college =new ArrayList<>();
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new CollegeDaoException(e.getMessage());

		}
		String query = "select * from college";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			college.add(new College(rs.getString(1), rs.getInt(2)));
			}

		} catch (SQLException e) {
			throw new CollegeDaoException(e.getMessage());
		}
		return college;
	
	}

}
