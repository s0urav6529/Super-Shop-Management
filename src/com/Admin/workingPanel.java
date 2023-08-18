package com.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.Menuitem.Catagory;
import com.Menuitem.ChangePassword;
import com.Menuitem.Clintinfo;
import com.Menuitem.Userinfomation;
import com.Menuitem.OpenningStock;
import com.Menuitem.Productinfo;
import com.Menuitem.PurchaseRecipent;
import com.Menuitem.ReturnToSupplier;
import com.Menuitem.Sales;
import com.Menuitem.SetupReport;
import com.Menuitem.Supplierinfo;
import com.Menuitem.TaskReport;
import com.Menuitem.Update;
import com.Menuitem.Wastage;
import com.Menuitem.Salesreturn;

public class workingPanel extends JPanel
{

	Catagory catagory;
	Productinfo product;
	Clintinfo clint;
	Supplierinfo supplier;
	SetupReport setupreport;
	TaskReport taskreport=new TaskReport();
	OpenningStock openningstock;
	PurchaseRecipent purchaserecipent;
	ReturnToSupplier returntosupplier;
	Sales sales;
	Wastage wastage;
	Update update=new Update();
	Userinfomation userinfo=new Userinfomation();
	ChangePassword changepassword;
	Salesreturn salesreturn;
	
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	
	JPanel panelwestnourth=new JPanel();
	JPanel panelwestcenter=new JPanel();

	JPanel panelwestsetup=new JPanel();
	JPanel panelwestsequrity=new JPanel();
	JPanel panelwestreport=new JPanel();
	JPanel panelwestothers=new JPanel();
	JPanel panelwesttask=new JPanel();
	
	JButton btnsetup=new JButton("Setup");
	JButton btnsecurity=new JButton("Sequrity");
	JButton btnothers=new JButton("Others");
	JButton btnreport=new JButton("Report");
	JButton btntask=new JButton("Task");
	JButton btncatagory=new JButton(new ImageIcon("img/catagory.png"));
	JButton btnsupplier=new JButton(new ImageIcon("img/supplier.png"));
	JButton btnproduct=new JButton(new ImageIcon("img/product.png"));
	JButton btnclint=new JButton(new ImageIcon("img/clint.png"));
	JButton btnsetupreport=new JButton(new ImageIcon("img/btnsetup.png"));
	JButton btntaskreport=new JButton(new ImageIcon("img/taskreport.png"));
	JButton btnupdate=new JButton(new ImageIcon("img/update.png"));
	JButton btnexit=new JButton(new ImageIcon("img/exit.png"));
	JButton btnlogoff=new JButton(new ImageIcon("img/logoff.png"));
	JButton btnnewuser=new JButton(new ImageIcon("img/newuser.png"));
	JButton btnchangepass=new JButton(new ImageIcon("img/changepassword.png"));
	JButton btnopeningstock=new JButton(new ImageIcon("img/openingstock.png"));
	JButton btnpurchasericipent=new JButton(new ImageIcon("img/purchaserecipent.png"));
	JButton btnreturntosupplier=new JButton(new ImageIcon("img/returntosupplier.png"));
	JButton btnsales=new JButton(new ImageIcon("img/sales.png"));
	JButton btnwastage=new JButton(new ImageIcon("img/westage.png"));
	JButton btnsalesreturn=new JButton(new ImageIcon("img/salesreturn.png"));

	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsupplier=new JLabel("Supplier info");
	JLabel lblproduct=new JLabel("product info");
	JLabel lblclint=new JLabel("Clint info");
	JLabel lblsetupreport=new JLabel("Setup report");
	JLabel lbltaskreport=new JLabel("Task report");
	JLabel lblupdate=new JLabel("update");
	JLabel lbllogoff=new JLabel("Log off");
	JLabel lblexit=new JLabel("Exit");
	JLabel lblnewuser=new JLabel("New user");
	JLabel lblchangepass=new JLabel("Change password");
	JLabel lblopeningstock=new JLabel("Opening stock");
	JLabel lblpurchasericipent=new JLabel("purchase recipent");
	JLabel lblreturntosupplier=new JLabel("Return to supplier");
	JLabel lblsales=new JLabel("Sales");
	JLabel lblwastage=new JLabel("Wastage/Broken");
	JLabel lblsalesreturn=new JLabel("Sales return");

	JLabel lblsetupicon=new JLabel(new ImageIcon("img/SETUP.PNG"));
	JLabel lblsupershopicon=new JLabel(new ImageIcon("img/supershop.jpg"));
	JLabel lblreporticon=new JLabel(new ImageIcon("img/REPORT.PNG"));
	JLabel lblsequrityicon=new JLabel(new ImageIcon("img/SEQURITY.PNG"));
	JLabel lbltaskicon=new JLabel(new ImageIcon("img/TASK.PNG"));
	JLabel lblothericon=new JLabel(new ImageIcon("img/OTHRE.PNG"));
	
	JLabel lblwestcenter=new JLabel(new ImageIcon("img/ww.JPG"));
	
	private JFrame frm;
	SessionBean sessionbean;
	public workingPanel(JFrame frame,SessionBean bean)
	{
	 	this.frm=frame;
	    this.sessionbean=bean;
		
	    
		sessionbean.setcompanyname("Binary Care Software");
		sessionbean.setdevloperadress("Software delevoped By:Binary Care Software. Mobile:01837885414");
		sessionbean.setucompanyadress("ChawckBazer Chittagong");
		
		changepassword=new ChangePassword(bean);
		catagory=new Catagory(bean);
		product=new Productinfo(bean);
		clint=new Clintinfo(bean);
		supplier=new Supplierinfo(bean);
		openningstock=new OpenningStock(bean);
		purchaserecipent=new PurchaseRecipent(bean);
		wastage=new Wastage(bean);
		sales=new Sales(bean);
		salesreturn=new Salesreturn(bean);
		returntosupplier=new ReturnToSupplier(bean);
		setupreport=new SetupReport(bean);
		setLayout(new BorderLayout());
		comp();
		btnAction();
		init();	
	}
	public void lbltruefalse()
	{
		lblsequrityicon.setVisible(false);
		lbltaskicon.setVisible(false);
		lblothericon.setVisible(false);
		lblsetupicon.setVisible(false);
		lblreporticon.setVisible(false);
	}
	public void btnAction()
	{
		btnsecurity.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblwestcenter.setVisible(false);
				lblsupershopicon.setVisible(false);
				panelwestcentertruefalse();
				panelwestsequrity.setVisible(true);
				lbltruefalse();
				panelcentertruefalse();
				lblsequrityicon.setVisible(true); 	
			}
		});
		btntask.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblwestcenter.setVisible(false);
				lblsupershopicon.setVisible(false);
				panelwestcentertruefalse();
				panelwesttask.setVisible(true);
				lbltruefalse();
				panelcentertruefalse();
				lbltaskicon.setVisible(true);
			}
		});
		btnreport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblwestcenter.setVisible(false);
				lblsupershopicon.setVisible(false);
				panelwestcentertruefalse();
				panelwestreport.setVisible(true);
				lbltruefalse();
				panelcentertruefalse();
				lblreporticon.setVisible(true);
				setupreport.clientNameLoad();
				setupreport.cmbsuppliernameload();
				setupreport.cmbproductnameload();
				
				setupreport.cmbCatloadforreporttype();
				setupreport.cmbProloadforreporttype();
				setupreport.cmbSubCatloadforreporttype();
			}
		});
		btnsetup.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblsupershopicon.setVisible(false);
				lblwestcenter.setVisible(false);
				panelwestcentertruefalse();
				panelwestsetup.setVisible(true);
				lbltruefalse();
				panelcentertruefalse();
				lblsetupicon.setVisible(true);
			}
		});
		btnothers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblwestcenter.setVisible(false);
				lblsupershopicon.setVisible(false);
				panelwestcentertruefalse();
				panelwestothers.setVisible(true);
				lbltruefalse();
				panelcentertruefalse();
				lblothericon.setVisible(true);
			}
		});	
		btncatagory.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				panelcentertruefalse();
				catagory.setVisible(true);
				catagory.catautoid();
				catagory.catdataload();
				catagory.subautoid();
				catagory.subcatdataload();
				catagory.catcmbsearch();
				catagory.subcatcmbsearch();
			}
		});	
		btnproduct.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				product.setVisible(true);
				product.productautoid();
				product.cmbsearchwork();
				product.tbdataload();
				product.suppliername();
				product.subcatagorydataload();
			}
		});
		btnclint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				clint.setVisible(true);
				clint.clientautoid();
				clint.cmbsearch();
				clint.referenceby();
				clint.tbdataload();
			}
		});	
		btnsupplier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				supplier.setVisible(true);
				supplier.supautoid();
				supplier.tbdataload();
				supplier.cmbsearchwork();
			}
		});	
		btnsetupreport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				setupreport.setVisible(true);
			}
		});	
		btntaskreport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				taskreport.setVisible(true);
			}
		});	
		btnupdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			
				panelcentertruefalse();
				update.setVisible(true);
			}
		});
		btnlogoff.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frm.setVisible(false);
				Chackpassword ckp=new Chackpassword();
			}
		});
		btnexit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(confirm())
				{
					frm.dispose();
				}
			}
		});
		btnopeningstock.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				openningstock.setVisible(true);
				openningstock.stockautoid();
				openningstock.cmbsearch();
				openningstock.tbdataload();
				openningstock.productdataload();
			}
		});	
		btnsalesreturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				salesreturn.setVisible(true);
				salesreturn.productdataload();
				salesreturn.salesdataload();
				salesreturn.salesreturnautoid();
				salesreturn.findtbdataload();
			}
		});
		btnpurchasericipent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				purchaserecipent.setVisible(true);
				purchaserecipent.invoiceautoid();
				purchaserecipent.tbfinddataload();
				purchaserecipent.productdataload();
			}
		});	
		btnreturntosupplier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				returntosupplier.setVisible(true);
				returntosupplier.productdataload();
				returntosupplier.returnautoid();
				returntosupplier.findtbdataload();
			}
		});	
		btnsales.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				sales.setVisible(true);
				sales.salesautoid();
				sales.productdataload();
				sales.clientdataload();
				sales.findtbdataload();
			}
		});	
		btnwastage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelcentertruefalse();
				wastage.setVisible(true);
				wastage.westageautoid();
				wastage.cmbsearch();
				wastage.tbdataload();
				wastage.productdataload();
			}
		});	
		btnnewuser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			
				panelcentertruefalse();
				userinfo.setVisible(true);
				userinfo.newuserautoid();
				userinfo.tbdataload();
				userinfo.cmbloadsearch();
			
			}
		});	
		btnchangepass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			
				panelcentertruefalse();
				changepassword.setVisible(true);
			
			}
		});	
	}

	private void comp()
	{
		setLayout(new BorderLayout());
		add(panelwest,BorderLayout.WEST);
		panelwestwork();
		add(panelcenter,BorderLayout.CENTER);
		panelcenterwork();
	}


	public void panelcenterwork() 
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelcenter.setLayout(flow);
		flow.setVgap(0);
		panelcenter.add(catagory);
		catagory.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(product);
		product.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(clint);
		clint.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(supplier);
		supplier.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(setupreport);
		setupreport.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(taskreport);
		taskreport.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(openningstock);
		openningstock.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(purchaserecipent);
		purchaserecipent.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(returntosupplier);
		returntosupplier.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(sales);
		sales.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(wastage);
		wastage.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(update);
		update.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(userinfo);
		userinfo.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(changepassword);
		changepassword.setPreferredSize(new Dimension(1160,768));
		panelcenter.add(salesreturn);
		salesreturn.setPreferredSize(new Dimension(1160,768));
		panelcentertruefalse();

		panelcenter.add(lblsupershopicon);
		lblsupershopicon.setVisible(true);
		panelcenter.add(lblsetupicon);
		lblsetupicon.setPreferredSize(new Dimension(1160,740));
		panelcenter.add(lblsequrityicon);
		lblsequrityicon.setPreferredSize(new Dimension(1160,740));
		panelcenter.add(lblothericon);
		lblothericon.setPreferredSize(new Dimension(1160,740));
		panelcenter.add(lbltaskicon);
		lbltaskicon.setPreferredSize(new Dimension(1160,740));
		panelcenter.add(lblreporticon);
		lblreporticon.setPreferredSize(new Dimension(1160,740));
		lbltruefalse();
		
	}
	
	public boolean confirm()
	{
		int a=JOptionPane.showConfirmDialog(null, "Do you want to Exit ?","Confirm...",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}

	private void panelcentertruefalse()
	{
		catagory.setVisible(false);
		product.setVisible(false);
		clint.setVisible(false);
		supplier.setVisible(false);
		setupreport.setVisible(false);
		taskreport.setVisible(false);
		userinfo.setVisible(false);
		changepassword.setVisible(false);;
		openningstock.setVisible(false);
		purchaserecipent.setVisible(false);
		returntosupplier.setVisible(false);
		sales.setVisible(false);
		update.setVisible(false);
		wastage.setVisible(false);
		salesreturn.setVisible(false);
		
	}

	private void panelwestwork()  
	{
		panelwest.setLayout(new BorderLayout());
		panelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwest.setPreferredSize(new Dimension(190,0));
		panelwest.add(panelwestnourth,BorderLayout.NORTH);
		panelwestnourth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwestnourthwork();
		panelwest.add(panelwestcenter,BorderLayout.CENTER);
		panelwestcenterwork();
	}

	public void panelwestcenterwork() 
	{
		FlowLayout flow=new FlowLayout();
		panelwestcenter.setLayout(flow);
		flow.setVgap(0);
		panelwestcenter.add(panelwestsetup);
		panelwestsetupwork();
		panelwestcenter.add(panelwestsequrity);
		panelwestsequritywork();
		panelwestcenter.add(panelwestothers);
		panelwestotherswork();
		panelwestcenter.add(panelwesttask);
		panelwesttaskwork();
		panelwestcenter.add(panelwestreport);
		panelwestreportwork();
		panelwestcentertruefalse();
		panelwestcenter.add(lblwestcenter);
		lblwestcenter.setPreferredSize(new Dimension(190,600));
		lblwestcenter.setVisible(true);
		
	}
	
	private void panelwestcentertruefalse()
	{
		panelwestsetup.setVisible(false);
		panelwestsequrity.setVisible(false);
		panelwesttask.setVisible(false);
		panelwestreport.setVisible(false);
		panelwestothers.setVisible(false);
	}

	private void panelwestotherswork() 
	{
		
		panelwestothers.setBackground(Color.DARK_GRAY);
		panelwestothers.setPreferredSize(new Dimension(190,600));
		panelwestothers.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		panelwestothers.add(btnupdate,c);
		btnupdate.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=1;
		panelwestothers.add(lblupdate,c);
		lblupdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblupdate.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=2;
		panelwestothers.add(btnlogoff,c);
		btnlogoff.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=3;
		panelwestothers.add(lbllogoff,c);
		lbllogoff.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lbllogoff.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=4;
		panelwestothers.add(btnexit,c);
		btnexit.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=5;
		panelwestothers.add(lblexit,c);
		lblexit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblexit.setForeground(Color.white);
		
	}

	private void panelwesttaskwork() 
	{
		panelwesttask.setBackground(Color.DARK_GRAY);
		panelwesttask.setPreferredSize(new Dimension(190,600));
		panelwesttask.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
	
		c.gridx=0;
		c.gridy=0;
		panelwesttask.add(btnopeningstock,c);
		btnopeningstock.setBackground(Color.LIGHT_GRAY);
		btnopeningstock.setPreferredSize(new Dimension(25,15));
		
		c.gridx=0;
		c.gridy=1;
		panelwesttask.add(lblopeningstock,c);
		lblopeningstock.setFont(new Font("serif", Font.BOLD+Font.ITALIC,  12));
		lblopeningstock .setForeground(Color.white);
		
		c.gridx=1;
		c.gridy=0;
		panelwesttask.add(btnpurchasericipent,c);
		btnpurchasericipent.setBackground(Color.LIGHT_GRAY);
		btnpurchasericipent.setPreferredSize(new Dimension(25,15));		
		
		c.gridx=1;
		c.gridy=1;
		panelwesttask.add(lblpurchasericipent,c);
		lblpurchasericipent.setFont(new Font("serif", Font.BOLD+Font.ITALIC,  12));
		lblpurchasericipent.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=2;
		panelwesttask.add(btnsales,c);
		btnsales.setBackground(Color.LIGHT_GRAY);
		btnsales.setPreferredSize(new Dimension(25,15));
		
		c.gridx=0;
		c.gridy=3;
		panelwesttask.add(lblsales,c);
		lblsales.setFont(new Font("serif", Font.BOLD+Font.ITALIC,  12));
		lblsales.setForeground(Color.white);
		
		c.gridx=1;
		c.gridy=2;
		panelwesttask.add(btnsalesreturn,c);
		btnsalesreturn.setBackground(Color.LIGHT_GRAY);
		btnsalesreturn.setPreferredSize(new Dimension(25,15));
		
		c.gridx=1;
		c.gridy=3;
		panelwesttask.add(lblsalesreturn,c);
		lblsalesreturn.setFont(new Font("serif", Font.BOLD+Font.ITALIC,  12));
		lblsalesreturn.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=4;
		panelwesttask.add(btnreturntosupplier,c);
		btnopeningstock.setPreferredSize(new Dimension(25,15));
		btnopeningstock.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=5;
		panelwesttask.add(lblreturntosupplier,c);
		lblreturntosupplier.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 12));
		lblreturntosupplier.setForeground(Color.white);
		
		c.gridx=1;
		c.gridy=4;
		panelwesttask.add(btnwastage,c);
		btnwastage.setPreferredSize(new Dimension(25,15));
		btnwastage.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=1;
		c.gridy=5;
		panelwesttask.add(lblwastage,c);
		lblwastage.setFont(new Font("serif", Font.BOLD+Font.ITALIC,  12));
		lblwastage.setForeground(Color.white);
		
	}
	
	private void panelwestreportwork() 
	{
		panelwestreport.setBackground(Color.DARK_GRAY);
		panelwestreport.setPreferredSize(new Dimension(190,600));
		
		panelwestreport.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		panelwestreport.add(btnsetupreport,c);
		btnsetupreport.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=1;
		panelwestreport.add(lblsetupreport,c);
		lblsetupreport.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblsetupreport.setForeground(Color.white);
	
		c.gridx=0;
		c.gridy=2;
		panelwestreport.add(btntaskreport,c);
		btntaskreport.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=3;
		panelwestreport.add(lbltaskreport,c);
		lbltaskreport.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lbltaskreport.setForeground(Color.white);
	}
	
	private void panelwestsequritywork()
	{
		panelwestsequrity.setBackground(Color.DARK_GRAY);
		panelwestsequrity.setPreferredSize(new Dimension(190,600));
		
		panelwestsequrity.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		panelwestsequrity.add(btnnewuser,c);
		btnnewuser.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=1;
		panelwestsequrity.add(lblnewuser,c);
		lblnewuser.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblnewuser.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=2;
		panelwestsequrity.add(btnchangepass,c);
		btnchangepass.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=3;
		panelwestsequrity.add(lblchangepass,c);
		lblchangepass.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblchangepass.setForeground(Color.white);
	}

	private void panelwestsetupwork() 
	{
		panelwestsetup.setBackground(Color.darkGray);
		panelwestsetup.setPreferredSize(new Dimension(190,600));
		panelwestsetup.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();

		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelwestsetup.add(btncatagory,c);
		btncatagory.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=1;
		panelwestsetup.add(lblcatagory,c);
		lblcatagory.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblcatagory.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=2;
		panelwestsetup.add(btnsupplier,c);
		btnsupplier.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=3;
		panelwestsetup.add(lblsupplier,c);
		lblsupplier.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblsupplier.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=4;
		panelwestsetup.add(btnclint,c);
		btnclint.setBackground(Color.LIGHT_GRAY);
		
		c.gridx=0;
		c.gridy=5;
		
		panelwestsetup.add(lblclint,c);
		lblclint.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblclint.setForeground(Color.white);
		
		c.gridx=0;
		c.gridy=6;
		
		panelwestsetup.add(btnproduct,c);
		btnproduct.setBackground(Color.LIGHT_GRAY);
	
		c.gridx=0;
		c.gridy=7;
		
		panelwestsetup.add(lblproduct,c);
		lblproduct.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		lblproduct.setForeground(Color.white);
	}

	private void panelwestnourthwork()
	{
		panelwestnourth.setPreferredSize(new Dimension(190,140));
		panelwestnourth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwestnourth.setLayout(new GridLayout(5,1,0,0));
		panelwestnourth.add(btnsetup);
		btnsetup.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btnsetup.setBackground(Color.DARK_GRAY);
		btnsetup.setForeground(Color.white);
		panelwestnourth.add(btnsecurity);
		btnsecurity.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btnsecurity.setBackground(Color.DARK_GRAY);
		btnsecurity.setForeground(Color.white);
		panelwestnourth.add(btntask);
		btntask.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btntask.setBackground(Color.DARK_GRAY);
		btntask.setForeground(Color.white);
		panelwestnourth.add(btnreport);
		btnreport.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btnreport.setBackground(Color.DARK_GRAY);
		btnreport.setForeground(Color.white);
		panelwestnourth.add(btnothers);
		btnothers.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btnothers.setBackground(Color.DARK_GRAY);
		btnothers.setForeground(Color.white);
		btnothers.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
	}
	public void init() 
	{
		this.frm.setTitle(sessionbean.getusername());
		this.frm.setResizable(true);
	}
}
