package com.rs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

    Connection ct = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String drivername = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";
    String dburl = "jdbc:mysql://localhost:3306/restaurantsystem";
    public SqlHelper(){

        try {
            Class.forName(drivername);
            ct = DriverManager.getConnection(dburl,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet query(String sql, String[] paras){

        try {
            ps = ct.prepareStatement(sql);
            for (int i = 0; i < paras.length; i++) {
                ps.setString(i+1, paras[i]);
            }
            rs = ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public void closeResources(){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(!ct.isClosed()){
                ct.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
