/*
* JLable, JTextField, JPasswordField
*
*/


package com.rs.view;



import com.rs.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLogin extends JFrame implements ActionListener{

    private JLabel jl1, jl2,jl3;
    private JTextField jtx1;
    private JPasswordField jpf1;
    private JButton jb1,jb2;
    private JPanel jp1,jp2,jp3,jp4,jp5;
    int width,height;

    public UserLogin(){

        jl1 = new JLabel("Username");
        jl2 = new JLabel("Password");
        jl3 = new JLabel(new ImageIcon("src/main/resources/images/logo/restaurant-logo-360.png"));

        jtx1 = new JTextField(10);
        jpf1 = new JPasswordField(10);

        jb1 = new JButton("Login");
        jb1.addActionListener(this);
        jb2 = new JButton("Cancel");
        jb2.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        this.setLayout(new GridLayout(2,1));

        jp1.add(jl1);
        jp1.add(jtx1);
        jp2.add(jl2);
        jp2.add(jpf1);
        jp3.add(jb1);
        jp3.add(jb2);
        jp4.add(jl3);

        jp5.add(jp1);
        jp5.add(jp2);
        jp5.add(jp3);

        this.add(jp4);
        this.add(jp5);

//        this.setUndecorated(true);

        this.setSize(360,300);
        width=Toolkit.getDefaultToolkit().getScreenSize().width;
        height=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(width/2-200,height/2-150);
        this.setTitle("Welcome to Restaurant Manager!");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            String u = this.jtx1.getText().trim();
            String p = new String(this.jpf1.getPassword());

            User us = new User();
            String result = us.checkUser(u,p);
            System.out.println(result);
            if(result.equals("Vice-President") || result.equals("Manager")){
                new MainFrame();
                this.dispose();
            }

        }else if(e.getSource() == jb2){
            this.jtx1.setText("");
            this.jpf1.setText("");
        }
    }
}
