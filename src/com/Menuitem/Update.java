package com.Menuitem;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Update extends JPanel
{
	JLabel lblname=new JLabel("UPDATE");
	
	public Update()
	{
		setBackground(Color.white);
		comp();
	}
	private void comp() {
		setLayout(new FlowLayout());
		add(lblname);
		
		
	}

}
