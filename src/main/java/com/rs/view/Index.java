
package com.rs.view;
import java.awt.*;
import javax.swing.*;
public class Index extends JWindow implements Runnable{

	JProgressBar jpb;
	JLabel jl1;
	int width,height;

    int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
	public static void main(String []args){
		Index index=new Index();

		Thread t=new Thread(index);

		t.start();
	}

	public Index()
	{	

		jl1=new JLabel(new ImageIcon("src/main/resources/images/logo/restaurant-logo-400.png"));
		jpb=new JProgressBar();

		jpb.setStringPainted(true);
		jpb.setIndeterminate(false);
		jpb.setBorderPainted(false);
		jpb.setBackground(Color.darkGray);

		this.add(jl1,BorderLayout.NORTH);
		this.add(jpb,BorderLayout.SOUTH);
		this.setSize(400,263);

		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
	}

	public void run() {

		for(int i=0;i<progressValue.length;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);

		}
        new UserLogin();
		this.dispose();
	}
}