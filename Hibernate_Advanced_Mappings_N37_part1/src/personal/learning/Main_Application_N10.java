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

public class Main_Application_N10 {
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
										   .setParameter("email", "ajeet.bharti@gmail.com")
										   .getResultList()
										   .get(0);
			
			//1st course
			Course course1 = new Course("How to influence general public");
			course1.setCourseDescripton("You will learn the proper way to put facts infront of public");
			course1.setPrice(750);
			course1.setInstructor(instructor1);
			
			//2nd course
			Course course2 = new Course("Tradition of India");
			course2.setCourseDescripton("You will learn about history and tradition of India");
			course2.setPrice(250);
			course2.setInstructor(instructor1);
			
			Instructor instructor2 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
											.setParameter("email", "aman.verma@gmail.com")
											.getResultList()
											.get(0);
			
			//3rd course
			Course course3 = new Course("Microservices using SpringBoot");
			course3.setCourseDescripton("You will learn microservice using real time project and deployment on AWS");
			course3.setPrice(2200);
			course3.setInstructor(instructor2);
			
			Instructor instructor3 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
					 						.setParameter("email", "mahesh.dubey@gmail.com")
					 						.getResultList()
					 						.get(0);
			
			//4th course
			Course course4 = new Course("How to build muscle naturally");
			course4.setCourseDescripton("You will get to know about the ways of building muscle naturally");
			course4.setPrice(1500);
			course4.setInstructor(instructor3);
			
			//1st student
			Student student1 = new Student("Diksha", "Shaw", 145);
			student1.setEmail("diksha.shaw@gmail.com");
			
			//2nd student
			Student student2 = new Student("Megha", "Sharma", 129);
			student2.setEmail("megha.sharma@gmail.com");
			
			//3rd student
			Student student3 = new Student("Mayank", "Jha", 137);
			student3.setEmail("mayank.jha@gmail.com");
			
			//4th student
			Student student4 = new Student("Nikhil", "Gupta", 146);
			student4.setEmail("nikhil.gupta@gmail.com");
			
			course1.setStudentList(Stream.of(student1, student2, student3).collect(Collectors.toList()));
			
			List<Student> listOfStudentsForCourse2 = new ArrayList<>();
			listOfStudentsForCourse2.add(student1);
			listOfStudentsForCourse2.add(student2);
			
			course2.setStudentList(listOfStudentsForCourse2);
			
			course3.setStudentList(Stream.of(student1, student3).collect(Collectors.toList()));
			
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
