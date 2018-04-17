package com.rs.model;

import com.rs.db.SqlHelper;

import java.sql.ResultSet;

public class User {

    String occupsearch = "select e.occup from loginauth l,employee e where l.empno = e.empno and l.empno = ? and l.password = ?";
    ResultSet rs;
    SqlHelper sh;

    public String checkUser(String uid, String password) {
        String occup = "";
        String paras[] = {uid, password};
        sh = new SqlHelper();
        rs = sh.query(occupsearch, paras);
        try {
            if (rs.next()) {
                occup = rs.getString(1);
            }else{
                System.out.println("No result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sh.closeResources();
        }
        return occup;
    }
}
