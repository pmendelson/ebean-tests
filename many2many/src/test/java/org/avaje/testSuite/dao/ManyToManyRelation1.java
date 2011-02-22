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

import org.avaje.testSuite.domain.Author;
import org.avaje.testSuite.domain.Book;

/**
 * @author Administrator
 *
 */
public class ManyToManyRelation1 {

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
			
			Author author = new Author();
			author.setAuthorName("Clifford Geertz");
			Author author1 = new Author();
			author1.setAuthorName("JP Morgenthal");
			
			Book book = new Book();
			book.setBookName("Phoenix");
			Book book1 = new Book();
			book1.setBookName("Enterprise Applications Integration with XML and Java");
			
			HashSet bookSet = new HashSet();
			bookSet.add(book);
			bookSet.add(book1);
			author.setBooks(bookSet);
			author1.setBooks(bookSet);
			
			em.persist(author);
			em.persist(author1);
			
			Author authorRecord = em.find(Author.class, author.getId());
			System.out.println("Author: "+ authorRecord.getAuthorName());
			Set<Book> bookset = authorRecord.getBooks();
			Iterator it = bookset.iterator();
			while(it.hasNext()){
				Book b = (Book)it.next();
				System.out.println("Book: "+ b.getBookName());
			}
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
