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

public class Main_Application_N3 {
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
			
			Instructor instructor = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
										   .setParameter("email", "rakhi.pandey@gmail.com")
										   .getResultList()
										   .get(0);
			
			/*
			 * It won't delete instructor if there a record for it in INSTRUCTOR_JOB_DETAIL.
			 * Even if there is a record for it in INSTRUCTOR_DETAIL, it won't be a problem because of cascading delete (CascadeType.REMOVE).
			 * So, we should modify Instructor class and make the relation between Instructor and InstructorJobDetail to OneToOne (Bidirectional).
			 */
			session.delete(instructor);
			
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
