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

public class Main_Application_N2 {
	
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

		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();
			//==========================================================
			/*
			 * instructorDetail(save) ->instructor(save)
			 */
			//1st instructorDetail
			InstructorDetail instructorDetail1 = new InstructorDetail("Cricbuzz");
			instructorDetail1.setChannelDescription("Highlights cricket matches");
			instructorDetail1.setNoOfSubscriber(6000);
			
			Instructor instructor1 = new Instructor("Sachin", "Tendulkar");
			instructor1.setInstructorEmail("sachin.tendulkar@gmail.com");
			instructor1.setInstructorDetail(instructorDetail1);
			
			instructorDetail1.setInstructor(instructor1);
			
		    session.save(instructorDetail1);
		    //=======================================================
			/*
			 * instructorDetail(save) -> instructor(save) -> course(save)
			 */
		    //2nd instructorDetail
			InstructorDetail instructorDetail2 = new InstructorDetail("Code with Aman");
			instructorDetail2.setChannelDescription("Learn coding with Aman");
			instructorDetail2.setNoOfSubscriber(4000);
			
			Instructor instructor2 = new Instructor("Aman", "Verma");
			instructor2.setInstructorEmail("aman.verma@gmail.com");
			instructor2.setInstructorDetail(instructorDetail2);
			
			//1st course
			Course course1 = new Course("Master Spring framework");
			course1.setCourseDescripton("Learn most popular framework of Java : Spring");
			course1.setPrice(400);
			course1.setInstructor(instructor2);
			
			//2nd course
			Course course2 = new Course("SpringBoot Tutorial");
			course2.setCourseDescripton("Learn SpringBoot the hardway");
			course2.setPrice(500);
			course2.setInstructor(instructor2);
			
			List<Course> courses = new ArrayList<Course>();
			courses.add(course1);
			courses.add(course2);
			
			instructor2.setCourseList(courses);
			instructorDetail2.setInstructor(instructor2);
			
			session.save(instructorDetail2);
			
			//=====================================================
			
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
