package display;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display_List
 */
@WebServlet("/Display_List")
public class Display_List<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_List() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void display(List<T> arr, HttpServletResponse response) throws IOException, ServletException {
    	for(Iterator<T> ite = arr.iterator(); ite.hasNext();) {
    		response.getWriter().print(ite.next() + " ");
    	}
    }
}
