package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="FILES_INFO")
@Table(name="FILES_INFO")
public class FilesInfo {
	
	@Id
	@Column(name="FILE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_generator")
	@SequenceGenerator(name = "file_generator", sequenceName = "FILES_INFO_FILE_ID_SEQUENCE", allocationSize = 1)
	private int fileId;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="CAPTION")
	private String caption;
	
	public FilesInfo() {
		super();
	}
	
	public FilesInfo(String fileName) {
		this.fileName = fileName;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
