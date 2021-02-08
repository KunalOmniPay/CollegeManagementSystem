package com.mindtree.collegeManagementSystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.collegeManagementSystem.exception.daoException.ConnectionFailedException;




public class JdbcConnection {
	private static final String url = "jdbc:mysql://localhost:3306/CollegeManagement";
	private static final String username = "root";
	private static final String password = "123456";

	public static Connection getConnection() throws ConnectionFailedException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new ConnectionFailedException(e.getMessage());
		}

		return connection;
	}

	public static void closeResource(Connection connection) throws ConnectionFailedException {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new ConnectionFailedException(ex.getMessage());
			}
		}
	}

	public static void closeResource(PreparedStatement ps) throws ConnectionFailedException {

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException ex) {
				throw new ConnectionFailedException(ex.getMessage());
			}
		}
	}

	public static void closeResource(ResultSet rs) throws ConnectionFailedException {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				throw new ConnectionFailedException(ex.getMessage());
			}
		}
	}

}

