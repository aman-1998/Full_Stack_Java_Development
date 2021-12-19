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

import common.Constants;
import entity.FilesInfo;
import model.FilesInfoDAO;
import model.FilesInfoDAOImpl;

@WebServlet("/image-upload")
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		operation = operation.toLowerCase();
		
		switch(operation) {
			case "uploadimage": 
				fileUpload(request, response);
				listImages(request, response);
				break;
			case "updatedetails": 
				updateImage(request, response);
				listImages(request, response);
				break;
			case "deleteimage": 
				deleteImage(request, response);
				listImages(request, response);
				break;
			default:
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
		}
	}

	private void deleteImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileId = request.getParameter("fileId");
		String fileName = request.getParameter("fileName");
		FilesInfoDAO dao = new FilesInfoDAOImpl();
		dao.removeImage(Integer.valueOf(fileId));
		File fileOnDisk = new File(Constants.path+fileName);
		fileOnDisk.delete();
	}

	private void updateImage(HttpServletRequest request, HttpServletResponse response) {
		String fileId = request.getParameter("fileId");
		String newCaption = request.getParameter("caption");
		String newLabel = request.getParameter("label");
		FilesInfoDAO dao = new FilesInfoDAOImpl();
		dao.updateDetails(Integer.valueOf(fileId), newCaption, newLabel);
	}

	private void listImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/galleryAppController?page=listingImages");
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
				File file = new File(Constants.path+imageName);
				if(!file.exists()) {
					image.write(file);
					FilesInfoDAO dao = new FilesInfoDAOImpl();
					dao.addDetails(new FilesInfo(imageName));
				} else {
					throw new FileUploadException("Duplicate files can't be uploaded");
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
