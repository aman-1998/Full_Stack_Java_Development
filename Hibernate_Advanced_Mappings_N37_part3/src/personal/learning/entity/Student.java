package personal.learning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "student")
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
	@SequenceGenerator(name = "student_generator", sequenceName = "student_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "student_first_name")
	private String firstName;
	
	@Column(name = "student_last_name")
	private String lastName;
	
	@Column(name = "roll")
	private int roll;
	
	@Column(name = "student_email")
	private String email;
	
	// @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // If we use this then we can't delete student directly if it is also present in course_student table. We will get this error: ERROR: ORA-02292: integrity constraint (C##PRACTICE.STUDENT_ID_FK) violated - child record found
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "course_student", 
			   joinColumns = @JoinColumn(name = "student_id"), 
			   inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courseList;
	
	public Student() {}
	
	public Student(String firstName, String lastName, int roll) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roll = roll;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRoll() {
		return roll;
	}
	
	public void setRoll(int roll) {
		this.roll = roll;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", roll=" + roll
				+ ", email=" + email + ", courseList=" + courseList + "]";
	}
	
}
