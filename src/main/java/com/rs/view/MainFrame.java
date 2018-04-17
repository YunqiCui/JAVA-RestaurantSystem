/*
 * JMenu
 */


package com.rs.view;


import com.rs.tool.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;


public class MainFrame extends JFrame implements ActionListener, MouseListener {

    private JMenuBar jmb;
    private JMenu jm1, jm2, jm3, jm4, jm5, jm6;
    private JMenuItem item1, item2, item3, item4, item5;
    private ImageIcon icon1, icon2, icon3, icon4;

    private JToolBar jtb;
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;

    private JPanel jp1, jp2, jp3, jp4, jp5;
    private JLabel p1_lab1, p1_lab2, p1_lab3, p1_lab4, p1_lab5, p1_lab6, p1_lab7, p1_lab8, p2_lab1, p2_lab2;
    private JSplitPane jsp;
    private CardLayout cl;
    private ImagePanel ip1;
    private JLabel jl1;

    private Container ct;
    private Timer t;
    private Image timebg;


    public static void main(String[] args) {
        MainFrame np = new MainFrame();
    }

    public MainFrame() {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        this.initMenubar();
        this.initToolbar();
        this.initStatusbar();
        this.initmiddleArea();
        this.initMainArea();

        int width, height;
        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;

        ct = this.getContentPane();
        ct.add(jtb, "North");
        ct.add(jsp, "Center");
        jtb.setFloatable(false);
        ct.add(jp5, "South");

        this.setJMenuBar(jmb);
        this.setTitle("Restaurant Manager");
        this.setSize(width, height - 30);
        this.setLocation(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initMenubar() {

        jmb = new JMenuBar();

        jm1 = new JMenu("Setting");
        jm2 = new JMenu("Staff");
        jm3 = new JMenu("Menu");
        jm4 = new JMenu("Reports");
        jm5 = new JMenu("Inventory");
        jm6 = new JMenu("Help");

        icon1 = new ImageIcon("src/main/resources/images/view/menubar/userswitch-15.png");
        icon2 = new ImageIcon("src/main/resources/images/view/menubar/restaurant-15.png");
        icon3 = new ImageIcon("src/main/resources/images/view/menubar/accounts-15.png");
        icon4 = new ImageIcon("src/main/resources/images/view/menubar/calender-15.png");

        item1 = new JMenuItem("Switch Account", icon1);
        item2 = new JMenuItem("Restaurant Terminal", icon2);
        item3 = new JMenuItem("Accounts", icon3);
        item4 = new JMenuItem("Calendar", icon4);
        item5 = new JMenuItem("Exit");

        jm1.add(item1);
        jm1.add(item2);
        jm1.add(item3);
        jm1.add(item4);
        jm1.add(item5);

        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        jmb.add(jm4);
        jmb.add(jm5);
        jmb.add(jm6);
    }


    //初始化工具栏
    public void initToolbar() {
        jtb = new JToolBar();

        jb1 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/restaurant-20.png"));
        jb1.setToolTipText("Restaurant");
        jb2 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/userswitch-20.png"));
        jb2.setToolTipText("Switch Account");
        jb3 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/accounts-20.jpeg"));
        jb3.setToolTipText("Manage Accounts");
        jb4 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/info.jpg"));
        jb4.setToolTipText("Employee Info");
        jb5 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/robot.jpg"));
        jb5.setToolTipText("Change Password");
        jb6 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/uDisk.jpg"));
        jb6.setToolTipText("Menu Info");
        jb7 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/wnl.jpg"));
        jb7.setToolTipText("Add Menu");
        jb8 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/fish.jpg"));
        jb8.setToolTipText("Update Menu");
        jb9 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/butterfly.jpg"));
        jb9.setToolTipText("Update Cost");
        jb10 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/earth.jpg"));
        jb10.setToolTipText("Working Schedule");

        jtb.add(jb1);
        jtb.add(jb2);
        jtb.add(jb3);
        jtb.addSeparator();
        jtb.add(jb4);
        jtb.add(jb5);
        jtb.add(jb6);
        jtb.add(jb7);
        jtb.addSeparator();
        jtb.add(jb8);
        jtb.add(jb9);
        jtb.add(jb10);
    }

    public void initmiddleArea() {
        jp1 = new JPanel(new BorderLayout());
        try {
            Image im = ImageIO.read(new File("src/main/resources/images/view/background/bg-white-1600.jpg"));
            this.ip1 = new ImagePanel(im);

            ip1.setLayout(new GridLayout(8, 1));

            p1_lab1 = new JLabel(new ImageIcon("src/main/resources/images/view/background/restaurant-logo-360.png"));
            p1_lab2 = new JLabel("Staff Management", new ImageIcon("src/main/resources/images/view/background/panel1/staff-35.png"), 0);
            p1_lab3 = new JLabel("Account Manager", new ImageIcon("src/main/resources/images/view/background/panel1/account-35.png"), 0);
            p1_lab4 = new JLabel("Menu Management", new ImageIcon("src/main/resources/images/view/background/panel1/menu-35.png"), 0);
            p1_lab5 = new JLabel("Business Reports", new ImageIcon("src/main/resources/images/view/background/panel1/report-35.png"), 0);
            p1_lab6 = new JLabel("Cost Management", new ImageIcon("src/main/resources/images/view/background/panel1/cost-35.png"), 0);
            p1_lab7 = new JLabel("System Settings", new ImageIcon("src/main/resources/images/view/background/panel1/setting-35.png"), 0);
            p1_lab8 = new JLabel("Graphic Helping", new ImageIcon("src/main/resources/images/view/background/panel1/cg-35.png"), 0);

            p1_lab2.setIconTextGap(6);
            p1_lab3.setIconTextGap(8);
            p1_lab4.setIconTextGap(3);
            p1_lab5.setIconTextGap(10);
            p1_lab6.setIconTextGap(2);
            p1_lab7.setIconTextGap(14);
            p1_lab8.setIconTextGap(14);

            p1_lab2.setForeground(Color.gray);
            p1_lab3.setForeground(Color.gray);
            p1_lab4.setForeground(Color.gray);
            p1_lab5.setForeground(Color.gray);
            p1_lab6.setForeground(Color.gray);
            p1_lab7.setForeground(Color.gray);
            p1_lab8.setForeground(Color.gray);

            p1_lab2.addMouseListener(this);
            p1_lab3.addMouseListener(this);
            p1_lab4.addMouseListener(this);
            p1_lab5.addMouseListener(this);
            p1_lab6.addMouseListener(this);
            p1_lab7.addMouseListener(this);
            p1_lab8.addMouseListener(this);

            ip1.add(p1_lab1);
            ip1.add(p1_lab2);
            ip1.add(p1_lab3);
            ip1.add(p1_lab4);
            ip1.add(p1_lab5);
            ip1.add(p1_lab6);
            ip1.add(p1_lab7);
            ip1.add(p1_lab8);

            jp1.add(ip1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initMainArea() {

        p2_lab1 = new JLabel(new ImageIcon("src/main/resources/images/view/background/panel2/p2_left.jpg"));
        p2_lab2 = new JLabel(new ImageIcon("src/main/resources/images/view/background/panel2/p2_right.jpg"));

        jp2 = new JPanel(new CardLayout());
        jp2.add(p2_lab1, "0");
        jp2.add(p2_lab2, "1");

        cl = new CardLayout();
        jp3 = new JPanel(cl);
        ImagePanel imagePanel = null;

        try {
            Image im = ImageIO.read(new File("src/main/resources/images/view/background/bg-1920.jpg"));
            imagePanel = new ImagePanel(im);

        } catch (IOException e) {
            e.printStackTrace();
        }

        jp3.add(imagePanel, "0");

        jp4 = new JPanel(new BorderLayout());
        jp4.add(jp2, "West");
        jp4.add(jp3, "Center");

        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1, jp4);
        jsp.setDividerLocation(365);
        jsp.setDividerSize(0);
    }

    public void initStatusbar() {

        try {
            timebg = ImageIO.read(new File("src/main/resources/images/view/statusbar/timebg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jl1 = new JLabel(Calendar.getInstance().getTime().toString());

        ImagePanel ip = new ImagePanel(timebg);
        ip.setLayout(new BorderLayout());
        ip.add(jl1, "East");
        jp5 = new JPanel(new BorderLayout());
        jp5.add(ip);

        t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        this.jl1.setText(Calendar.getInstance().getTime().toString() + "    ");
    }

    public void mouseClicked(MouseEvent e) {
//        if(e.getSource()==p1_lab2){
//            this.cl.show(jp3,"1");
//        }else if(e.getSource()==p1_lab3){
//            this.cl.show(jp3,"2");
//        }else if(e.getSource()==p1_lab4){
//            this.cl.show(jp3,"3");
//        }else if(e.getSource()==p1_lab5){
//            this.cl.show(jp3,"0");
//        }

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == p1_lab2) {
            this.labelOperate(this.p1_lab2, 1);

        } else if (e.getSource() == p1_lab3) {
            this.labelOperate(this.p1_lab3, 1);

        } else if (e.getSource() == p1_lab4) {
            this.labelOperate(this.p1_lab4, 1);

        } else if (e.getSource() == p1_lab5) {
            this.labelOperate(this.p1_lab5, 1);

        } else if (e.getSource() == p1_lab6) {
            this.labelOperate(this.p1_lab6, 1);

        } else if (e.getSource() == p1_lab7) {
            this.labelOperate(this.p1_lab7, 1);

        } else if (e.getSource() == p1_lab8) {
            this.labelOperate(this.p1_lab8, 1);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == p1_lab2) {
            this.labelOperate(this.p1_lab2, 0);

        } else if (e.getSource() == p1_lab3) {
            this.labelOperate(this.p1_lab3, 0);

        } else if (e.getSource() == p1_lab4) {
            this.labelOperate(this.p1_lab4, 0);

        } else if (e.getSource() == p1_lab5) {
            this.labelOperate(this.p1_lab5, 0);

        } else if (e.getSource() == p1_lab6) {
            this.labelOperate(this.p1_lab6, 0);

        } else if (e.getSource() == p1_lab7) {
            this.labelOperate(this.p1_lab7, 0);

        } else if (e.getSource() == p1_lab8) {
            this.labelOperate(this.p1_lab8, 0);

        }
    }

    public void labelOperate(JLabel jl, int i) {
        if (i == 1) {
            jl.setForeground(Color.black);
            jl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        } else if (i == 0) {
            jl.setForeground(Color.gray);

        }
    }
}
