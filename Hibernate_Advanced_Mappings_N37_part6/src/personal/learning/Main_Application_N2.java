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
import personal.learning.utility.Utility;
import personal.learning.view.SummaryView2;

public class Main_Application_N2 {
	
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

			sb.append(" SELECT ");
			sb.append("    co.course_name, ");
			sb.append("    co.price AS price_of_course, ");
			sb.append("    re.comments ");
			sb.append(" FROM ");
			sb.append("    course   co, ");
			sb.append("    review   re ");
			sb.append(" WHERE ");
			sb.append("    co.id = re.course_id (+) ");
			
			List<SummaryView2> summaryViewList = new Utility<SummaryView2>().query(session, sb.toString(), SummaryView2.class);
			
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
