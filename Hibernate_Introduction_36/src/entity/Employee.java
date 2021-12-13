package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Employee")
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "EMPLOYEE_EMP_ID_SEQUENCE", allocationSize = 1)
	private int empId;
	
	@Column(name="DOMAIN_NAME")
	private String domainName;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	

	public Employee() {
	}

	public Employee(String domainName, String fullName, String phoneNo, String password) {
		this.domainName = domainName;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", domainName=" + domainName + ", fullName=" + fullName + ", phoneNo="
				+ phoneNo + ", password=" + password + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
