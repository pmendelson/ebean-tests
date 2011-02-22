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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="parent")
public class Parent {
	
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
	
	@Column(name="pname", nullable=false, length=50, insertable=true)
	private String pname;

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	  @JoinTable(name = "ParentChild", joinColumns = {
	      @JoinColumn(name="parentId", unique = true)           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="childrenId")
	    }
	  )
	  private Set<Child> children;

	/**
	 * @return the children
	 */
	public Set<Child> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<Child> children) {
		this.children = children;
	}
		
}
