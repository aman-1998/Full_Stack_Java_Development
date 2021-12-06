package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/applicationController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
			case "home":
				loadHomePage(request, response);
				break;
			case "termsconditions":
				loadTermsConditionsPage(request, response);
				break;
			case "articledetails":
				loadArticleDetailsPage(request, response);
				break;
			case "privacypolicy":
				loadPrivacyPolicy(request, response);
				break;
			default:
				loadErrorPage(request, response);
				break;
		}
	}
	
	private void loadHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void loadTermsConditionsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("terms_and_conditions.jsp").forward(request, response);
	}
	
	private void loadArticleDetailsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("article_details.jsp").forward(request, response);
	}
	
	private void loadPrivacyPolicy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("privacy_policy.jsp").forward(request, response);
	}
	
	private void loadErrorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}
