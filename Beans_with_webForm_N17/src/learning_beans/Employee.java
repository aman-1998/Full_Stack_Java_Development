package learning_beans;

public class Employee {
	private String firstName;
	private String lastName;
	private int empId;
	private String gender;
	private String country;
	private String[] language;
	
	public Employee() {
		this.firstName = "Shyam";
		this.empId = 10937;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}
}