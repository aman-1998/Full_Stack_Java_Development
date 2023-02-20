package personal.learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import personal.learning.entity.Course;
import personal.learning.entity.Instructor;
import personal.learning.entity.InstructorDetail;
import personal.learning.entity.InstructorJobDetail;
import personal.learning.entity.Review;
import personal.learning.entity.Student;
import personal.learning.utility.Utility;
import personal.learning.view.SummaryView;

public class Main_Application_N1 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(InstructorJobDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();
			/*
			 * Find list of all instructors and their students
			 */
			StringBuilder sb = new StringBuilder();

			sb.append(" WITH student_course_detail AS ( ");
			sb.append("    SELECT ");
			sb.append("        st.student_email, ");
			sb.append("        st.student_first_name, ");
			sb.append("        st.student_last_name, ");
			sb.append("        co.course_name, ");
			sb.append("        co.price AS price_of_course, ");
			sb.append("        co.course_description, ");
			sb.append("        co.instructor_id ");
			sb.append("    FROM ");
			sb.append("        student          st, ");
			sb.append("        course           co, ");
			sb.append("        course_student   cs ");
			sb.append("    WHERE ");
			sb.append("        st.id = cs.student_id ");
			sb.append("        AND co.id = cs.course_id ");
			sb.append(" ) ");
			sb.append(" SELECT ");
			sb.append("    scd.*, ");
			sb.append("    ins.instructor_first_name, ");
			sb.append("    ins.instructor_last_name, ");
			sb.append("    ins.instructor_email ");
			sb.append(" FROM ");
			sb.append("    student_course_detail scd, ");
			sb.append("    instructor ins ");
			sb.append(" WHERE ");
			sb.append("    ins.id = scd.instructor_id ");
			
			List<SummaryView> summaryViewList = new Utility<SummaryView>().query(session, 
																				 sb.toString(), 
																				 new SummaryView());
			
			System.out.println(summaryViewList);
			
			txn.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
			if(txn != null) {
				txn.rollback();
			}
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
