package org.sergei._0_core._13_enum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei_Doroshenko on 11/11/2016.
 */
public enum JobStatus {
    STARTING("Stg"),
    STARTED("Std"),
    STOPPING("Stpg"),
    STOPPED("Stpd"),
    COMPLETED("Cpld"),
    FAILED("Fld");

    String code;
    static final Map<String, JobStatus> lookup = new HashMap<>();

    static {
        EnumSet.allOf( JobStatus.class ).forEach( s -> lookup.put( s.getCode().toLowerCase(), s ) );
    }

    JobStatus ( String code ) {
        this.code = code;
    }

    public String getCode () {
        return this.code;
    }

    public static JobStatus getByCode( String code ) {
        return lookup.get( code.toLowerCase() );
    }
}
