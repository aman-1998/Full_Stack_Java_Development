package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Constants;
import entity.FilesInfo;
import model.FilesInfoDAO;
import model.FilesInfoDAOImpl;

@WebServlet("/galleryAppController")
public class GalleryAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
			case "listingimages": 
				listImages(request, response);
				break;
			case "imageupload": 
				uploadImages(request, response);
				break;
			default:
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
		}
	}

	private void uploadImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("imageUpload.jsp").forward(request, response);
	}

	private void listImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilesInfoDAO dao = new FilesInfoDAOImpl();
		List<FilesInfo> filesList = dao.listAllImages();
		request.setAttribute("filesList", filesList);
		request.setAttribute("path", Constants.path);
		request.getRequestDispatcher("listingImages.jsp").forward(request, response);
	}
}
