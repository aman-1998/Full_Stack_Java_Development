package personal.learning;

import java.util.List;
import java.util.Optional;

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

public class Main_Application_N3 {
	
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
			
			InstructorJobDetail instructorJobDetail = new InstructorJobDetail("Microsoft");
			instructorJobDetail.setOfficeAddress("Bangluru");
			instructorJobDetail.setOfficeHrEmail("hr@microsoft.com");
			instructorJobDetail.setOfficeHrPhoneNo(9123819457L);
			
			//Instructor instructor = new Instructor("Pawan", "Singh");
			//instructor.setInstructorEmail("pawan.singh@gmail.com");
			
			Instructor instructor = (Instructor) session.createQuery("from instructor ins where ins.instructorEmail = :email")
					                                    .setParameter("email", "vinod.paswan@gmail.com")
					                                    .getResultList()
					                                    .get(0);
			
			instructorJobDetail.setInstructor(instructor);
			
			session.save(instructorJobDetail);
			
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
