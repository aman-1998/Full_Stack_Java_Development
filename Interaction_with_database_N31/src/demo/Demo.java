package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/project")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Note: 1. In Oracle there can't be two tables with same name for the same user
		 *       2. In Oracle each User is considered a different schema
		 *       For eg. if with "SYSTEM" as a user, we made two connections in SQL Developer
		 *       with name "DEV_SCHEMA" and "QA_SCHEMA" respectively. For both connections,
		 *       insert query will be:- INSERT INTO "SYSTEM"."USER_TABLE" (USER_ID, USER_NAME, EMAIL_ID) VALUES ('1', 'avi_rock', 'avirock@gmail.com')
		 * 		 That even if there are two connections but there is only one schema with name "SYSTEM".
		 */
		
		
		//1. Initialize connection objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			conn = datasource.getConnection();
			
			//2. Create sql statements
			String query = "Select * from USERS"; // same as SELECT * FROM SYSTEM.USERS
			stmt = conn.createStatement();
			
			//3. Execute sql query
			resultSet = stmt.executeQuery(query);
			
			//4. Process the result set
			while(resultSet.next()) {
				response.getWriter().print(resultSet.getString("EMAIL_ID")+"<br>");
			}
			response.getWriter().print("==============================================================<br>");
			
			String query2 = "SELECT * FROM SYSTEM.USERS2";
			resultSet = stmt.executeQuery(query2);
			
			while(resultSet.next()) {
				response.getWriter().print(resultSet.getString("EMAIL_ID")+"<br>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
