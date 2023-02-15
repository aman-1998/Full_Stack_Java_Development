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

public class Main_Application_N11 {
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
			/*
			 * student(save), course(save) -> course_student(save)
			 */
			txn = session.beginTransaction();
			
			Instructor instructor1 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
										   .setParameter("email", "paul.chalimo@gmail.com")
										   .getResultList()
										   .get(0);
			
			//1st course
			Course course1 = new Course("How to build stamina");
			course1.setCourseDescripton("You will learn exercises to build stamina while running.");
			course1.setPrice(2000);
			course1.setInstructor(instructor1);
			
			//2nd course
			Course course2 = new Course("How to avoid injuries while running");
			course2.setCourseDescripton("You will learn how to maintain correct form while running");
			course2.setPrice(1200);
			course2.setInstructor(instructor1);
			
			Instructor instructor2 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
											.setParameter("email", "maithili.thakur@gmail.com")
											.getResultList()
											.get(0);
			
			//3rd course
			Course course3 = new Course("How to sing lok geet");
			course3.setCourseDescripton("You will learn basics of lok geet");
			course3.setPrice(550);
			course3.setInstructor(instructor2);
			
			//4th course
			Course course4 = new Course("How to smile while singing");
			course4.setCourseDescripton("You will learn to be natural while singing");
			course4.setPrice(1500);
			course4.setInstructor(instructor2);
			
			//1st student
			Student student1 = new Student("Rani", "Jha", 145);
			student1.setEmail("rani.jha@gmail.com");
			student1.setCourseList(Stream.of(course1, course2, course3).collect(Collectors.toList()));
			
			//2nd student
			Student student2 = new Student("Dinesh", "Nayak", 129);
			student2.setEmail("dinesh.nayak@gmail.com");
			student2.setCourseList(Stream.of(course1, course4).collect(Collectors.toList()));
			
			//3rd student
			Student student3 = new Student("Raghav", "Bhardwaj", 137);
			student3.setEmail("raghav.bhardwaj@gmail.com");
			student3.setCourseList(Stream.of(course3).collect(Collectors.toList()));
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			
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
