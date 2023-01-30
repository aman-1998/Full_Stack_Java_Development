package personal.learning;

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

public class Main_Application_N1 {
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
			
			int instructorId = 53;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			/*
			 * Since, I got instructor so we don need to run query for instructor detail again. But just for learning
			 * purpose I am doing so.
			 */
			InstructorDetail instructorDetail = (InstructorDetail) session.createQuery("from instructor_detail insd where insd.instructor = :instruc")
													   .setParameter("instruc", instructor)
													   .getResultList()
													   .get(0);
			
			System.out.println(instructorDetail);
			System.out.println(instructor.getInstructorDetail());
			
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
