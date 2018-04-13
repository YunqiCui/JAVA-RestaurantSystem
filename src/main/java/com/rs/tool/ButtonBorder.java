package com.rs.tool;

import javax.swing.*;

public class ButtonBorder {
    public void cleanButtonBorder(JButton []jb){
        for (int i = 0; i < jb.length; i++) {
            jb[i].setBorderPainted(false);
        }
    }
}
