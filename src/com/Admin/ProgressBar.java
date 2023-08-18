package com.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class ProgressBar extends JWindow
{
	JPanel mainpanel=new JPanel();
	JLabel barimage=new JLabel(new ImageIcon("img/prog.jpg"));
	JProgressBar prgbar=new JProgressBar(0,2000);
	
	public ProgressBar()
	{
		psize();
		work();
	}
	private void work()
	{
		add(mainpanel);
		mainpanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(barimage,BorderLayout.CENTER);
		prgbar.setForeground(Color.green);
		mainpanel.add(prgbar,BorderLayout.SOUTH);
		
		try
		{
			int a;
			for(a=0;a<2000;a++)
			{
				int value=prgbar.getValue();
				if(value<2000)
				{
					prgbar.setValue(++value);
				}
				Thread.sleep(1);
			}
			dispose();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void psize() 
	{
		setSize(400,250);
		setLocationRelativeTo(null);
		setVisible(true);	
	}

}
