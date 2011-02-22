package org.avaje.testSuite.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;


@Entity
@Table(name = "USER_T")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinTable(name = "USER_ORGANIZATION", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
    private Organization organization;
 
    public User() {
    }

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * Returns the full name as <code>[lastName], [firstName]</code>.
     */
    @Transient
    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    /**
     * Copies all data from this User to a new User object.
     * <p>
     * This is a shallow copy, meaning collection elements are copied by reference.
     * 
     * @return The new copy.
     */
    public User copy() {
        try {
            return (User) BeanUtils.cloneBean(this);
        } catch (Exception e) {
            throw new IllegalStateException("Error while copying " + this, e);
        }
    }
//
//    @Override
//    public String toString() {
//        return LangUtils.newToStringBuilder(this).append("username", getUsername()).toString();
//    }

}
