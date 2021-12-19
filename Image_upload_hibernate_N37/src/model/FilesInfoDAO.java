package model;

import java.util.List;

import entity.FilesInfo;

public interface FilesInfoDAO {
	void addDetails(FilesInfo filesInfo);
	List<FilesInfo> listAllImages();
	void updateDetails(Integer fileId, String newCaption, String newLabel);
	void removeImage(Integer fileId);
}
