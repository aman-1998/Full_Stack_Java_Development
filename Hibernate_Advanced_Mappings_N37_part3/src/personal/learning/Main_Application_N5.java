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
			 * delete(student) -> delete(course_student)
			 */
			Student student = (Student) session.createQuery("from student stu where stu.email = :email")
					              	 .setParameter("email", "diksha.shaw@gmail.com")
					              	 .getResultList()
					              	 .get(0);
			
			session.delete(student);
			
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
