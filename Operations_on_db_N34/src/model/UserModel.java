package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Users;

public class UserModel {
	public List<Users> listUsers(DataSource datasource) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet resultSet = null;
				List<Users> listUsers = new ArrayList<Users>();
				try {
					//1. Initialize connection objects
					conn = datasource.getConnection();
					
					//2. Create sql statements
					String query = "Select * from USERS"; // same as SELECT * FROM SYSTEM.USERS
					stmt = conn.createStatement();
					
					//3. Execute sql query
					resultSet = stmt.executeQuery(query);
					
					//4. Process the result set
					while(resultSet.next()) {
						listUsers.add(new Users(resultSet.getInt("USER_ID"), resultSet.getNString("USER_NAME"), resultSet.getString("EMAIL_ID")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return listUsers;
	}
	
	public void addUser(DataSource datasource, Users newUser) {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		String userName = newUser.getUserName();
		String emailId = newUser.getEmailId();
		
		try {
			//1. Initialize connection objects
			conn = datasource.getConnection();
			
			//2. Create sql statements
			String query = "insert into users (user_name, email_id) values (?, ?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, emailId);
			
			//3. Execute sql query
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateUser(DataSource datasource, Users updatedUser) {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Integer userId = updatedUser.getUserId();
		String userName = updatedUser.getUserName();
		String emailId = updatedUser.getEmailId();
		
		try {
			//1. Initialize connection objects
			conn = datasource.getConnection();
			
			//2. Create sql statements
			String query = "update users set user_name = ? , email_id = ? where user_id = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, emailId);
			preparedStatement.setInt(3, userId);
			
			//3. Execute sql query
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
public void deleteUser(DataSource datasource, Users updatedUser) {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Integer userId = updatedUser.getUserId();
		String userName = updatedUser.getUserName();
		String emailId = updatedUser.getEmailId();
		
		try {
			//1. Initialize connection objects
			conn = datasource.getConnection();
			
			//2. Create sql statements
			String query = "delete from users where user_id = ? and user_name = ? and email_id = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, emailId);
			
			//3. Execute sql query
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
