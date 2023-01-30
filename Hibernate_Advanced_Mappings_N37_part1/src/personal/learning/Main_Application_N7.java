package personal.learning;

import java.util.ArrayList;
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

public class Main_Application_N7 {
	
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
			Instructor instructor = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
						.setParameter("email", "dilip.ghosh@gmail.com")
						.getResultList()
						.get(0);
			
			//1st course
			Course course1 = new Course("SpringBoot and ReactJS");
			course1.setCourseDescripton("Full Stack Development using SpringBoot and ReactJS");
			course1.setPrice(300);
			course1.setInstructor(instructor);
			
			//2nd course
			Course course2 = new Course("Jasper Reports");
			course2.setCourseDescripton("Learn to develop Jasper reports using TIBCO JasperSoft and Java");
			course2.setPrice(250);
			course2.setInstructor(instructor);
			
			List<Course> courses = new ArrayList<Course>();
			courses.add(course1);
			courses.add(course2);
			
			instructor.getCourseList().addAll(courses);
			
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
