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

public class Main_Application_N5 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
														   .addAnnotatedClass(Instructor.class)
														   .addAnnotatedClass(InstructorDetail.class)
														   .addAnnotatedClass(InstructorJobDetail.class)
														   .addAnnotatedClass(Course.class)
														   .addAnnotatedClass(Student.class)
														   .addAnnotatedClass(Review.class)
														   .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();
			/*
			 * course(save)
			 */
			//1st course
			Course course1 = new Course("JavaScript Tutorials");
			course1.setCourseDescripton("Learn vanila javaScript from scratch");
			course1.setPrice(300);
			
			//2nd course
			Course course2 = new Course("Code with fun");
			course2.setCourseDescripton("Learn C++ basics");
			course2.setPrice(250);
			
			//3rd course
			Course course3 = new Course("AngularJS Tutorial");
			course3.setCourseDescripton("Learn vanila JavaScript and AngularJS for industry");
			course3.setPrice(1200);
			
			Instructor instructor1 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
					  						.setParameter("email", "dilip.ghosh@gmail.com")
					  						.getResultList()
					  						.get(0);
			
			course1.setInstructor(instructor1);
			course2.setInstructor(instructor1);
			course3.setInstructor(instructor1);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
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
