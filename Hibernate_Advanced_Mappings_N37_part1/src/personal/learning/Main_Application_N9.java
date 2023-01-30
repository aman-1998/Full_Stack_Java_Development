package personal.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class Main_Application_N9 {
	
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
						.setParameter("email", "prasant.dhwan@gmail.com")
						.getResultList()
						.get(0);
			
			//1st course
			Course course1 = new Course("Domestic politics of India");
			course1.setCourseDescripton("Learn about polity and constitution of India");
			course1.setPrice(1000);
			course1.setInstructor(instructor);
			
			//2nd course
			Course course2 = new Course("Geo Politics");
			course2.setCourseDescripton("Understand the geo-politics around the world");
			course2.setPrice(2000);
			course2.setInstructor(instructor);
			
			Review review1 = new Review("Best course on indian politics");
			Review review2 = new Review("I didn't know that indian politics is so competitive");
			List<Review> reviews1 = Stream.of(review1, review2).collect(Collectors.toList());
			course1.setReviewList(reviews1);
			
			Review review3 = new Review("Now I know who are our enemy countries");
			Review review4 = new Review("India should always see its interest first");
			List<Review> reviews2 = Stream.of(review3, review4).collect(Collectors.toList());
			course2.setReviewList(reviews2);
			
			List<Course> courseList = instructor.getCourseList();
			courseList.add(course1);
			courseList.add(course2);
			
			instructor.setCourseList(courseList);
			
			session.save(instructor);
			
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
