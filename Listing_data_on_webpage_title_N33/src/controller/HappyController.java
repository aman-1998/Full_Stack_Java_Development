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
import model.UsersModel;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/HappyController")
public class HappyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/project")
	private DataSource datasource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HappyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		switch(page) {
			case "home":
				request.setAttribute("title", "Home");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "termsConditions":
				request.setAttribute("title", "Terms & Conditions");
				request.getRequestDispatcher("Terms_and_conditions.jsp").forward(request, response);
				break;
			case "details":
				UsersModel usersModel = new UsersModel();
				List<Users> listUsers = usersModel.listUsers(datasource);
				request.setAttribute("listUsers", listUsers);
				request.setAttribute("title", "Details");
				request.getRequestDispatcher("details.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("title", "Error");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
		}
	}
}
