package com.Menuitem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import  javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;



public class Wastage extends JPanel
{
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelwestsouth=new JPanel();
	JPanel panelwestcenter=new JPanel();
	JPanel panelwestnorth=new JPanel();
		
	JLabel lblsearch=new JLabel("Search:  ");
	JLabel photoofsearch=new JLabel(new ImageIcon("img/search.png"));
	JLabel lblwastageno=new JLabel("Wastege No");
	JLabel lblproducttype=new JLabel("Product Type");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Sub Catogory");
	JLabel lblproduct=new JLabel("Product");
	JLabel lblunit=new JLabel("Unit");
	JLabel lbltotalstock=new JLabel("Total Stock");
	JLabel lbldate=new JLabel("Wastege/Broken Date");
	JLabel lblwastageqtn=new JLabel("Wastege/Broken Quantity");
	JLabel lblrate=new JLabel("Rate");
	JLabel lblamount=new JLabel("Amount");
	JLabel lblremarks=new JLabel("Remarks");
	JLabel lblusername=new JLabel("User Name");
	
	JButton btnadd=new  JButton("Add",new ImageIcon("img/add.png"));
	JButton btnedit=new  JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new  JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new  JButton("Delete",new ImageIcon("img/delete.png"));
	
	SuggestText cmbsearch=new SuggestText();
	String s[]={"","Wastege","Broken"};
	JComboBox cmbproducttype=new JComboBox(s);
	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();
	SuggestText cmbproduct=new SuggestText();
		
	JTextArea txtremarks=new JTextArea(4,2);
	JTextField txtwestageno=new JTextField(20);
	JTextField txttotalstock=new JTextField(20);
	JTextField txtwestageqtn=new JTextField(20);
	JTextField txtrate=new JTextField(20);
	JTextField txtamount=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txtunit=new JTextField(20);
	
	JDateChooser date=new JDateChooser();
	DecimalFormat dformet=new DecimalFormat("#0.00");
	JScrollPane sc=new JScrollPane(txtremarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	String colname[]={"Wastege No","Product Name","Wastege Quentity", "Date"};
	Object rowname[][]={};
	DefaultTableModel model=new DefaultTableModel(rowname,colname);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	boolean isupdate=false;
	
	SessionBean session;
	public Wastage(SessionBean bean)
	{
		this.session=bean;
		panelwork();
		btnaction();
		productdataload();
		keyaction();
		mousekeyevent();
		openwastageinitial(true);
		txtamount.setText("0.00");
		editfalse();
	}
	
	private void editfalse() 
	{
		cmbcatagory.setEnabled(false);
		cmbsubcatagory.setEnabled(false);
		txtunit.setEditable(false);
		txtamount.setEditable(false);
		txtusername.setEditable(false);
		txtwestageno.setEditable(false);	
	}

	private void mousekeyevent()
	{
		table.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0){}
			public void mouseClicked(MouseEvent arg0) 
			{
				datasearch(model.getValueAt(table.getSelectedRow(),0).toString());
				
			}
		});
		
		table.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0){}
			public void keyReleased(KeyEvent arg0) 
			{
				datasearch(model.getValueAt(table.getSelectedRow(), 0).toString());
			}
			public void keyPressed(KeyEvent arg0) {}
			
		});
		cmbsearch.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!cmbsearch.txtSuggest.getText().isEmpty())
				{
					String idname=cmbsearch.txtSuggest.getText();
					StringTokenizer token=new StringTokenizer(idname,"#");
					datasearch(token.nextToken());
				}
			}
			
		});
	}
	
	private void datasearch(String id)
	{
		try
		{
			String sql="select wastageno,productype,productid,productname,catagoryid,catgoryname,subcatagoryid,subcatagoryname,unit,totalstock,watagedate,watageqty," +
					"rate,amount,remarks,user from tbwastageinfo where wastageno like '"+id+"'";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				txtwestageno.setText(rs.getString("wastageno"));
				txtwestageqtn.setText(rs.getString("watageqty"));
				txtrate.setText(rs.getString("rate"));
				txtamount.setText(rs.getString("amount"));
				txttotalstock.setText(rs.getString("totalstock"));
				date.setDate(rs.getDate("watagedate"));
				txtremarks.setText(rs.getString("remarks"));
				txtusername.setText(rs.getString("user"));
				cmbproduct.txtSuggest.setText(rs.getString("productid")+"#"+rs.getString("productname"));
				cmbproduct.cmbSuggest.setSelectedItem(rs.getString("productid")+"#"+rs.getString("productname"));
				cmbproducttype.setSelectedItem(rs.getString("productype"));
				
				
			}
			Dbconection.con.close();
			openwastageinitial(false);
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error..",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean openwastageinitial(boolean b)
	{
		btnadd.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;
		
	}
	
	private boolean chkvalidation()
	{
		if(!txtwestageno.getText().isEmpty()){
			if(cmbproducttype.getSelectedIndex()!=0 && cmbproducttype.getSelectedItem()!=null){
				if(!cmbproduct.txtSuggest.getText().isEmpty()){
					if(!txttotalstock.getText().isEmpty()){
						if(!txtwestageqtn.getText().isEmpty()){
							if(!txtrate.getText().isEmpty()){
								if(!txtamount.getText().isEmpty()){
									if(!txtremarks.getText().isEmpty()){
										if(!txtusername.getText().isEmpty()){
											
											return true;
										}
										else
										{
											JOptionPane.showMessageDialog(null, "insert username  plz !","Info",JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "insert remarks  plz !","Info",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "insert amount plz !","Info",JOptionPane.INFORMATION_MESSAGE);
								}	
							}
							else
							{
								JOptionPane.showMessageDialog(null, "insert rate plz !","Info",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "insert wastage qty plz !","Info",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "insert total stock plz !","Info",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "insert product plz !","Info",JOptionPane.INFORMATION_MESSAGE);
				}	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "insert product type plz !","Info",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
			{
				JOptionPane.showMessageDialog(null, "insert wastageno plz !","Info",JOptionPane.INFORMATION_MESSAGE);
			}
		return false;
	}
	
	private boolean confirmation(String caption)
	{
		int a=JOptionPane.showConfirmDialog(null,caption,"Confirm",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		
		return false;
	}
	
	private boolean deletedata()
	{
		try
		{
			Dbconection.conect();
			String sql="delete from tbwastageinfo where wastageno='"+txtwestageno.getText().trim()+"'";
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp, "Error....",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	private boolean insertdata()
	{	
		String proidname=cmbproduct.txtSuggest.getText();
		StringTokenizer protoken=new StringTokenizer(proidname,"#");
		String proid=protoken.nextToken();
		String proname=protoken.nextToken();
		
		String catidname=cmbcatagory.getSelectedItem().toString();
		StringTokenizer cattoken=new StringTokenizer(catidname,"#");
		String catid=cattoken.nextToken();
		String catname=cattoken.nextToken();
		
		String subcatidname=cmbsubcatagory.getSelectedItem().toString();
		StringTokenizer subcattoken=new StringTokenizer(subcatidname,"#");
		String subcatid=subcattoken.nextToken();
		String subcatname=subcattoken.nextToken();
		
		String wastagedate=new SimpleDateFormat("yyyy-MM-dd").format(date.getDate());
		
		String sql="insert into tbwastageinfo(wastageno,productype,productid,productname,catagoryid,catgoryname,subcatagoryid,subcatagoryname,unit,totalstock,watagedate,watageqty,rate,amount,remarks,user,entrytime,userip) values"+
                         " ('"+txtwestageno.getText().trim()+"','"+cmbproducttype.getSelectedItem()+"','"+proid+"','"+proname+"','"+catid+"','"+catname+"','"+subcatid+"','"+subcatname+"','"+txtunit.getText().trim()+"','"+txttotalstock.getText().trim()+"','"+wastagedate+"'," +
                         		"'"+txtwestageqtn.getText().trim()+"','"+txtrate.getText().trim()+"','"+txtamount.getText().trim()+"','"+txtremarks.getText().trim()+"','"+txtusername.getText().trim()+"',now(),'')";
		Dbconection.conect();
		
		try
		{
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
			
			
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	private void amountcalculation()
	{
		double qty,rate,amount;
		
		qty=Double.parseDouble(txtwestageqtn.getText().trim().isEmpty()?"0":txtwestageqtn.getText().trim());
		rate=Double.parseDouble(txtrate.getText().trim().isEmpty()?"0":txtrate.getText().trim());
		amount=qty*rate;
		txtamount.setText(dformet.format(amount));
	}
	
	private void keyaction()
	{
		txtwestageqtn.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				amountcalculation();
			}
			public void keyPressed(KeyEvent arg0) {}
		} );
		
		txtrate.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				amountcalculation();
			}
			public void keyPressed(KeyEvent arg0) {}
		} );
		
		
	}
	
	public void tbdataload()
	{
		
		String sql="select wastageno,watagedate,productname,watageqty from tbwastageinfo";
		Dbconection.conect();

		try
		{
			int a;
			for(a=table.getRowCount()-1;a>=0;a--)
			{
				model.removeRow(a);
				
			}
			
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				model.addRow(new Object[]
						{
							rs.getString("wastageno"),
							rs.getString("productname"),
							rs.getString("watageqty"),
							rs.getString("watagedate")
							
						});
				
			}
			
			Dbconection.con.close();
			
			
			
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	private void productwiseload(String id)
	{
		
		try
		{

			cmbcatagory.removeAllItems();
			cmbsubcatagory.removeAllItems();
			txtunit.setText("");
			
			Dbconection.conect();
			String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,supplierid,suppliername,unit from tbproductinfo  where productid like '"+id+"'";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				txtunit.setText(rs.getString("unit"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error...",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void productdataload()
	{
		
		
		try
		{
			cmbproduct.v.clear();
			cmbproduct.v.add("");
			
			
			Dbconection.conect();
			String sql="select productid,productname from tbproductinfo order by productname";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbproduct.v.add(rs.getString("productid")+"#"+rs.getString("productname"));
			}
			
			Dbconection.con.close();
			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void reset()
	{
		txtwestageno.setText("");
		txtwestageqtn.setText("");
		txtamount.setText("0.00");
		txtrate.setText("");
		txtremarks.setText("");
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txttotalstock.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		cmbproduct.txtSuggest.setText("");
		cmbproducttype.setSelectedIndex(0);
		cmbsearch.txtSuggest.setText("");
		
	}
	public void cmbsearch()
	{
		try
		{
		
			cmbsearch.v.clear();
			cmbsearch.v.add("");
		
			Dbconection.conect();
			String sql="select wastageno,productype from tbwastageinfo";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
		
			while(rs.next())
			{
				cmbsearch.v.add(rs.getString("wastageno")+"#"+rs.getString("productype"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void btnaction()
	{
		
		btnadd.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkvalidation())
				{
					if(confirmation(isupdate?"Do you want to edit ?":"Do you want to save ?"))
					{
						if(isupdate)
						{
							if(deletedata())
							{
								if(insertdata())
								{
									tbdataload();
									reset();
									JOptionPane.showMessageDialog(null, "All info edit successfully !","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
									cmbsearch();
									westageautoid();
									
								}
							}	
						}
						else
						{
							if(insertdata())
							{
								tbdataload();
								reset();
								JOptionPane.showMessageDialog(null, "All info  save successfully !","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
								cmbsearch();
								westageautoid();
							}
						}
					}
					
					
				}	
			}
		});
		
		btnedit.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				openwastageinitial(true);
				isupdate=true;
				
				
			}
		});
		
		btnrefresh.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
				openwastageinitial(true);
				westageautoid();	
			}
		});
		
		btndelete.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkvalidation())
				{
					if(confirmation("Do you want to delete ?"))
					{
						if(deletedata())
							{
									tbdataload();
									reset();
									JOptionPane.showMessageDialog(null, "All info deleted successfully !","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
									cmbsearch();
									westageautoid();
									
								}
							}	
						}	
					}
				
				
		});	
		cmbproduct.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!cmbproduct.txtSuggest.getText().isEmpty())
				{
					String idname=cmbproduct.txtSuggest.getText();
					StringTokenizer token=new StringTokenizer(idname,"#");
					String id=token.nextToken();
					productwiseload(id);
					
				}
			}
		});
		
	}

	public void westageautoid()
	{
		try
		{
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring" +
				"(wastageno,locate('-',wastageno)+1,length(wastageno)-locate('-',wastageno)) " +
				"as UNSIGNED)),0)+1 id from tbwastageinfo ";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				String id=rs.getString("id");
				txtwestageno.setText("Waste-"+id);
			}
		}
		
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error..",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	private void panelwork() 
	{
		
		setLayout(new BorderLayout());
		
		add(panelcenter,BorderLayout.CENTER);
		panelcenterwork();
		
		add(panelwest,BorderLayout.WEST);
		panelwestwork();
		
	}
	private void panelcenterwork()
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);

		FlowLayout flow=new FlowLayout();
		panelcenter.setLayout(flow);
		panelcenter.add(scroll);
		scroll.setPreferredSize(new Dimension(550,700));
		
		
	}
	private void panelwestwork() 
	{
		panelwest.setBackground(Color.LIGHT_GRAY);
		panelwest.setLayout(new BorderLayout());
		panelwest.setPreferredSize(new Dimension(580,740));
		panelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwest.add(panelwestnorth, BorderLayout.NORTH);
		panelwestnorthwork();
		panelwest.add(panelwestcenter, BorderLayout.CENTER);
		panelwestcenterwork();
		panelwest.add(panelwestsouth, BorderLayout.SOUTH);
		panelwestsouthwork();
	}
	private void panelwestsouthwork() 
	{
		panelwestsouth.setBackground(Color.LIGHT_GRAY);
		panelwestsouth.setPreferredSize(new Dimension(580,80));
		panelwestsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		

		panelwestsouth.setLayout(new FlowLayout());
		panelwestsouth.add(btnadd);
		btnadd.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestsouth.add(btnedit);
		btnedit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestsouth.add(btnrefresh);
		btnrefresh.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestsouth.add(btndelete);
		btndelete.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}
	private void panelwestcenterwork()
	{
		panelwestcenter.setBackground(Color.LIGHT_GRAY);
		panelwestcenter.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
		
		
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelwestcenter.add(lblwastageno,con);
		lblwastageno.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=0;
		panelwestcenter.add(txtwestageno,con);
		txtwestageno.setEditable(false);
		
		con.gridx=0;
		con.gridy=1;
		panelwestcenter.add(lblproducttype,con);
		lblproducttype.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=1;
		panelwestcenter.add(cmbproducttype,con);
		
		con.gridx=0;
		con.gridy=2;
		panelwestcenter.add(lblproduct,con);
		lblcatagory.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=2;
		panelwestcenter.add(cmbproduct.cmbSuggest,con);
		
		
		con.gridx=0;
		con.gridy=3;
		panelwestcenter.add(lblcatagory,con);
		lblsubcatagory.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=3;
		panelwestcenter.add(cmbcatagory,con);
		
		
		con.gridx=0;
		con.gridy=4;
		panelwestcenter.add(lblsubcatagory,con);
		lblproduct.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=4;
		panelwestcenter.add(cmbsubcatagory,con);
		
		con.gridx=0;
		con.gridy=5;
		panelwestcenter.add(lblunit,con);
		lblunit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=5;
		panelwestcenter.add(txtunit,con);
		
		con.gridx=0;
		con.gridy=6;
		panelwestcenter.add(lbltotalstock,con);
		lbltotalstock.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=6;
		panelwestcenter.add(txttotalstock,con);
		
		con.gridx=0;
		con.gridy=7;
		panelwestcenter.add(lbldate,con);
		lbldate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=7;
		panelwestcenter.add(date,con);
		date.setDate(new Date());
		date.setDateFormatString("dd-MM-yyyy");
		
		con.gridx=0;
		con.gridy=8;
		panelwestcenter.add(lblwastageqtn,con);
		lblwastageqtn.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=8;
		panelwestcenter.add(txtwestageqtn,con);
		con.gridx=0;
		con.gridy=9;
		panelwestcenter.add(lblrate,con);
		lblrate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=9;
		panelwestcenter.add(txtrate,con);
		
		con.gridx=0;
		con.gridy=10;
		panelwestcenter.add(lblamount,con);
		lblamount.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=10;
		panelwestcenter.add(txtamount,con);
		
		con.gridx=0;
		con.gridy=11;
		panelwestcenter.add(lblremarks,con);
		lblremarks.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=11;
		panelwestcenter.add(sc,con);
		
		
		con.gridx=0;
		con.gridy=12;
		panelwestcenter.add(lblusername,con);
		lblusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=12;
		panelwestcenter.add(txtusername,con);
		txtusername.setText(session.getusername());
		
	
		
	}
	private void panelwestnorthwork()
	{
		panelwestnorth.setBackground(Color.LIGHT_GRAY);
		panelwestnorth.setPreferredSize(new Dimension(580,100));
		panelwestnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelwestnorth.setLayout(flow);
		flow.setVgap(30);
		panelwestnorth.add(lblsearch);
		lblsearch.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		panelwestnorth.add(photoofsearch);
		panelwestnorth.add(cmbsearch.cmbSuggest);
		cmbsearch.cmbSuggest.setPreferredSize(new Dimension(300,30));
		
	}

}
