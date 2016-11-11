package core._13_enum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei_Doroshenko on 11/11/2016.
 */
public enum JobStatus {
    Starting("STG"),
    Started("STD"),
    Stopping("STPG"),
    Stopped("STPD"),
    Completed("CPLD"),
    Failed("FLD");

    String code;
    static final Map<String, JobStatus> lookup = new HashMap<>();

    static {
        EnumSet.allOf( JobStatus.class ).forEach( s -> lookup.put( s.getCode(), s ) );
    }

    JobStatus ( String code ) {
        this.code = code;
    }

    public String getCode () {
        return this.code;
    }

    public static JobStatus getByCode( String code ) {
        return lookup.get( code );
    }
}
