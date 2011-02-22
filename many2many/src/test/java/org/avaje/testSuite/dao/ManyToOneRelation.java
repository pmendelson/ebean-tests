/**
 * 
 */
package org.avaje.testSuite.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.avaje.testSuite.domain.Child;
import org.avaje.testSuite.domain.Parent;

/**
 * @author Administrator
 *
 */
public class ManyToOneRelation {

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
			Child child=new Child();
			child.setCname("Tommy");
			Child child1=new Child();
			child1.setCname("Rocky");
			HashSet childSet=new HashSet();
			childSet.add(child);
			childSet.add(child1);
			Parent parent = new Parent();
			parent.setPname("Moc");
			parent.setChildren(childSet);
			em.persist(parent);
			
			Parent parentRecord = em.find(Parent.class, parent.getId());
			System.out.println("Parent: "+parentRecord.getPname());
			Set<Child> parentSet= parentRecord.getChildren();
			Iterator it = parentSet.iterator();
			while (it.hasNext()){
				Child ch = (Child)it.next();
				System.out.println("Childs: "+ch.getCname());
			}
			
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
