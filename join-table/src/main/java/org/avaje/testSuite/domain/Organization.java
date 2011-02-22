package org.avaje.testSuite.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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


@Entity
@Table(name = "ORGANIZATION")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private String regionCode;
    private String labCode;

    private Long id;

    private String organizationName;

    public Organization() {
    }

    public Organization(Long id, String organizationName) {
        this.id = id;
        this.organizationName = organizationName;
    }

    @Id
    @Column(name = "ORGANIZATION_ID")
    @GeneratedValue(generator = "ORGANIZATION_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ORGANIZATION_SEQ", sequenceName = "ORGANIZATION_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ORGANIZATION_NAME")
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Column(name = "REGION_CODE")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Column(name = "LAB_CODE")
    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    // /**
    // * Returns all Roles of this Organization.
    // */
    // @OneToMany
    // @JoinTable(name="ORG_DEFAULT_ROLE",
    // joinColumns = @JoinColumn( name="ORGANIZATION_ID"),
    // inverseJoinColumns = @JoinColumn( name="ROLE_ID"))
    // public Set<Role> getRoles() {
    // if (roles == null) {
    // roles = new LinkedHashSet<Role>();
    // }
    // return roles;
    // }
    //
    // public void setRoles(Set<Role> roles) {
    // this.roles = roles;
    // }
}
