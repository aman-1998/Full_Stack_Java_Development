package personal.learning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "instructor")
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_generator")
	@SequenceGenerator(name = "instructor_generator", sequenceName = "instructor_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "instructor_first_name")
	private String instructorFirstName;
	
	@Column(name = "instructor_last_name")
	private String instructorLastName;
	
	@Column(name = "instructor_email", unique = true)
	private String instructorEmail;
	
	@OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL)
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	private List<Course> courseList;
	
	public Instructor() {}
	
	public Instructor(String instructorFirstName, String instructorLastName) {
		this.instructorFirstName = instructorFirstName;
		this.instructorLastName = instructorLastName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getInstructorFirstName() {
		return instructorFirstName;
	}
	
	public void setInstructorFirstName(String instructorFirstName) {
		this.instructorFirstName = instructorFirstName;
	}
	
	public String getInstructorLastName() {
		return instructorLastName;
	}
	
	public void setInstructorLastName(String instructorLastName) {
		this.instructorLastName = instructorLastName;
	}
	
	public String getInstructorEmail() {
		return instructorEmail;
	}
	
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
}
