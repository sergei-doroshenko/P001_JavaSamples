package core._13_enum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergei_Doroshenko on 11/11/2016.
 */
public class JobStatusTest {

    @Test
    public void testStatus() {
        JobStatus jobStatus = JobStatus.getByCode( "CPLD" );

        assertEquals( JobStatus.Completed, jobStatus );
    }
}
