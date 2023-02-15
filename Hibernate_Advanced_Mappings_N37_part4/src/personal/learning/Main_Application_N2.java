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
										.addAnnotatedClass(StudentCourse.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();
			
			Course course1 = (Course) session.createQuery("from course c where c.courseName = :name")
									.setParameter("name", "AI & ML Tutorials")
									.getResultList()
									.get(0);
			
			Course course2 = (Course) session.createQuery("from course c where c.courseName = :name")
											.setParameter("name", "Snake game using JavaScript")
											.getResultList()
											.get(0);
			
			Student student1 = (Student) session.createQuery("from student st where st.email = :email")
									  .setParameter("email", "dinesh.nayak@gmail.com")
									  .getResultList()
									  .get(0);
			
			Student student2 = (Student) session.createQuery("from student st where st.email = :email")
											  	.setParameter("email", "mayank.jha@gmail.com")
											  	.getResultList()
											  	.get(0);
			
			Student student3 = (Student) session.createQuery("from student st where st.email = :email")
											  	.setParameter("email", "geetha.sodhi@gmail.com")
											  	.getResultList()
											  	.get(0);
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			StudentCourse studentCourse1 = new StudentCourse(format.parse("17-08-2022"));
			studentCourse1.setCourse(course1);
			studentCourse1.setStudent(student1);
			
			StudentCourse studentCourse2 = new StudentCourse(format.parse("17-08-2022"));
			studentCourse2.setCourse(course1);
			studentCourse2.setStudent(student3);
			
			StudentCourse studentCourse3 = new StudentCourse(format.parse("20-05-2022"));
			studentCourse3.setCourse(course2);
			studentCourse3.setStudent(student1);
			
			StudentCourse studentCourse4 = new StudentCourse(format.parse("13-01-2023"));
			studentCourse4.setCourse(course2);
			studentCourse4.setStudent(student2);
			
			StudentCourse studentCourse5 = new StudentCourse(format.parse("17-08-2022"));
			studentCourse5.setCourse(course2);
			studentCourse5.setStudent(student3);
			
			session.save(studentCourse1);
			session.save(studentCourse2);
			session.save(studentCourse3);
			session.save(studentCourse4);
			session.save(studentCourse5);
			
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
