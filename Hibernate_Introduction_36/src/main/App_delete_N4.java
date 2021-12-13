package main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class App_delete_N4 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			//Create object of entity class
			Employee employee = new Employee();
			
			//Start transaction
			txn = session.beginTransaction();
			
			//Perform operation
			employee = session.get(Employee.class, 5);
			session.delete(employee);
			
			//Commit the transaction
			txn.commit();
			System.out.println(employee);
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



