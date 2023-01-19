package personal.learning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "instructor_job_detail")
@Table(name = "instructor_job_detail")
public class InstructorJobDetail {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_job_detail_generator")
	@SequenceGenerator(name = "instructor_job_detail_generator", sequenceName = "instructor_job_detail_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "organization")
	private String organization;
	
	@Column(name = "office_address")
	private String officeAddress;
	
	@Column(name = "office_hr_phone_no")
	private String officeHrPhoneNo;
	
	@Column(name = "office_hr_email")
	private String officeHrEmail;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	public InstructorJobDetail() {}
	
	public InstructorJobDetail(String organization) {
		this.organization = organization;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public String getOfficeHrPhoneNo() {
		return officeHrPhoneNo;
	}
	
	public void setOfficeHrPhoneNo(String officeHrPhoneNo) {
		this.officeHrPhoneNo = officeHrPhoneNo;
	}
	
	public String getOfficeHrEmail() {
		return officeHrEmail;
	}
	
	public void setOfficeHrEmail(String officeHrEmail) {
		this.officeHrEmail = officeHrEmail;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
}
