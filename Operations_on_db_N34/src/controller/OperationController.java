package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import entity.Users;
import model.UserModel;

@WebServlet("/operationController")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/project")
	private DataSource datasource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		operation = operation.toLowerCase();
		
		switch(operation) {
			case "listusers":
				loadListUsersPage(request, response);
				break;
			case "adduser":
				loadAddUserPage(request, response);
				break;
			case "updateuser":
				loadUpdateUserPage(request, response);
				break;
			case "deleteuser":
				deleteUserOperation(request, response);
				break;
			default:
				loadErrorPage(request, response);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		operation = operation.toLowerCase();
		
		switch(operation) {
			case "adduser":
				addUserOperation(request, response);
				break;
			case "updateuser":
				updateUserOperation(request, response);
				break;
			default:
				loadErrorPage(request, response);
				break;
		}
		
	}
	
	private void loadListUsersPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel userModel = new UserModel();
		List<Users> listOfUsers = userModel.listUsers(datasource);
		request.setAttribute("listOfUsers", listOfUsers);
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}
	
	private void loadAddUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}
	
	private void loadUpdateUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}

	private void loadErrorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	private void addUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String emailId = request.getParameter("emailId");    
		Users newUser = new Users(userName, emailId);
		UserModel userModel = new UserModel();
		userModel.addUser(datasource, newUser);
		loadListUsersPage(request, response);
	}
	
	private void updateUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String emailId = request.getParameter("emailId");
		Users updatedUser = new Users(userId, userName, emailId);
		UserModel userModel = new UserModel();
		userModel.updateUser(datasource, updatedUser);
		loadListUsersPage(request, response);
	}
	
	private void deleteUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String emailId = request.getParameter("emailId");
		Users toBeDeletedUser = new Users(userId, userName, emailId);
		UserModel userModel = new UserModel();
		userModel.deleteUser(datasource, toBeDeletedUser);
		loadListUsersPage(request, response);
	}
}
