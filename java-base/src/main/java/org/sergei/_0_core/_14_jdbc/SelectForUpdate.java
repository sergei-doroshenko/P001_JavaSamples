package org.sergei._0_core._14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergei_Doroshenko on 1/30/2017.
 */
public class SelectForUpdate {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/wf_datastore";

    //  Database credentials
    static final String USER = "mturk";
    static final String PASS = "mturk";

    public static void main(String[] args) {
//        setectAndList();
        setectAndUpdate();
    }//end main

    public static void setectAndUpdate() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM public.ds_user_datastore WHERE status = 'AVAILABLE' for update";
            ResultSet rs = stmt.executeQuery(sql);
            String userId = null;

            while(rs.next()){
                userId  = rs.getString("user_id");
                System.out.println("userId: " + userId);
                break;
            }

            if (userId != null) {
                sql = "UPDATE public.ds_user_datastore SET status = 'LOCKED' WHERE user_id = '" + userId + '\'';
                int result = stmt.executeUpdate(sql);
                System.out.println("Thread: " + Thread.currentThread().getName() + " locked: " + result + " user(s) with user_id: " + userId);
                Thread.currentThread().sleep(20000);
                sql = "UPDATE public.ds_user_datastore SET status = 'AVAILABLE' WHERE user_id = '" + userId + '\'';
                result = stmt.executeUpdate(sql);
                System.out.println("Thread: " + Thread.currentThread().getName() +" released: " + result + " user(s) with user_id: " + userId);
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void setectAndList() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM public.ds_user_datastore for update";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt(1);
                String status = rs.getString(2);
                String userId = rs.getString(3);

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Status: " + status);
                System.out.print(", userId: <" + userId + ">\n");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
