package personal.learning.view;

import java.math.BigDecimal;

public class SummaryView2 implements Cloneable{
	
	public String courseName;
	
	public BigDecimal priceOfCourse;
	
	public String comments;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "SummaryView2 [courseName=" + courseName + ", priceOfCourse=" + priceOfCourse + ", comments=" + comments
				+ "]";
	}
	
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
