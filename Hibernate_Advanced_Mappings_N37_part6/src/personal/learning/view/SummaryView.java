package personal.learning.view;

import java.math.BigDecimal;

public class SummaryView implements Cloneable {
	
	public String studentEmail = null;
	
	public String studentFirstName = null;
	
	public String studentLastName = null;
	
	public String instructorEmail = null;
	
	public String instructorFirstName = null;
	
	public String instructorLastName = null;
	
	public String courseName = null;
	
	public BigDecimal priceOfCourse = null;
	
	public String courseDescription = null;
	
	public BigDecimal instructorId = null;

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getPriceOfCourse() {
		return priceOfCourse;
	}

	public void setPriceOfCourse(BigDecimal priceOfCourse) {
		this.priceOfCourse = priceOfCourse;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public BigDecimal getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(BigDecimal instructorId) {
		this.instructorId = instructorId;
	}

	@Override
	public String toString() {
		return "SummaryView [studentEmail=" + studentEmail + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", instructorEmail=" + instructorEmail
				+ ", instructorFirstName=" + instructorFirstName + ", instructorLastName=" + instructorLastName
				+ ", courseName=" + courseName + ", priceOfCourse=" + priceOfCourse + ", courseDescription="
				+ courseDescription + ", instructorId=" + instructorId + "]";
	}
	
	// It has to be exactly this method signature
    public Object clone() {
        try
        {
            // call clone in Object.
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("Unable to clone object");
            
            // Depends on your own use-case. I don't want the object modified somewhere!
            return null;
        }
    }
	
}
