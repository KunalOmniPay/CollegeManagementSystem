package com.mindtree.collegeManagementSystem.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.Entity.Student;
import com.mindtree.collegeManagementSystem.dao.StudentDao;
import com.mindtree.collegeManagementSystem.exception.daoException.CollegeManagementDaoException;
import com.mindtree.collegeManagementSystem.exception.daoException.ConnectionFailedException;
import com.mindtree.collegeManagementSystem.exception.daoException.StudentDaoException;
import com.mindtree.collegeManagementSystem.utility.JdbcConnection;


public class StudentDaoImpl implements StudentDao {

	@Override
	public String addStudent(Student studentData) throws CollegeManagementDaoException {
		String message = "";
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new StudentDaoException(e.getMessage());

		}
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, studentData.getName());
			ps.setInt(2, studentData.getAge());
			ps.setString(3, studentData.getSubject());
			ps.setString(4,studentData.getCollege().getName());
			ps.executeUpdate();
			message = "student Added successfully";

		} catch (SQLException e) {
			throw new StudentDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Student> getStudentByCollegeName(String name, int strength) throws CollegeManagementDaoException {
		List<Student> studentList= new ArrayList<Student>();
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new StudentDaoException(e.getMessage());

		}
		String query = "select * from student where college_name = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				studentList.add(new Student( rs.getString(1), rs.getString(3), rs.getInt(2), new College(rs.getString(4),strength)));
			}
		} catch (SQLException e) {
			throw new StudentDaoException(e.getMessage());
		}
		return studentList;
		
	}

	@Override
	public List<Student> getStudentDataBasedOnCollegeAndSubject(String college, String subject)
			throws CollegeManagementDaoException {

		List<Student> studentList= new ArrayList<Student>();
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new StudentDaoException(e.getMessage());

		}
		String query = "select * from student where college_name = ? and subject =? order by age desc";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, college);
			ps.setString(2, subject);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				studentList.add(new Student( rs.getString(1), rs.getString(3), rs.getInt(2), new College(rs.getString(4),0)));
			}
		} catch (SQLException e) {
			throw new StudentDaoException(e.getMessage());
		}
		return studentList;
	
	
	
	
	}

}
