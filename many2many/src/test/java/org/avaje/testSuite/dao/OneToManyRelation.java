/**
 * 
 */
package org.avaje.testSuite.dao;

import java.util.HashMap;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.avaje.testSuite.domain.Child;
import org.avaje.testSuite.domain.Parent;

/**
 * @author Administrator
 *
 */
public class OneToManyRelation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try{
			emf=Persistence.createEntityManagerFactory("default", new HashMap());
			em=emf.createEntityManager();
			em.getTransaction().begin();
			Parent parent = new Parent();
			parent.setPname("Vinod");
			Child child = new Child();
			child.setCname("Monu");
			Child child1 = new Child();
			child1.setCname("Pintu");
			Child child2 = new Child();
			child2.setCname("Sintu");
			HashSet childSet = new HashSet();
			childSet.add(child);
			childSet.add(child1);
			childSet.add(child2);
			parent.setChildren(childSet);
			em.persist(parent);
			em.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			emf.close();
			em.close();
		}

	}

}
