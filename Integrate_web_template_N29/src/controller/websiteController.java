package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/websiteController")
public class websiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public websiteController() {
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
				request.getRequestDispatcher("integrated_template_N1.jsp").forward(request, response);
				break;
			case "termsConditions":
				request.getRequestDispatcher("integrated_templated_N2.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("integrated_template_N1.jsp").forward(request, response);
				break;
		}
	}
}
