package personal.learning.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "student_course")
@Table(name = "student_course")
public class StudentCourse {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_course_generator")
	@SequenceGenerator(name = "student_course_generator", sequenceName = "student_course_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "date_of_purchase")
	private Date dateOfPurchase;
	
	/*
	 * If Join-Table has some extra columns then we need to make class
	 * for that table and convert ManyToMany relationship to OneToMany and ManyToOne 
	 * like I did here (Course, StudentCourse, Student).
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "course_id")
	private Course course;
	
	/*
	 * If Join-Table has some extra columns then we need to make class
	 * for that table and convert ManyToMany relationship to OneToMany and ManyToOne 
	 * like I did here (Course, StudentCourse, Student).
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "student_id")
	private Student student;
	
	public StudentCourse() {}
	
	public StudentCourse(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
