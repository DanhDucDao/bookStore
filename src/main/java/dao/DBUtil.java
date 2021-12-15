package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_store");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
