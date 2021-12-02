package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Users;

public class UsersModel {
	public List<Users> listUsers(DataSource datasource) {
		//1. Initialize connection objects
				Connection conn = null;
				Statement stmt = null;
				ResultSet resultSet = null;
				List<Users> listUsers = new ArrayList<Users>();
				try {
					
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
}
