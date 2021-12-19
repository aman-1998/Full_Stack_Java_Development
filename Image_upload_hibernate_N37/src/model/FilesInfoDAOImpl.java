package model;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<FilesInfo> listAllImages() {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		List<FilesInfo> filesList = new ArrayList<FilesInfo>();
		try {
			txn = session.beginTransaction();
			filesList = session.createQuery("from FILES_INFO").getResultList();
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return filesList;
	}

	@Override
	public void updateDetails(Integer fileId, String newCaption, String newLabel) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			FilesInfo filesInfo = new FilesInfo();
			txn = session.beginTransaction();
			if(newCaption == null && newLabel == null) {
				return;
			} else {
				filesInfo = session.get(FilesInfo.class, fileId);
				if(newCaption == null && newLabel != null) {
					filesInfo.setLabel(newLabel);
				} else if(newCaption != null && newLabel == null) {
					filesInfo.setCaption(newCaption);
				} else {
					filesInfo.setLabel(newLabel);
					filesInfo.setCaption(newCaption);
				}
			}
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public void removeImage(Integer fileId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txn = null;
		try {
			FilesInfo filesInfo = new FilesInfo();
			txn = session.beginTransaction();
			filesInfo = session.get(FilesInfo.class, fileId);
			session.delete(filesInfo);
			txn.commit();
		} catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
    
    
	
}
