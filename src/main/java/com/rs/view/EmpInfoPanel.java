package com.rs.view;

import com.rs.model.Employee;

import javax.swing.*;
import java.awt.*;

public class EmpInfoPanel extends JPanel{

    private JPanel jp1,jp2,jp3,jp4,jp5;
    private JTable jtb;
    private JScrollPane jsp;
    private JButton jb1, jb2, jb3, jb4,jb5;
    private JTextField jtf;
    private JLabel jl1,jl2;
    private Employee emp = null;


    public EmpInfoPanel(){
        this.setLayout(new BorderLayout());

        this.initTop();
        this.initMiddle();
        this.initBottom();
        this.setVisible(true);
    }

    public void initTop(){
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jl1 = new JLabel("Employee Number(or occupation):   ");
        jtf = new JTextField(30);
        jb1 = new JButton("Search");

        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jb1);
        this.add(jp1,BorderLayout.NORTH);
    }

    public void initMiddle(){
        String searchEmp = "Select empno,ftname,lname,gender,dob,occup from employee";
        String paras[] ={};

        emp = new Employee();
        emp.query(searchEmp,paras);


        jtb = new JTable(emp);
        jtb.setName("EmpInfo");

        jsp = new JScrollPane(jtb);

        jp2 = new JPanel(new BorderLayout());
        jp2.add(jsp);

        this.add(jp2,BorderLayout.CENTER);
    }


    public void initBottom(){

        jp3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        jl2 = new JLabel("Displaying " + emp.getRowCount() +" records...");
        jp3.add(jl2);

        jb2 = new JButton("Details");
        jb3 = new JButton("Add");
        jb4 = new JButton("Edit");
        jb5 = new JButton("Delete");

        jp4 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        jp4.add(jb2);
        jp4.add(jb3);
        jp4.add(jb4);
        jp4.add(jb5);

        jp5 = new JPanel(new BorderLayout());
        jp5.add(jp3,"West");
        jp5.add(jp4,"East");

        this.add(jp5,BorderLayout.SOUTH);
    }

}
