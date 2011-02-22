package org.avaje.testSuite.dao;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.avaje.testSuite.domain.User;
import org.avaje.testSuite.domain.Organization;

public class UserMappingTest extends AbstractEBeanDaoTestCase {
    private static final Logger logger = LoggerFactory.getLogger(UserMappingTest.class);

    @Test
    public void shouldFindUser() {
        logger.debug("start shouldFindUser()");
        try {
            User testUser = ebeanServer.find(User.class, 1201);
            Organization directOrg = ebeanServer.find(Organization.class, 2000);
            logger.info("user={}  directOrg={}",testUser.getUsername(), directOrg.getOrganizationName());
            Assert.assertNotNull(testUser);
            logger.info("org viamap={}",testUser.getOrganization().getOrganizationName());
            Assert.assertNotNull(testUser.getOrganization());
            Assert.assertEquals(directOrg.getOrganizationName(), testUser.getOrganization().getOrganizationName());
        } catch (Exception e) {
            logger.warn("oops",e);
            Assert.fail();
        }
    }

    @Test
    public void shouldInsertUser() {
        logger.debug("start shouldFindUser()");
        try {
            User testUser = new User();
            testUser.setLastName("newu");
            testUser.setOrganization(ebeanServer.find(Organization.class, 2000));
            //logger.info("user={}  directOrg={}",testUser.getUsername(), directOrg.getOrganizationName());
            ebeanServer.save(testUser);
        } catch (Exception e) {
            logger.warn("oops",e);
            Assert.fail();
        }
    }
}
