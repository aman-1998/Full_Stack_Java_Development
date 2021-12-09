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


@WebServlet("/imageUpload")
public class ImageUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> imageList = upload.parseRequest(request);
			for(FileItem image : imageList) {
				String imageName = image.getName();
				int lastIndexOfSlash = imageName.lastIndexOf("\\");
				imageName = imageName.substring(lastIndexOfSlash+1);
				System.out.println(imageName);
				image.write(new File("C://Users//DELL//Documents//images//"+imageName));
			}
		} catch (FileUploadException e) {
			System.out.println("Failed to upload file(s): "+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Failed to write file: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
