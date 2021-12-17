package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.FilesInfo;

public class FilesInfoDAOImpl implements FilesInfoDAO {
	
	SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(FilesInfo.class)
										.buildSessionFactory();
	
	public FilesInfoDAOImpl() {
		super();
	}

	@Override
	public void addDetails(FilesInfo filesInfo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			session.save(filesInfo);
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
    
    
	
}
