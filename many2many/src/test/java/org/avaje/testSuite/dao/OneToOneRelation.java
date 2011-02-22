/**
 * 
 */
package org.avaje.testSuite.dao;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.avaje.testSuite.domain.Address;
import org.avaje.testSuite.domain.Person;

/**
 * @author Administrator
 *
 */
public class OneToOneRelation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("default", new HashMap());
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Person per = new Person();
			Address add = new Address();
			per.setName("Vinod Kumar");
			add.setAddress("New Delhi, Sector-3");
			add.setPerson(per);
			em.persist(add);
			em.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			em.close();
			emf.close();
		}

	}

}
