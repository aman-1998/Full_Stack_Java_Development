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
			/*
			 * instructor(save) -> instructorDetail(save)
			 */
			//1st Instructor
			Instructor instructor1 = new Instructor("Aman", "Mishra");
			instructor1.setInstructorEmail("aman.mishra@gmail.com");
			
			InstructorDetail instructorDetail1 = new InstructorDetail("Fit Compilation");
			instructorDetail1.setChannelDescription("This channel gives information about fitness");
			instructorDetail1.setNoOfSubscriber(500);
			instructorDetail1.setInstructor(instructor1);
			
			instructor1.setInstructorDetail(instructorDetail1);
			session.save(instructor1);
			
			//2nd Instructor
			Instructor instructor2 = new Instructor("Aniket", "Kashyap");
			instructor2.setInstructorEmail("aniket.kashyap@gmail.com");
			
			InstructorDetail instructorDetail2 = new InstructorDetail("Java Brains");
			instructorDetail2.setChannelDescription("Everything about Java");
			instructorDetail2.setNoOfSubscriber(1000);
			instructorDetail2.setInstructor(instructor2);
			
			instructor2.setInstructorDetail(instructorDetail2);
			session.save(instructor2);
			
			//3rd Instructor
			Instructor instructor3 = new Instructor("Rakhi", "Pandey");
			instructor3.setInstructorEmail("rakhi.pandey@gmail.com");
			
			InstructorDetail instructorDetail3 = new InstructorDetail("Beauty Tips");
			instructorDetail3.setChannelDescription("Review of new cosmetic products");
			instructorDetail3.setNoOfSubscriber(300);
			instructorDetail3.setInstructor(instructor3);
			
			instructor3.setInstructorDetail(instructorDetail3);
			session.save(instructor3);
			
			//4th Instructor
			Instructor instructor4 = new Instructor("Vinod", "Paswan");
			instructor4.setInstructorEmail("vinod.paswan@gmail.com");
			
			InstructorDetail instructorDetail4 = new InstructorDetail("P For Prank");
			instructorDetail4.setChannelDescription("Pranks and Social experiments");
			instructorDetail4.setNoOfSubscriber(700);
			instructorDetail4.setInstructor(instructor4);
			
			instructor4.setInstructorDetail(instructorDetail4);
			session.save(instructor4);
			
			//5th Instructor
			Instructor instructor5 = new Instructor("Nikita", "Shaw");
			instructor5.setInstructorEmail("nikita.shaw@gmail.com");
			
			InstructorDetail instructorDetail5 = new InstructorDetail("Nikita Vlogs");
			instructorDetail5.setChannelDescription("Daily vlogging");
			instructorDetail5.setNoOfSubscriber(1200);
			instructorDetail5.setInstructor(instructor5);
			
			instructor5.setInstructorDetail(instructorDetail5);
			session.save(instructor5);
			
			//6th Instructor
			Instructor instructor6 = new Instructor("Mahesh", "Dubey");
			instructor6.setInstructorEmail("mahesh.dubey@gmail.com");
			
			InstructorDetail instructorDetail6 = new InstructorDetail("Flying Beast");
			instructorDetail6.setChannelDescription("Bodybuilding and fitness");
			instructorDetail6.setNoOfSubscriber(300);
			instructorDetail6.setInstructor(instructor6);
			
			instructor6.setInstructorDetail(instructorDetail6);
			session.save(instructor6);
			
			//7th Instructor
			Instructor instructor7 = new Instructor("Dilip", "Ghosh");
			instructor7.setInstructorEmail("dilip.ghosh@gmail.com");
			
			InstructorDetail instructorDetail7 = new InstructorDetail("Code with Dilip");
			instructorDetail7.setChannelDescription("Competitive coding practice");
			instructorDetail7.setNoOfSubscriber(300);
			instructorDetail7.setInstructor(instructor7);
			
			instructor7.setInstructorDetail(instructorDetail7);
			session.save(instructor7);
			
			//8th Instructor
			Instructor instructor8 = new Instructor("Anushka", "Nandy");
			instructor8.setInstructorEmail("anushka.nandy@gmail.com");
			
			InstructorDetail instructorDetail8 = new InstructorDetail("SQL Lover");
			instructorDetail8.setChannelDescription("Learn SQL from zero to hero");
			instructorDetail8.setNoOfSubscriber(300);
			instructorDetail8.setInstructor(instructor8);
			
			instructor8.setInstructorDetail(instructorDetail8);
			session.save(instructor8);
			
			//9th Instructor
			Instructor instructor9 = new Instructor("Navya", "Mishra");
			instructor9.setInstructorEmail("navya.mishra@gmail.com");
			
			InstructorDetail instructorDetail9 = new InstructorDetail("Technical Navya");
			instructorDetail9.setChannelDescription("Reviews of Mobile, TV, etc");
			instructorDetail9.setNoOfSubscriber(300);
			instructorDetail9.setInstructor(instructor9);
			
			instructor9.setInstructorDetail(instructorDetail9);
			session.save(instructor9);
			
			//10th Instructor
			Instructor instructor10 = new Instructor("Prasant", "Dhwan");
			instructor10.setInstructorEmail("prasant.dhwan@gmail.com");
			
			InstructorDetail instructorDetail10 = new InstructorDetail("World Affairs");
			instructorDetail10.setChannelDescription("News about Geo Politics");
			instructorDetail10.setNoOfSubscriber(345);
			instructorDetail10.setInstructor(instructor10);
			
			instructor10.setInstructorDetail(instructorDetail10);
			session.save(instructor10);
			
			//11th Instructor
			Instructor instructor11 = new Instructor("Manoj", "Pandey");
			instructor11.setInstructorEmail("manoj.pandey@gmail.com");
			
			InstructorDetail instructorDetail11 = new InstructorDetail("Frustated India");
			instructorDetail11.setChannelDescription("Natioal and Internation news");
			instructorDetail11.setNoOfSubscriber(1000);
			instructorDetail11.setInstructor(instructor11);
			
			instructor11.setInstructorDetail(instructorDetail11);
			session.save(instructor11);
			
		    //12th instructor
			Instructor instructor12 = new Instructor("Ajeet", "Bharti");
			instructor12.setInstructorEmail("ajeet.bharti@gmail.com");
			
			InstructorDetail instructorDetail12 = new InstructorDetail("DO Politics");
			instructorDetail12.setChannelDescription("Internal Politics of India");
			instructorDetail12.setNoOfSubscriber(550);
			instructorDetail12.setInstructor(instructor12);
			
			instructor12.setInstructorDetail(instructorDetail12);
			session.save(instructor12);
			
			//13th instructor
			Instructor instructor13 = new Instructor("Paul", "Chalimo");
			instructor13.setInstructorEmail("paul.chalimo@gmail.com");
			
			InstructorDetail instructorDetail13 = new InstructorDetail("Paul Chalimo");
			instructorDetail13.setChannelDescription("Runnning and workout videos");
			instructorDetail13.setNoOfSubscriber(1300);
			instructorDetail13.setInstructor(instructor13);
			
			instructor13.setInstructorDetail(instructorDetail13);
			session.save(instructor13);
			
			//14th instructor
			Instructor instructor14 = new Instructor("Saurav", "Singha");
			instructor14.setInstructorEmail("saurav.singha@gmail.com");
			
			InstructorDetail instructorDetail14 = new InstructorDetail("Fit Minda");
			instructorDetail14.setChannelDescription("Nutrition and workout videos");
			instructorDetail14.setNoOfSubscriber(400);
			instructorDetail14.setInstructor(instructor14);
			
			instructor14.setInstructorDetail(instructorDetail14);
			session.save(instructor14);
			
			//15th instructor
			Instructor instructor15 = new Instructor("Maithili", "Thakur");
			instructor15.setInstructorEmail("maithili.thakur@gmail.com");
			
			InstructorDetail instructorDetail15 = new InstructorDetail("Maithili Thakur");
			instructorDetail15.setChannelDescription("Lok geet");
			instructorDetail15.setNoOfSubscriber(300);
			instructorDetail15.setInstructor(instructor15);
			
			instructor15.setInstructorDetail(instructorDetail15);
			session.save(instructor15);
			
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
