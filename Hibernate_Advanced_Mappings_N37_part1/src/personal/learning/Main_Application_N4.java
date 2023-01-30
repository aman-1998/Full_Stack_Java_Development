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

public class Main_Application_N4 {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
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
			 * course(save) -> Review(save)
			 */
			Course course = new Course();
			course.setCourseName("How to read mind");
			course.setCourseDescripton("Learn the tricks to read mind");
			course.setPrice(250);
			
			Instructor instructor = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
					         			   .setParameter("email", "vinod.paswan@gmail.com")
					         			   .getResultList()
					         			   .get(0);
			
			course.setInstructor(instructor);
			
			Review review1 = new Review("Bullshit course");
			Review review2 = new Review("Good for beginers");
			Review review3 = new Review("Presentation was good");
			
			List<Review> reviews = Stream.of(review1, review2, review3).collect(Collectors.toCollection(ArrayList<Review>::new));
			
			course.setReviewList(reviews);
			
			session.save(course);
			
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
