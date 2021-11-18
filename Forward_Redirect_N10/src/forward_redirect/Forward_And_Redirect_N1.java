package forward_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forward_And_Redirect_N1
 */
@WebServlet("/Forward_And_Redirect_N1")
public class Forward_And_Redirect_N1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward_And_Redirect_N1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("This content is from Forward_And_Redirect_N1.java");
		request.getRequestDispatcher("Forward_And_Redirect_N2").forward(request, response);
	}

}
