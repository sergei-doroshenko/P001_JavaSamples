package org.sergei._0_core._13_enum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergei_Doroshenko on 11/11/2016.
 */
public class JobStatusTest {

    @Test
    public void testStatus() {
        JobStatus jobStatus = JobStatus.getByCode( "Cpld" );
        System.out.println(jobStatus);
        assertEquals( JobStatus.COMPLETED, jobStatus );

        //****************************************************
        System.out.println(JobStatus.FAILED.name().equals("FAILED"));

    }
}
