/**
 * 
 */
package org.avaje.testSuite.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="bookName", nullable=false, length=250, insertable=true)
	private String bookName;

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	//for joing the tables (many-to-many)
	@ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable(name = "author_book",
	    joinColumns = {
	      @JoinColumn(name="bookId")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="authorId")
	    }
	  )
	  private Set<Author> authors;

	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
}
