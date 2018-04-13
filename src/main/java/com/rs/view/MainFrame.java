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
import java.io.File;
import java.io.IOException;
import java.util.Calendar;


public class MainFrame extends JFrame implements ActionListener{

    private JMenuBar jmb;
    private JMenu jm1, jm2, jm3, jm4, jm5, jm6;
    private JMenuItem item1, item2, item3, item4, item5;
    private ImageIcon icon1, icon2, icon3, icon4;

    private JToolBar jtb;
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;

    private JPanel jp1, jp2, jp3, jp4, jp5;
    private JLabel jl1;
    private Container ct;
    private Timer t;

    private Image timebg;
    int width, height;
    //    Image titleIcon;

    public static void main(String[] args) {
        MainFrame np = new MainFrame();
    }

    public MainFrame() {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        initMenubar();
        initToolbar();
        initStatusbar();

//        titleIcon = new ImageIcon("/Users/cuiyunqi/Desktop/HSP/Projects/RestaurantSystem/src/main/resources/images/logo/restaurant-logo-22.png").getImage();
//        this.setIconImage(titleIcon);

        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;

        ct = this.getContentPane();
        ct.add(jtb, "North");
        jtb.setFloatable(false);
        ct.add(jp5,"South");

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
//        jm1.setMnemonic('F');
        jm2 = new JMenu("Staff");
//        jm2.setMnemonic('E');
        jm3 = new JMenu("Menu");
//        jm3.setMnemonic('O');
        jm4 = new JMenu("Reports");
//        jm4.setMnemonic('V');
        jm5 = new JMenu("Inventory");
//        jm5.setMnemonic('I');
        jm6 = new JMenu("Help");
//        jm6.setMnemonic('H');

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

    public void initToolbar() {
        jtb = new JToolBar();

        jb1 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/restaurant-20.png"));
        jb1.setToolTipText("Restaurant");
        jb2 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/userswitch-20.png"));
        jb2.setToolTipText("Switch Account");
        jb3 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/accounts-20.jpeg"));
        jb3.setToolTipText("Manage Accounts");
        jb4 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/info.jpg"));
        jb4.setToolTipText("");
        jb5 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/robot.jpg"));
        jb5.setToolTipText("");
        jb6 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/uDisk.jpg"));
        jb6.setToolTipText("");
        jb7 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/wnl.jpg"));
        jb7.setToolTipText("");
        jb8 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/fish.jpg"));
        jb8.setToolTipText("");
        jb9 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/butterfly.jpg"));
        jb9.setToolTipText("");
        jb10 = new JButton(new ImageIcon("src/main/resources/images/view/toolbar/earth.jpg"));
        jb10.setToolTipText("");
        //Clear Button Border
//            JButton[] jblist = {jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10};
//            ButtonBorder bb = new ButtonBorder();
//            bb.cleanButtonBorder(jblist);

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

    public void initStatusbar() {

        try {
            timebg = ImageIO.read(new File("src/main/resources/images/view/statusbar/timebg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImagePanel ip = new ImagePanel(timebg);
        ip.setLayout(new BorderLayout());

        jl1 = new JLabel(Calendar.getInstance().getTime().toString());
        jp5 = new JPanel(new BorderLayout());
        ip.add(jl1,"East");
        jp5.add(ip);

        t = new Timer(1000,this);
        t.start();

    }

    public void actionPerformed(ActionEvent e) {
        this.jl1.setText(Calendar.getInstance().getTime().toString() + "    ");
    }
}
