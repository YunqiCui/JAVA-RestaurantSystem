package com.rs.tool;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel{

    Image im;
    int w;
    int h;
    public ImagePanel(Image im){

        this.im = im;
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
        h = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(w,h);
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
    }
}
