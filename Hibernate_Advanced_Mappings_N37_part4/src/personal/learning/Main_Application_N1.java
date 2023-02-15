package personal.learning;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import personal.learning.entity.StudentCourse;

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
										.addAnnotatedClass(StudentCourse.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();
			
			Instructor instructor1 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = : email")
											.setParameter("email", "anushka.nandy@gmail.com")
											.getResultList()
											.get(0);
			
			Instructor instructor2 = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = : email")
					.setParameter("email", "saurav.singha@gmail.com")
					.getResultList()
					.get(0);
			
			Course course1 = new Course("Chat Bot using Python");
			course1.setPrice(2000);
			course1.setCourseDescripton("We will use latest version of python to build a chat-bot");
			course1.setInstructor(instructor1);
			
			Course course2 = new Course("Basics of SQL");
			course2.setCourseDescripton("We will learn SQL using Oracle database");
			course2.setPrice(650);
			course2.setInstructor(instructor1);
			
			Course course3 = new Course("How to increase muscle mass");
			course3.setCourseDescripton("In this course we will learn the ways to increase muscle mass");
			course3.setPrice(1300);
			course3.setInstructor(instructor2);
			
			Student student1 = new Student("Geetha", "Sodhi", 143);
			student1.setEmail("geetha.sodhi@gmail.com");
			
			Student student2 = new Student("Yash", "Gupta", 150);
			student2.setEmail("yash.gupta@gmail.com");
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			StudentCourse studentCourse1 = new StudentCourse(format.parse("10-12-2022"));
			studentCourse1.setCourse(course1);
			studentCourse1.setStudent(student1);
			
			StudentCourse studentCourse2 = new StudentCourse(format.parse("18-01-2023"));
			studentCourse2.setCourse(course2);
			studentCourse2.setStudent(student1);
			
			StudentCourse studentCourse3 = new StudentCourse(format.parse("22-11-2022"));
			studentCourse3.setCourse(course3);
			studentCourse3.setStudent(student1);
			
			StudentCourse studentCourse4 = new StudentCourse(format.parse("01-01-2023"));
			studentCourse4.setCourse(course1);
			studentCourse4.setStudent(student2);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.save(student1);
			session.save(student2);
			
			session.save(studentCourse1);
			session.save(studentCourse2);
			session.save(studentCourse3);
			session.save(studentCourse4);
			
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
