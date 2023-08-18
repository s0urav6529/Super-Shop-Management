package com.Main;
import javax.swing.UIManager;

import com.Admin.Chackpassword;
import com.Admin.Dbconection;
import com.Admin.ProgressBar;

public class Mainclass 
{
	public  static void main(String args[])
	{
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		Dbconection.conect();
		ProgressBar pb=new ProgressBar();
		Chackpassword cp=new Chackpassword();	
	}
}
