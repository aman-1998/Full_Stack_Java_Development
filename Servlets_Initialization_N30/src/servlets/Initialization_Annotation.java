package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Initialization_Annotation
 */
@WebServlet(
		urlPatterns = { "/Initialization_Annotation" }, 
		initParams = { 
				@WebInitParam(name = "message1", value = "I love my India", description = "This is just a demo1"),
				@WebInitParam(name = "message2", value = "I love my parents", description = "This is just a demo2")
		})
public class Initialization_Annotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Initialization_Annotation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String message1 = config.getInitParameter("message1");
		String message2 = config.getInitParameter("message2");
		response.getWriter().print(message1+"<br>"+message2);
	}
}
