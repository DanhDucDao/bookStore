package testtime;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TimeDemo {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookdb");
	
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		
		Time time = em.find(Time.class, 1);
		System.out.println(time.getCreatTime().toString());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
}
