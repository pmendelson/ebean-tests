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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="author")
public class Author {
	
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
	
	@Column(name="authorName", nullable=false, length=50, insertable=true)
	private String authorName;

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	//for joing the tables (many-to-many)
	@ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable(name = "author_book",
	    joinColumns = {
	      @JoinColumn(name="authorId")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="bookId")
	    }
	  )
	  private Set<Book> books;

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
