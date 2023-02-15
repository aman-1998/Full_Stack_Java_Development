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
import javax.persistence.OneToMany;
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
	
	/*
	 * If Join-Table has some extra columns then we need to make class
	 * for that table and convert ManyToMany relationship to OneToMany and ManyToOne 
	 * like I did here (Course, StudentCourse, Student).
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentCourse> listOfStudentCourse;
	
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

	public List<StudentCourse> getListOfStudentCourse() {
		return listOfStudentCourse;
	}

	public void setListOfStudentCourse(List<StudentCourse> listOfStudentCourse) {
		this.listOfStudentCourse = listOfStudentCourse;
	}
	
}
