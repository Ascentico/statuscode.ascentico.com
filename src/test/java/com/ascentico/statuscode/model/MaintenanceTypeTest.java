package com.ascentico.statuscode.model;

import org.hibernate.usertype.UserType;
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
     * Test the MaintenanceType OK enum.
     *
     */
    @Test
    public void MaintenanceType_OK_Passes() throws Exception {
        MaintenanceType.valueOf(MaintenanceType.OK.toString());
    }

    /**
     * Test the MaintenanceType DOWN enum.
     *
     */
    @Test
    public void MaintenanceType_DOWN_Passes() throws Exception {
        MaintenanceType.valueOf(MaintenanceType.DOWN.toString());
    }

    /**
     * Test the MaintenanceType MAINTENANCE enum.
     *
     */
    @Test
    public void MaintenanceType_MAINTENANCE_Passes() throws Exception {
        MaintenanceType.valueOf(MaintenanceType.MAINTENANCE.toString());
    }

}