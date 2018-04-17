package com.rs.model;

import com.rs.db.SqlHelper;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class Employee extends AbstractTableModel{
    private ResultSet rs = null;
    private ResultSetMetaData rsmt;
    private SqlHelper sh = null;
    private Vector<String> colums;
    private Vector<Vector> rows;

    public void query(String sql, String[] paras){
        this.colums = new Vector<String>();
        rows = new Vector<Vector>();
        sh = new SqlHelper();
        rs = sh.query(sql,paras);
        try {
            rsmt = rs.getMetaData();
            for (int i = 0; i < rsmt.getColumnCount(); i++) {
                this.colums.add(rsmt.getColumnName(i+1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
        while(rs.next()){
            Vector<String> temp = new Vector<String>();
            for (int i = 0; i < rsmt.getColumnCount(); i++) {
                temp.add(rs.getString(i+1));
            }
            rows.add(temp);
        }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sh.closeResources();
        }
    }
    public int getRowCount() {
        return this.rows.size();
    }

    public int getColumnCount() {
        return this.colums.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (rows.get(rowIndex)).get(columnIndex);
    }

    @Override
    public String getColumnName(int i){
       return this.colums.get(i).toString();
        }
}
