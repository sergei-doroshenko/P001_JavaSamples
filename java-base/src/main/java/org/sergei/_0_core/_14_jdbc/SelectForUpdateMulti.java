package org.sergei._0_core._14_jdbc;

/**
 * Created by Sergei_Doroshenko on 1/30/2017.
 */
public class SelectForUpdateMulti {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/wf_datastore";

    //  Database credentials
    static final String USER = "mturk";
    static final String PASS = "mturk";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new SelectUpdateRunnable(JDBC_DRIVER, DB_URL, USER, PASS)).start();
        }
    }
}
