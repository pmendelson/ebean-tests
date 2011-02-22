/**
 * 
 */
package org.avaje.testSuite.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.avaje.testSuite.domain.Author;
import org.avaje.testSuite.domain.Book;
import org.hibernate.dialect.MySQL5Dialect;
import org.junit.Test;

import com.avaje.ebean.config.ServerConfig;

/**
 * @author Administrator
 * 
 */
public class ManyToManyRelationTest extends AbstractEBeanDaoTestCase {

    /**
     * @param args
     */
    @Test
    public void insertManyToMany() {
     logger.info("start insertManyToMany");
        try {
            
            ebeanServer.beginTransaction();

            Author author = new Author();
            author.setAuthorName("Clifford Geertz");
            Author author1 = new Author();
            author1.setAuthorName("JP Morgenthal");
            HashSet authorSet = new HashSet();
            authorSet.add(author);
            authorSet.add(author1);

            Book book = new Book();
            book.setBookName("Phoenix");
            Book book1 = new Book();
            book1.setBookName("Enterprise Applications Integration with XML and Java");

            book.setAuthors(authorSet);
            book1.setAuthors(authorSet);
            logger.info("save book");
//new ServerConfig().setDatabasePlatform(new MySQL5Dialect());
            ebeanServer.save(book);
            ebeanServer.save(book1);
            logger.info("post save book");

            Book bookRecord = ebeanServer.find(Book.class, book.getId());
            System.out.println("Book: " + bookRecord.getBookName());
            Set<Author> authset = bookRecord.getAuthors();
            Iterator it = authset.iterator();
            while (it.hasNext()) {
                Author a = (Author) it.next();
                System.out.println("Author: " + a.getAuthorName());
            }

            ebeanServer.commitTransaction();
            System.out.println("Done");
        } catch (Exception e) {
            logger.warn("test",e);
            Assert.fail();
        }

    }

}
