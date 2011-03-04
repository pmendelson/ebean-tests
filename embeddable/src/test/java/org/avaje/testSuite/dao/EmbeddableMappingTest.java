package org.avaje.testSuite.dao;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.avaje.testSuite.domain.Organization;

public class EmbeddableMappingTest extends AbstractEBeanDaoTestCase {
    private static final Logger logger = LoggerFactory.getLogger(EmbeddableMappingTest.class);

    @Test
    public void shouldFindOrg() {
        logger.debug("start shouldFindUser()");
        try {
            Organization directOrg = ebeanServer.find(Organization.class, 2000);
            logger.info("directOrg={}",directOrg.getOrganizationName());
            Assert.assertNotNull(directOrg);
            Assert.assertEquals(directOrg.getMailingAddress().getZip(), "2001");
        } catch (Exception e) {
            logger.warn("oops",e);
            Assert.fail();
        }
    }

    @Test
    public void shouldInsertOrg() {
        logger.debug("start shouldFindUser()");
        try {
            Organization obj = new Organization();
            obj.setOrgCode("neworg");
            obj.setOrganizationName("test org");
//            obj.setOrganization(ebeanServer.find(Organization.class, 2000));
            //logger.info("user={}  directOrg={}",testUser.getUsername(), directOrg.getOrganizationName());
            ebeanServer.save(obj);
        } catch (Exception e) {
            logger.warn("oops",e);
            Assert.fail();
        }
    }
}
