package personal.learning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "course")
@Table(name = "course")
public class Course {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
	@SequenceGenerator(name = "course_generator", sequenceName = "course_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "course_description")
	private String courseDescripton;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", nullable=false)
	private List<Review> reviewList;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "course_student", 
			   joinColumns = @JoinColumn(name = "course_id"), 
			   inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> studentList;
	
	public Course() {}
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getCourseDescripton() {
		return courseDescripton;
	}

	public void setCourseDescripton(String courseDescripton) {
		this.courseDescripton = courseDescripton;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", price=" + price + ", courseDescripton="
				+ courseDescripton + "]";
	}
	
}
