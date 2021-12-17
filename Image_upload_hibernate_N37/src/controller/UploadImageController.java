package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.FilesInfo;
import model.FilesInfoDAO;
import model.FilesInfoDAOImpl;

@WebServlet("/image-upload")
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Path where selected images are saved
	 */
	String path = "C://Users//DELL//Documents//images//";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
		
			case "uploadimage": 
				fileUpload(request, response);
				break;
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
		}
	}

	private void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> imageList = upload.parseRequest(request);
			for(FileItem image : imageList) {
				String imageName = image.getName();
				int lastIndexOfSlash = imageName.lastIndexOf("\\");
				imageName = imageName.substring(lastIndexOfSlash+1);
				System.out.println(imageName);
				File file = new File(path+imageName);
				if(!file.exists()) {
					image.write(file);
					FilesInfoDAO dao = new FilesInfoDAOImpl();
					dao.addDetails(new FilesInfo(imageName));
				}
			}
		} catch (FileUploadException e) {
			System.out.println("Failed to upload file(s): "+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Failed to write file(s): "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
