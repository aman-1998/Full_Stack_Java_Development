package display;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display_Country
 */
@WebServlet("/Display_Country")
public class Display_Country extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_Country() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void display(HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().print("1. USA" + "<br>");
    	response.getWriter().print("2. China" + "<br>");
    	response.getWriter().print("1. Russia" + "<br>");
    	response.getWriter().print("1. India" + "<br>");
    	response.getWriter().print("1. Japan" + "<br>");
    }
}
