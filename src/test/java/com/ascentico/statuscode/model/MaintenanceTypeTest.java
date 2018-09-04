package com.ascentico.statuscode.model;

import org.hibernate.usertype.UserType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The MaintenanceTypeTest class is a test class that
 * tests the values of the ENUM MaintenanceType. These
 * tests do very little, but by including it we can
 * always reacting to a less than 100% coverage report
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-09-03
 */

public class MaintenanceTypeTest {

    /**
     * Test MaintenanceType.OK.getDisplayName().
     *
     */
    @Test
    public void MaintenanceType_getDisplayName_OK_Passes() throws Exception {
        Assert.assertEquals("Incorrect display name","OK", MaintenanceType.OK.getDisplayName());
    }

    /**
     * Test MaintenanceType.DOWN.getDisplayName().
     *
     */
    @Test
    public void MaintenanceType_getDisplayName_DOWN_Passes() throws Exception {
        Assert.assertEquals("Incorrect display name", "DOWN", MaintenanceType.DOWN.getDisplayName());
    }

    /**
     * Test MaintenanceType.MAINTENANCE.getDisplayName().
     *
     */
    @Test
    public void MaintenanceType_getDisplayName_MAINTENANCE_Passes() throws Exception {
        Assert.assertEquals("Incorrect display name", "MAINTENANCE", MaintenanceType.MAINTENANCE.getDisplayName());
    }

}