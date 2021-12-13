package main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class App_insert_N1 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			//Create object of entity class
			Employee employee = new Employee("viratk", "Virat Kohli", "9426716492", "viratkohli@123");
			
			//Start transaction
			txn = session.beginTransaction();
			
			//Perform operation
			session.save(employee);
			
			//Commit the transaction
			txn.commit();
			System.out.println("Row added");
		} catch(Exception ex){
			if(txn != null) {
				txn.rollback();
			}
			System.out.println(ex.getMessage());
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
