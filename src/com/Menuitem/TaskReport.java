package com.Menuitem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class TaskReport extends JPanel
{	
	
	JPanel panelitem=new JPanel();
	JPanel panelsales=new JPanel();
	JPanel panelproduct=new JPanel();
	JPanel panelstock=new JPanel();
	
	
	//item
	JPanel ipanelnorth=new JPanel();
	JPanel ipanelwest=new JPanel();
	JPanel ipanelcenter=new JPanel();
	
	
	//sales
	JPanel spanelcenter=new JPanel();
	JPanel spanelnorth=new JPanel();
	JPanel spanelwest=new JPanel();
	
	//stock
	JPanel stpanelcenter=new JPanel();
	JPanel stpanelnorth=new JPanel();
	JPanel stpanelwest=new JPanel();
	
	//product
	JPanel panelnorth=new JPanel();
	JPanel panelcenter=new JPanel();
	
	//itemnorth
	JLabel lblireporttype=new JLabel("Report Type:");
	JLabel lblitmrecipt=new JLabel("Item Recipt");
	JLabel lblitmreciptreturn=new JLabel("Item Recipt Return");
	JRadioButton rbtnitemrecipt=new JRadioButton();
	JRadioButton rbtnitemreciptreturn=new JRadioButton();
	
	//itemwest
	JCheckBox chkswise=new JCheckBox();
	JCheckBox chkpwise=new JCheckBox();
	JCheckBox chkdwise=new JCheckBox();
	JCheckBox chkinwise=new JCheckBox();
	JLabel lblswise=new JLabel("Supplier Wise");
	JLabel lblpwise=new JLabel("Product Wise");
	JLabel lbldwise=new JLabel("Date Wise");
	JLabel lblinwise=new JLabel("Invoice No-Wise");
	
	
	
	//itemcenter
	JLabel lblsupliername=new JLabel("Suplier Name");
	JLabel lblproductname=new JLabel("Product Name");
	JLabel lblfromdate=new JLabel("From Date");
	JLabel lbltodate=new JLabel("To Date");
	JLabel lblinvoiceno=new JLabel("Invoice No");
	JComboBox cmbsupliername=new JComboBox();
	JComboBox cmbproductname=new JComboBox();
	JComboBox cmbinvoiceno=new JComboBox();
	JDateChooser dtfromdate=new JDateChooser();
	JDateChooser dttodate=new JDateChooser();
	JCheckBox chksall=new JCheckBox();
	JCheckBox chkpall=new JCheckBox();
	JLabel lblsall=new JLabel("All");
	JLabel lblpall=new JLabel("All");
	
	
	
	//salesnorth
	JLabel lblsreporttype=new JLabel("Report Type:");
	JRadioButton rbtnsales=new JRadioButton();
	JRadioButton rbtnsalesreturn=new JRadioButton();
	JLabel lblsales=new JLabel("Sales");
	JLabel lblsalesreturn=new JLabel("Sales Return");
	
	
	//saleswest
	JCheckBox chkproductwise=new JCheckBox();
	JCheckBox chkdatewise=new JCheckBox();
	JCheckBox chksalesnowise=new JCheckBox();
	JLabel lblproductwise=new JLabel("Product Wise");
	JLabel lbldatewise=new JLabel("Date Wise");
	JLabel lblsalesnowise=new JLabel("Sales-No Wise");
	
	//salescenter
	JCheckBox chkpname=new JCheckBox();
	JLabel lblpnameall=new JLabel("All");
	JLabel lblpname=new JLabel("Product Name");
	JLabel lblfdate=new JLabel("From Date");
	JLabel lbltdate=new JLabel("To Date");
	JLabel lblinno=new JLabel("Invoice No");
	JComboBox cmbpname=new JComboBox();
	JComboBox cmbinno=new JComboBox();
	JDateChooser dtfdate=new JDateChooser();
	JDateChooser dttdate=new JDateChooser();
	
	
	//stocknorth
	JLabel lblstreporttype=new JLabel("Report Type:");
	JRadioButton rbtnstsummary=new JRadioButton();
	JRadioButton rbtnstdetail=new JRadioButton();
	JLabel lblstsummary=new JLabel("Stock Summary");
	JLabel lblstdetail=new JLabel("Stock Details");
	
	//stockwest
	JCheckBox chkcatagorywise=new JCheckBox();
	JCheckBox chkstdatewise=new JCheckBox();
	JLabel lblcatagorywise=new JLabel("Catagory Wise");
	JLabel lblstdatewise=new JLabel("Date Wise");
	
	
	//stockcenter
	JCheckBox chkcatagoryname=new JCheckBox();
	JCheckBox chksubcatname=new JCheckBox();
	JCheckBox chkproductname=new JCheckBox();
	JLabel lblcatagoryname=new JLabel("All");
	JLabel lblsubcatname=new JLabel("All");
	JLabel lblstproductname=new JLabel("All");
	JLabel lblstproname=new JLabel("Product Name");
	JLabel lblstcatname=new JLabel("Catgory Name");
	JLabel lblstsubcname=new JLabel("Sub-Catagory Name");
	JLabel lblstfdate=new JLabel("From Date");
	JLabel lblsttdate=new JLabel("To Date");
	JComboBox cmbcatname=new JComboBox();
	JComboBox cmbsubcat=new JComboBox();
	JComboBox cmbpro=new JComboBox();
	JDateChooser dtstfdate=new JDateChooser();
	JDateChooser dtstdate=new JDateChooser();
	
	//productnorth
	JLabel lblprreporttype=new JLabel("Report Type:");
	JRadioButton rbtnopstock=new JRadioButton();
	JRadioButton rbtnbroken=new JRadioButton();
	JLabel lblopstock=new JLabel("Opening Stock");
	JLabel lblbroken=new JLabel("Wastage/Broken");
	
	
	//productcenter
	JCheckBox chkprcataname=new JCheckBox();
	JCheckBox chkprsubcatname=new JCheckBox();
	JCheckBox chkprproductname=new JCheckBox();
	JLabel lblprcataname=new JLabel("All");
	JLabel lblprsubcatname=new JLabel("All");
	JLabel lblprproductname=new JLabel("All");
	JLabel lblprproname=new JLabel("Product Name");
	JLabel lblprcatname=new JLabel("Catgory Name");
	JLabel lblprsubcname=new JLabel("Sub-Catagory Name");
	JLabel lblprfdate=new JLabel("From Date");
	JLabel lblprtdate=new JLabel("To Date");
	JComboBox cmbprcatname=new JComboBox();
	JComboBox cmbprsubcat=new JComboBox();
	JComboBox cmbprproductname=new JComboBox();
	JDateChooser dtprfdate=new JDateChooser();
	JDateChooser dtprdate=new JDateChooser();
	
	
	
	
	
	JButton btnitem=new JButton("Preview",new ImageIcon("img/preview-file.png"));
	JButton btnsales=new JButton("Preview",new ImageIcon("img/preview-file.png"));
	JButton btnstock=new JButton("Preview",new ImageIcon("img/preview-file.png"));
	JButton btnproduct=new JButton("Preview",new ImageIcon("img/preview-file.png"));
	
	public TaskReport()
	{
		
		comp();
	}

	private void comp() 
	{
		setLayout(new FlowLayout());
		add(panelitem);
		add(panelsales);
		add(panelproduct);
		add(panelstock);
		panelitemwork();
		panelsaleswork();
		panelproductwork();
		panelstockwork();
	}

	private void panelstockwork() 
	{
		panelstock.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Stock Report");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 25));
		titel.setTitlePosition(TitledBorder.TOP);
		titel.setTitlePosition(TitledBorder.LEFT);
		panelstock.setBorder(titel);
		panelstock.setPreferredSize(new Dimension(560,360));
		panelstock.setLayout(new BorderLayout());
		panelstock.add(stpanelcenter,BorderLayout.CENTER);
		stpanelcenterwork();
		panelstock.add(stpanelwest,BorderLayout.WEST);
		stpanelnorthwork();
		panelstock.add(stpanelnorth,BorderLayout.NORTH);
		stpanelwestwork();
		
		
		
	}

	private void stpanelwestwork()
	{
		
		stpanelwest.setBackground(Color.LIGHT_GRAY);
		stpanelwest.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		stpanelwest.setPreferredSize(new Dimension(150,0));
		stpanelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		
		stpanelwest.add(chkcatagorywise,c);
		
		c.gridx=1;
		c.gridy=0;
		stpanelwest.add(lblcatagorywise,c);
		lblcatagorywise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=1;
		stpanelwest.add(chkstdatewise,c);
		
		c.gridx=1;
		c.gridy=1;
		stpanelwest.add(lblstdatewise,c);
		lblstdatewise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
			
		
	}

	private void stpanelnorthwork()
	{
		
		stpanelnorth.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		stpanelnorth.setPreferredSize(new Dimension(0,60));
		stpanelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		stpanelnorth.setLayout(flow);
		flow.setVgap(20);
		stpanelnorth.add(lblstreporttype);
		lblstreporttype.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		stpanelnorth.add(rbtnstsummary);
		stpanelnorth.add(lblstsummary);
		lblstsummary.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		stpanelnorth.add(rbtnstdetail);
		stpanelnorth.add(lblstdetail);
		lblstdetail.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
	}

	private void stpanelcenterwork()
	{
		stpanelcenter.setBackground(Color.LIGHT_GRAY);
		stpanelcenter.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		stpanelcenter.add(lblstcatname,c);
		lblstcatname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=0;
		stpanelcenter.add(cmbcatname,c);
		cmbcatname.setPreferredSize(new Dimension(200,30));
		
		c.gridx=2;
		c.gridy=0;
		stpanelcenter.add(chkcatagoryname,c);
		
		c.gridx=3;
		c.gridy=0;
		stpanelcenter.add(lblcatagoryname,c);
		lblcatagoryname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		
		c.gridx=0;
		c.gridy=1;
		stpanelcenter.add(lblstsubcname,c);
		lblstsubcname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=1;
		stpanelcenter.add(cmbsubcat,c);
		
		c.gridx=2;
		c.gridy=1;
		stpanelcenter.add(chksubcatname,c);
		
		c.gridx=3;
		c.gridy=1;
		stpanelcenter.add(lblsubcatname,c);
		lblsubcatname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=2;
		stpanelcenter.add(lblstproname,c);
		lblstproname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=2;
		stpanelcenter.add(cmbpro,c);
		
		c.gridx=2;
		c.gridy=2;
		stpanelcenter.add(chkproductname,c);
		
		c.gridx=3;
		c.gridy=2;
		stpanelcenter.add(lblstproductname,c);
		lblstproductname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	
		c.gridx=0;
		c.gridy=3;
		stpanelcenter.add(lblstfdate,c);
		lblstfdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=1;
		c.gridy=3;
		stpanelcenter.add(dtstfdate,c);
		dtstfdate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=0;
		c.gridy=4;
		stpanelcenter.add(lblsttdate,c);
		lblsttdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=4;
		stpanelcenter.add(dtstdate,c);
		dtstdate.setDateFormatString("dd/MM/yyyy");
		
		
		c.gridx=1;
		c.gridy=5;
		stpanelcenter.add(btnstock,c);
		btnstock.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		

		
	}

	private void panelproductwork() 
	{
		panelproduct.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Product Report");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 25));
		titel.setTitlePosition(TitledBorder.TOP);
		titel.setTitlePosition(TitledBorder.LEFT);
		panelproduct.setBorder(titel);
		panelproduct.setPreferredSize(new Dimension(560,360));
		panelproduct.setLayout(new BorderLayout());
		panelproduct.add(panelcenter,BorderLayout.CENTER);
		panelcenterwork();
		panelproduct.add(panelnorth,BorderLayout.NORTH);
		panelnorthwork();
		
		
	}

	private void panelnorthwork()
	{
		panelnorth.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelnorth.setPreferredSize(new Dimension(0,60));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelnorth.setLayout(flow);
		flow.setVgap(20);
		panelnorth.add(lblprreporttype);
		lblprreporttype.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		panelnorth.add(rbtnopstock);
		panelnorth.add(lblopstock);
		lblopstock.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelnorth.add(rbtnbroken);
		panelnorth.add(lblbroken);
		lblbroken.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}

	private void panelcenterwork() 
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);
		panelcenter.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		panelcenter.add(lblprcatname,c);
		lblprcatname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=0;
		panelcenter.add(cmbprcatname,c);
		cmbprcatname.setPreferredSize(new Dimension(200,30));
		
		c.gridx=2;
		c.gridy=0;
		panelcenter.add(chkprcataname,c);
		
		c.gridx=3;
		c.gridy=0;
		panelcenter.add(lblprcataname,c);
		lblprcataname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		
		c.gridx=0;
		c.gridy=1;
		panelcenter.add(lblprsubcname,c);
		lblprsubcname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=1;
		panelcenter.add(cmbprsubcat,c);
		
		c.gridx=2;
		c.gridy=1;
		panelcenter.add(chkprsubcatname,c);
		
		c.gridx=3;
		c.gridy=1;
		panelcenter.add(lblprsubcatname,c);
		lblprsubcatname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=2;
		panelcenter.add(lblprproname,c);
		lblprproname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=2;
		panelcenter.add(cmbprproductname,c);
		
		c.gridx=2;
		c.gridy=2;
		panelcenter.add(chkprproductname,c);
		
		c.gridx=3;
		c.gridy=2;
		panelcenter.add(lblprproductname,c);
		lblprproductname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	
		c.gridx=0;
		c.gridy=3;
		panelcenter.add(lblprfdate,c);
		lblprfdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=1;
		c.gridy=3;
		panelcenter.add(dtprfdate,c);
		dtprfdate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=0;
		c.gridy=4;
		panelcenter.add(lblprtdate,c);
		lblprtdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=4;
		panelcenter.add(dtprdate,c);
		dtprdate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=1;
		c.gridy=5;
		panelcenter.add(btnproduct,c);
		btnproduct.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
	}

	private void panelitemwork() 
	{
		panelitem.setBackground(Color.LIGHT_GRAY);
		panelitem.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Item Report");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 25));
		titel.setTitlePosition(TitledBorder.TOP);
		titel.setTitlePosition(TitledBorder.LEFT);
		panelitem.setBorder(titel);
		panelitem.setPreferredSize(new Dimension(560,355));
		panelitem.setLayout(new BorderLayout());
		panelitem.add(ipanelcenter,BorderLayout.CENTER);
		ipanelcenterwork();
		panelitem.add(ipanelwest,BorderLayout.WEST);
		ipanelnorthwork();
		panelitem.add(ipanelnorth,BorderLayout.NORTH);
		ipanelwestwork();
	}

	private void ipanelwestwork() 
	{
		ipanelwest.setBackground(Color.LIGHT_GRAY);
		ipanelwest.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		ipanelwest.setPreferredSize(new Dimension(150,0));
		ipanelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		ipanelwest.add(chkswise,c);
		
		c.gridx=1;
		c.gridy=0;
		ipanelwest.add(lblswise,c);
		lblswise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=1;
		ipanelwest.add(chkpwise,c);
		
		c.gridx=1;
		c.gridy=1;
		ipanelwest.add(lblpwise,c);
		lblpwise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=0;
		c.gridy=2;
		ipanelwest.add(chkdwise,c);
		
		c.gridx=1;
		c.gridy=2;
		ipanelwest.add(lbldwise,c);
		lbldwise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=0;
		c.gridy=3;
		ipanelwest.add(chkinwise,c);
		
		
		c.gridx=1;
		c.gridy=3;
		ipanelwest.add(lblinwise,c);
		lblinwise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}

	private void ipanelnorthwork()
	{
		ipanelnorth.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		ipanelnorth.setPreferredSize(new Dimension(0,60));
		ipanelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		ipanelnorth.setLayout(flow);
		flow.setVgap(20);
		ipanelnorth.add(lblireporttype);
		lblireporttype.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		ipanelnorth.add(rbtnitemrecipt);
		ipanelnorth.add(lblitmrecipt);
		lblitmrecipt.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		ipanelnorth.add(rbtnitemreciptreturn);
		ipanelnorth.add(lblitmreciptreturn);
		lblitmreciptreturn.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}

	private void ipanelcenterwork() 
	{
		ipanelcenter.setBackground(Color.LIGHT_GRAY);
		ipanelcenter.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		ipanelcenter.add(lblsupliername,c);
		lblsupliername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=0;
		ipanelcenter.add(cmbsupliername,c);
		cmbsupliername.setPreferredSize(new Dimension(200,30));
		
		c.gridx=2;
		c.gridy=0;
		ipanelcenter.add(chksall,c);
		
		c.gridx=3;
		c.gridy=0;
		ipanelcenter.add(lblsall,c);
		lblsall.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		
		c.gridx=0;
		c.gridy=1;
		ipanelcenter.add(lblproductname,c);
		lblproductname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=1;
		ipanelcenter.add(cmbproductname,c);
		
		c.gridx=2;
		c.gridy=1;
		ipanelcenter.add(chkpall,c);
		
		c.gridx=3;
		c.gridy=1;
		ipanelcenter.add(lblpall,c);
		lblpall.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=2;
		ipanelcenter.add(lblfromdate,c);
		lblfromdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=2;
		ipanelcenter.add(dtfromdate,c);
		dtfromdate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=0;
		c.gridy=3;
		ipanelcenter.add(lbltodate,c);
		lbltodate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=1;
		c.gridy=3;
		ipanelcenter.add(dttodate,c);
		dttodate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=0;
		c.gridy=4;
		ipanelcenter.add(lblinvoiceno,c);
		lblinvoiceno.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=1;
		c.gridy=4;
		ipanelcenter.add(cmbinvoiceno,c);
		
		
		
		
		c.gridx=1;
		c.gridy=5;
		ipanelcenter.add(btnitem,c);
		btnitem.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
	}

	private void panelsaleswork() 
	{
		
		panelsales.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Sales Report");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 25));
		titel.setTitlePosition(TitledBorder.TOP);
		titel.setTitlePosition(TitledBorder.LEFT);
		panelsales.setBorder(titel);
		panelsales.setPreferredSize(new Dimension(560,355));
		panelsales.setLayout(new BorderLayout());
		panelsales.add(spanelcenter,BorderLayout.CENTER);
		spanelcenterwork();
		panelsales.add(spanelwest,BorderLayout.WEST);
		spanelnorthwork();
		panelsales.add(spanelnorth,BorderLayout.NORTH);
		spanelwestwork();
		
	}

	private void spanelwestwork()
	{
		
		spanelwest.setBackground(Color.LIGHT_GRAY);
		spanelwest.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		spanelwest.setPreferredSize(new Dimension(150,0));
		spanelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		spanelwest.add(chkproductwise,c);
		
		c.gridx=1;
		c.gridy=0;
		spanelwest.add(lblproductwise,c);
		lblproductwise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
		c.gridx=0;
		c.gridy=1;
		spanelwest.add(chkdatewise,c);
		
		c.gridx=1;
		c.gridy=1;
		spanelwest.add(lbldatewise,c);
		lbldatewise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=0;
		c.gridy=2;
		spanelwest.add(chksalesnowise,c);
		
		c.gridx=1;
		c.gridy=2;
		spanelwest.add(lblsalesnowise,c);
		lblsalesnowise.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		
	}
	private void spanelnorthwork()
	{
	

		spanelnorth.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		spanelnorth.setPreferredSize(new Dimension(0,60));
		spanelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		spanelnorth.setLayout(flow);
		flow.setVgap(20);
		spanelnorth.add(lblsreporttype);
		lblsreporttype.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		spanelnorth.add(rbtnsales);
		spanelnorth.add(lblsales);
		lblsales.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		spanelnorth.add(rbtnsalesreturn);
		spanelnorth.add(lblsalesreturn);
		lblsalesreturn.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}

	private void spanelcenterwork()
	{
		spanelcenter.setBackground(Color.LIGHT_GRAY);
		spanelcenter.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0, 5, 5, 0);
		
		c.gridx=0;
		c.gridy=0;
		spanelcenter.add(lblpname,c);
		lblpname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=0;
		spanelcenter.add(cmbpname,c);
		cmbpname.setPreferredSize(new Dimension(200,30));
		
		c.gridx=2;
		c.gridy=0;
		spanelcenter.add(chkpname,c);
		
		c.gridx=3;
		c.gridy=0;
		spanelcenter.add(lblpnameall,c);
		lblpnameall.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=0;
		c.gridy=1;
		spanelcenter.add(lblfdate,c);
		lblfdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=1;
		spanelcenter.add(dtfdate,c);	
		dtfdate.setDateFormatString("dd/MM/yyyy");
		
		
		c.gridx=0;
		c.gridy=2;
		spanelcenter.add(lbltdate,c);
		lbltdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		c.gridx=1;
		c.gridy=2;
		spanelcenter.add(dttdate,c);
		dttdate.setDateFormatString("dd/MM/yyyy");
		
		c.gridx=0;
		c.gridy=3;
		spanelcenter.add(lblinno,c);
		lblinno.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
		c.gridx=1;
		c.gridy=3;
		spanelcenter.add(cmbinno,c);
		
		
		c.gridx=1;
		c.gridy=4;
		spanelcenter.add(btnsales,c);
		btnsales.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		
	}
}
