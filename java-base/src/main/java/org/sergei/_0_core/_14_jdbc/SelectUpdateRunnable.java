package org.sergei._0_core._14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergei_Doroshenko on 1/30/2017.
 */
public class SelectUpdateRunnable implements Runnable {

    private final String jdbcDriver;
    private final String dbUrl;
    private final String user;
    private final String pass;

    public SelectUpdateRunnable(String jdbcDriver, String dbUrl, String user, String pass) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.user = user;
        this.pass = pass;
    }

    private String getAvailableUser() {
        Connection conn = null;
        Statement stmt = null;
        String userId = null;
        try{
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl,user,pass);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM public.ds_user_datastore WHERE status = 'AVAILABLE' for update";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                userId  = rs.getString("user_id");
                System.out.println("userId: " + userId);
                break;
            }

            if (userId != null) {
                sql = "UPDATE public.ds_user_datastore SET status = 'LOCKED' WHERE user_id = '" + userId + '\'';
                int result = stmt.executeUpdate(sql);
                System.out.println("Thread: " + Thread.currentThread().getName() + " locked: " + result + " user(s) with user_id: " + userId);
            }

            conn.commit();
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
            }
        }

        return userId;
    }

    private void releaseTheUser(String userId) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl,user,pass);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql;

            if (userId != null) {
                sql = "UPDATE public.ds_user_datastore SET status = 'AVAILABLE' WHERE user_id = '" + userId + '\'';
                int result = stmt.executeUpdate(sql);
                System.out.println("Connection: transaction isolation: "
                        + stmt.getConnection().getTransactionIsolation()
                        + ", autocommit: "
                        + stmt.getConnection().getAutoCommit());
                System.out.println("Thread: " + Thread.currentThread().getName() +" released: " + result + " user(s) with user_id: " + userId);
            }
            conn.commit();

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
            }
        }
    }

    @Override
    public void run() {
        String userId = null;
        while (userId == null) {
            userId = getAvailableUser();
            if (userId == null) {
                System.out.println("Thread: " + Thread.currentThread().getName() +" didn't find user, sleeping...");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        releaseTheUser(userId);
    }
}
