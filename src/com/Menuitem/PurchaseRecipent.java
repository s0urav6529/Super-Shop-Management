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
import java.awt.Insets;
import java.awt.LayoutManager;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class PurchaseRecipent extends JPanel
{
	JPanel panelnorth=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelsouth=new JPanel();
	JPanel panelsouthcenter=new JPanel();
	JPanel panelsouthnorth=new JPanel();
	JPanel panelcenterwest=new JPanel();
	JPanel panelcentercenter=new JPanel();
	JPanel panelcentercenternorth=new JPanel();
	JPanel panelcentercentercenter=new JPanel();
	JPanel panelcenterwestnorth=new JPanel();
	JPanel panelcenterwestcenter=new JPanel();
	
	JButton btnconfirm=new JButton("Confirm",new ImageIcon("img/confirm.png"));
	JButton btnrefreshall=new JButton("Refresh",new ImageIcon("img/donee.png"));
	JButton btnfind=new JButton("Find",new ImageIcon("img/find.png"));
	JButton btnsubmit=new JButton("Submit",new ImageIcon("img/submit.png"));
	JButton btnedit=new JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new JButton("Delete",new ImageIcon("img/delete.png"));
	
	JDateChooser currentdate=new JDateChooser();
	JDateChooser invoicedate=new JDateChooser();
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate=new JDateChooser();
	
	JLabel lbltotoalamount=new JLabel("Total Amount");
	JLabel lblinvoiceno=new JLabel("Invoice Number");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblcurrentdate=new JLabel("Current.Date");
	JLabel lblinvoicedate=new JLabel("Invoice Date");
	JLabel lblfromdate=new JLabel("FromDate");
	JLabel lbltodate=new JLabel("To Date");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Sub Catagory");
	JLabel lblproductid=new JLabel("Product");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstock=new JLabel("Stock qty");
	JLabel lbldealerrate=new JLabel("Dealer Rate");
	JLabel lblamount=new JLabel("Amount");
	JLabel lblinvoicequantity=new JLabel("Invoice Quantity");
	JLabel lblrecivequantity=new JLabel("Recive Quantity");
	JLabel lblshortoverquantity=new JLabel("Short/Over Quantity");
	JLabel lblpresentstock=new JLabel("Present Stock");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblremarks=new JLabel("Remarks");
	
	JTextField txtunit=new JTextField(20);
	JTextField txtamount=new JTextField(20);
	JTextField txtstock=new JTextField(20);
	JTextField txtdealerrate=new JTextField(20);
	JTextField txtinvoicequantity=new JTextField(20);
	JTextField txtrecivequantity=new JTextField(20);
	JTextField txtshortoverquantity=new JTextField(20);
	JTextField txtpresentstock=new JTextField(20);
	
	SuggestText cmbproductid=new SuggestText();
	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();
	JComboBox cmbsuppliername=new JComboBox();
	
	JTextField txttotalamount=new JTextField(20);
	JTextField txtinvoiceno=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextArea txtremarks=new JTextArea(2,2);
	JScrollPane scrollremarks=new JScrollPane(txtremarks,JScrollPane.
			VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	DecimalFormat dformet=new DecimalFormat("0.00");
	
	String colname[]={"Product Id","Product Name","Unit","Stock","Dealer Rate","Invoice Qtn","Receive Qtn",
			"Short/Over Qtn","Present Stock","Supplier Id","Supplier Name","Amount","Remarks"};
	Object rowname[][]={}; 
	DefaultTableModel modelinsert=new DefaultTableModel(rowname,colname);
	JTable tableinsert=new JTable(modelinsert);
	JScrollPane scrollinsert=new JScrollPane(tableinsert,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	String colname1[]={"Invoice No","Total Amount","Date"};
	Object rowname1[][]={}; 
	DefaultTableModel modelfind=new DefaultTableModel(rowname1,colname1);
	JTable tablefind=new JTable(modelfind);
	JScrollPane scrollfind=new JScrollPane(tablefind,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	Font font=new Font("serif", Font.BOLD+Font.ITALIC, 15);
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	
	boolean isupdate=false;
	
	SessionBean session;
	public PurchaseRecipent(SessionBean bean)
	{
		this.session=bean;
		panelwork();
		btnaction();
		keylistener();
		initial(true);
		initialamount();
		editfalse();
	}
	
	private boolean initial(boolean b)
	{
		btnsubmit.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;
	}
	
	private void initialamount()
	{
		txtamount.setText("0.00");
		txttotalamount.setText("0.00");
	}
	
	public void tbfinddataload()
	{
		try
		{
            int a;
			
			for(a=tablefind.getRowCount()-1;a>=0;a--)
			{
				modelfind.removeRow(a);
				
			}
			String sql="select invoiceno,totalamount,invoicedate from tbpurchaserecipentinfo";
			Dbconection.conect();
			ResultSet  rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				modelfind.addRow(new Object[]
						{
							rs.getString("invoiceno"),
							rs.getString("totalamount"),
							rs.getString("invoicedate")
						});
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void keylistener() 
	{
		txtstock.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				presentstockcalculation();
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		txtdealerrate.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				amountcalculation();	
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		txtinvoicequantity.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				shortoverqtycalculattion();
			}
			public void keyPressed(KeyEvent arg0) {}
		});
			
		txtrecivequantity.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				shortoverqtycalculattion();
				amountcalculation();
				presentstockcalculation();
				
			}
			public void keyPressed(KeyEvent arg0) {}
		});
	}

	private void presentstockcalculation()
	{
		double stock,rcvqty,prsentstock;
		stock=Double.parseDouble(txtstock.getText().trim().isEmpty()?"0":txtstock.getText().trim());
		rcvqty=Double.parseDouble(txtrecivequantity.getText().trim().isEmpty()?"0":txtrecivequantity.getText().trim());
		prsentstock=stock+rcvqty;
		txtpresentstock.setText(dformet.format(prsentstock));
	}
	
	private void amountcalculation()
	{
		double dealerrate,rcvqty,amount;
		dealerrate=Double.parseDouble(txtdealerrate.getText().trim().isEmpty()?"0":txtdealerrate.getText().trim());
		rcvqty=Double.parseDouble(txtrecivequantity.getText().trim().isEmpty()?"0":txtrecivequantity.getText().trim());
		amount=dealerrate*rcvqty;
		txtamount.setText(dformet.format(amount));
		
	}
	
	private void shortoverqtycalculattion()
	{
		double invoiceqty,rcvqty,shovrqty;
		invoiceqty=Double.parseDouble(txtinvoicequantity.getText().trim().isEmpty()?"0":txtinvoicequantity.getText().trim());
		rcvqty=Double.parseDouble(txtrecivequantity.getText().trim().isEmpty()?"0":txtrecivequantity.getText().trim());
		shovrqty=invoiceqty-rcvqty;
		txtshortoverquantity.setText(dformet.format(shovrqty));
	}
	
	private void totalamount()
	{
		double sum=0;
		for(int a=0;a<tableinsert.getRowCount();a++)
		{
			sum=sum+Double.parseDouble(tableinsert.getValueAt(a, 11).toString());
		}
		txttotalamount.setText(dformet.format(sum));
		
	}
	
	private void resettxt()
	{
		txtamount.setText("0.00");
		txtinvoicequantity.setText("");
		txtpresentstock.setText("");
		txtdealerrate.setText("");
		txtrecivequantity.setText("");
		txtremarks.setText("");
		txtshortoverquantity.setText("");
		txtstock.setText("");
		txtunit.setText("");
	}
	
	private void reset()
	{
		txtamount.setText("0.00");
		txtinvoicequantity.setText("");
		txtpresentstock.setText("");
		txtdealerrate.setText("");
		txtrecivequantity.setText("");
		txtremarks.setText("");
		txtshortoverquantity.setText("");
		txtstock.setText("");
		txtunit.setText("");
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsuppliername.removeAllItems();
		cmbsubcatagory.removeAllItems();
		initial(true);
		
	}
	private  boolean chkvalidation()
	{
		if(!cmbproductid.txtSuggest.getText().isEmpty()){
			if(!txtstock.getText().isEmpty()){
				if(!txtinvoicequantity.getText().isEmpty()){
					if(!txtrecivequantity.getText().isEmpty()){
						if(!txtshortoverquantity.getText().isEmpty()){
							if(!txtpresentstock.getText().isEmpty()){
								if(!txtdealerrate.getText().isEmpty()){
									if(!txtamount.getText().isEmpty())
									{
										return true;	
									}
									else
									{
										JOptionPane.showMessageDialog(null, "insert amount plz","Error",JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "insert dealer rate plz","Error",JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "insert present Stock plz","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "insert Short/Over qty plz","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "insert receive qty plz","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "insert invoice qty plz","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "insert stock plz","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "insert product plz","Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	private boolean doubleentry()
	{
		String proidname=cmbproductid.txtSuggest.getText();
		StringTokenizer protoken=new StringTokenizer(proidname,"#");
		String productid=protoken.nextToken();
		
		int a;
		for(a=0;a<modelinsert.getRowCount();a++)
		{
			String proid=modelinsert.getValueAt(a,0).toString();
			if(productid.equals(proid))
			{
				return true;
			}
		}
		return false;
	}
	
	private void tbinsertdataload()
	{
		String productidname=cmbproductid.txtSuggest.getText();
		StringTokenizer protoken=new StringTokenizer(productidname,"#");
		String productid=protoken.nextToken();
		String productname=protoken.nextToken();
		
		String supidname=cmbsuppliername.getSelectedItem().toString();
		StringTokenizer suptoken=new StringTokenizer(supidname,"#");
		String supid=suptoken.nextToken();
		String supname=suptoken.nextToken();
		
		modelinsert.addRow(new Object[]
				{
				productid,
				productname,
				txtunit.getText(),
				txtstock.getText(),
				txtdealerrate.getText(),
				txtinvoicequantity.getText(),
				txtrecivequantity.getText(),
				txtshortoverquantity.getText(),
				txtpresentstock.getText(),
				supid,
				supname,
				txtamount.getText(),
				txtremarks.getText()
				});
	}
	
	private void productwiseload(String productid)
	{	
		try
		{
			cmbcatagory.removeAllItems();
			cmbsubcatagory.removeAllItems();
			cmbsuppliername.removeAllItems();
			txtunit.setText("");
			
			Dbconection.conect();
			String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,supplierid,suppliername," +
					   "unit,dealerprice,(select totalstock('"+productid+"')) stock from tbproductinfo where ProductId ='"+productid+"' ";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				cmbsuppliername.addItem(rs.getString("supplierid")+"#"+rs.getString("suppliername"));
				txtunit.setText(rs.getString("unit"));
				txtdealerrate.setText(rs.getString("dealerprice"));
				txtstock.setText(rs.getString("stock"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error...",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public  void productdataload()
	{
		try
		{
			cmbproductid.v.clear();
			cmbproductid.v.add("");
			
			cmbcatagory.removeAllItems();
			cmbsubcatagory.removeAllItems();
			cmbsuppliername.removeAllItems();
			txtunit.setText("");
			txtdealerrate.setText("");
			txtstock.setText("");
			
			Dbconection.conect();
			String sql="select productid,productname from tbproductinfo order by productname";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbproductid.v.add(rs.getString("productid")+"#"+rs.getString("productname"));
			}
			
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private boolean insertdata()
	{
		try
		{
			String cdate=df.format(currentdate.getDate());
			String invdate=df.format(invoicedate.getDate());
			
			Dbconection.conect();
			Dbconection.con.setAutoCommit(false);
			
			
			String sqlinfo="insert into  tbpurchaserecipentinfo (invoiceno,invoicedate,currentdate," +
					       "totalamount,username,entrytime,userip) values('"+txtinvoiceno.getText().trim()+"'," +
					       "'"+invdate+"','"+cdate+"','"+txttotalamount.getText().trim()+"','"+txtusername.getText().trim()+"',now(),'')";
			Dbconection.sta.executeUpdate(sqlinfo);
			
			for(int a=0;a<tableinsert.getRowCount();a++)
			{
				String sqldetails="insert into tbpurchaserecipentdetails" +
								  " (invoiceno,productid,productname,unit,stock,dealerrate,invoiceqty,receiveqty," +
								  "shortoverqty,presentstock,amount,supplierid,suppliername,remark,entrytime,userip)" +
								  "values" +
						          " ('"+txtinvoiceno.getText().trim()+"'," +
						          "'"+modelinsert.getValueAt(a,0)+"'," +
						          "'"+modelinsert.getValueAt(a,1)+"'," +
						          "'"+modelinsert.getValueAt(a,2)+"'," +
								  "'"+modelinsert.getValueAt(a,3)+"'," +
								  "'"+modelinsert.getValueAt(a,4)+"'," +
								  "'"+modelinsert.getValueAt(a,5)+"'," +
								  "'"+modelinsert.getValueAt(a,6)+"'," +
								  "'"+modelinsert.getValueAt(a,7)+"'," +
								  "'"+modelinsert.getValueAt(a,8)+"'," +
								  "'"+modelinsert.getValueAt(a,11)+"'," +
								  "'"+modelinsert.getValueAt(a,9)+"'," +
								  "'"+modelinsert.getValueAt(a,10)+"'," +
								  "'"+modelinsert.getValueAt(a,12)+"'," +
								  "now(),'')";
				
				Dbconection.sta.executeUpdate(sqldetails);			
			}
			Dbconection.con.commit();
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			try
			{
				Dbconection.con.rollback();
				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
			JOptionPane.showMessageDialog(null, exp);
		}
		
		return false;
	}
	
	private void editfalse()
	{
		cmbcatagory.setEnabled(false);
		cmbsubcatagory.setEnabled(false);;
		cmbsuppliername.setEnabled(false);;
		txtunit.setEditable(false);
		txtstock.setEditable(false);
		txtshortoverquantity.setEditable(false);
		txtpresentstock.setEditable(false);
		txtamount.setEditable(false);
		txttotalamount.setEditable(false);
		txtusername.setEditable(false);
	}
	
	private boolean deletework()
	{
		try
		{
			String sqlinfo="delete  from tbpurchaserecipentinfo where invoiceno='"+txtinvoiceno.getText().trim()+"'";
			String sqldetails="delete  from tbpurchaserecipentdetails where invoiceno='"+txtinvoiceno.getText().trim()+"'";
			Dbconection.conect();
			Dbconection.sta.executeUpdate(sqlinfo);
			Dbconection.sta.executeUpdate(sqldetails);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	private void btnaction() 
	{
		btnsubmit.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkvalidation())
				{
					if(!doubleentry())
					{
						tbinsertdataload();
						totalamount();
						reset();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Same id already exists !");
					}
				}
			}
		});
		
		btnedit.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				isupdate=true;
				initial(true);	
			}
		});
		
		btnrefresh.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();			
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
						deletework();
						tbfinddataload();
						reset();
						JOptionPane.showMessageDialog(null, "All info deleted successfully !","info...",JOptionPane.INFORMATION_MESSAGE);
						invoiceautoid();
					}
				}		
			}
		});
		
		btnconfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkconfirm())
				{
					if(confirmation(isupdate?"Do you want to edit ?":"Do you want to save ?"))
					{
						if(isupdate)
						{
							if(deletework())
							{
								if(insertdata())
								{
									submittableclear();
									invoiceautoid();
									tbfinddataload();
									txttotalamount.setText("0.00");
									JOptionPane.showMessageDialog(null, "All info edited successfully !","Info..",JOptionPane.INFORMATION_MESSAGE);
								}
							}
							isupdate=false;
						}
						
						else
						{	
							if(insertdata())
							{
								submittableclear();
								invoiceautoid();
								tbfinddataload();
								txttotalamount.setText("0.00");
								JOptionPane.showMessageDialog(null, "All info Saved successfully !","Info..",JOptionPane.INFORMATION_MESSAGE);
							}	
						}
					}	
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "You have nothing to insert !","Error...",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnfind.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				findaction();
			}
		});
		
		btnrefreshall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				refreshallwork();
			}
		});
		
		cmbproductid.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				resettxt();				
				if(!cmbproductid.txtSuggest.getText().isEmpty())
				{
					String proidname=cmbproductid.txtSuggest.getText();
					StringTokenizer protoken=new StringTokenizer(proidname,"#");
					String id=protoken.nextToken();
					productwiseload(id);	
				}
				else
				{
					cmbcatagory.removeAllItems();
					cmbsubcatagory.removeAllItems();
					txtunit.setText("");
					txtstock.setText("");
					txtdealerrate.setText("");
				}
			}
		});
		
		tableinsert.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) 
			{
				 int a=tableinsert.getSelectedRow(); 
				 cmbproductid.txtSuggest.setText(modelinsert.getValueAt(a,0)+"#"+ modelinsert.getValueAt(a,1));
				 cmbproductid.cmbSuggest.setSelectedItem(modelinsert.getValueAt(a,0)+"#"+ modelinsert.getValueAt(a,1));
				 txtstock.setText(modelinsert.getValueAt(a,3).toString());
				 txtdealerrate.setText(modelinsert.getValueAt(a,4).toString());
				 txtinvoicequantity.setText(modelinsert.getValueAt(a,5).toString());
				 txtrecivequantity.setText(modelinsert.getValueAt(a,6).toString());
				 txtamount.setText(modelinsert.getValueAt(a,11).toString());
				 txtremarks.setText(modelinsert.getValueAt(a,12).toString());
				 cmbsuppliername.setSelectedItem(modelinsert.getValueAt(a, 9)+"#"+
				 modelinsert.getValueAt(a, 10));
				 amountcalculation();
				 presentstockcalculation();
				 shortoverqtycalculattion();
				 modelinsert.removeRow(a);
				 totalamount();
				 initial(false);
			}
		});
		
		tablefind.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				datasearch(modelfind.getValueAt(tablefind.getSelectedRow(),0).toString());
			}
		});
		
		tablefind.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				datasearch(modelfind.getValueAt(tablefind.getSelectedRow(),0).toString());
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
	}
	
	private void refreshallwork()
	{
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);	
		}
		reset();
		txtinvoiceno.setText("");
		txtusername.setText(session.getusername());
		currentdate.setDate(new Date());
		invoicedate.setDate(new Date());
		txttotalamount.setText("0.00");
		invoiceautoid();
		tbfinddataload();
	}
	
	private void datasearch(String invoiceid)
	{		
		try
		{
			int i;
			for(i=tableinsert.getRowCount()-1;i>=0;i--)
			{
				modelinsert.removeRow(i);
			}
			String sql="select a.invoiceno,a.invoicedate,a.currentdate,a.totalamount,a.username,b.productid,"+
					   "b.productname,b.unit,b.stock,b.dealerrate,b.invoiceqty,b.receiveqty,b.shortoverqty,b.amount," +
					   "b.presentstock,b.supplierid,b.suppliername,b.remark from tbpurchaserecipentinfo a "+
	                   "inner join tbpurchaserecipentdetails b on a.invoiceno=b.invoiceno " +
	                   "where a.invoiceno='"+invoiceid+"'";
			
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			int a=0;
			while(rs.next())
			{
				if(a==0)
				{
					txtinvoiceno.setText(rs.getString("invoiceno"));
					txttotalamount.setText(rs.getString("totalamount"));
					txtusername.setText(rs.getString("username"));
					currentdate.setDate(rs.getDate("currentdate"));
					invoicedate.setDate(rs.getDate("invoicedate"));
					
					a++;
				}
				modelinsert.addRow(new Object[]
				{
						rs.getString("productid"),
						rs.getString("productname"),
						rs.getString("unit"),
						rs.getString("stock"),
						rs.getString("dealerrate"),
						rs.getString("invoiceqty"),
						rs.getString("receiveqty"),
						rs.getString("shortoverqty"),
						rs.getString("presentstock"),
						rs.getString("supplierid"),
						rs.getString("suppliername"),
						rs.getString("amount"),
						rs.getString("remark")	
				});
			}
			Dbconection.con.close();	
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e,"hello",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void findaction()
	{
		try
		{
			int a;
			for(a=tablefind.getRowCount()-1;a>=0;a--)
			{
				modelfind.removeRow(a);	
			}
			String fromdte=df.format(fromdate.getDate());
			String todte=df.format(todate.getDate());
			
			String sql="select invoiceno,totalamount,invoicedate from tbpurchaserecipentinfo" +
					   " where invoicedate between '"+fromdte+"' and '"+todte+"' " +
					   "order by invoicedate";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				modelfind.addRow(new Object[]
						{
						  rs.getString("invoiceno"),
						  rs.getString("totalamount"),
						  rs.getString("invoicedate")
						});
				while(rs.next())
				{
					modelfind.addRow(new Object[]{
						rs.getString("invoiceno"),
						rs.getString("totalamount"),
						rs.getString("invoicedate")
					});
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No data found !","info...",JOptionPane.INFORMATION_MESSAGE);
				tbfinddataload();
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
    }
	
	private void submittableclear()
	{

		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);
			
		}
	}

	private boolean confirmation(String caption)
	{
		int a=JOptionPane.showConfirmDialog(null,caption,"confirm..",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
		
	}
	
	private boolean chkconfirm()
	{
		if(!txtinvoiceno.getText().trim().isEmpty() && tableinsert.getRowCount()>=1)
		{
			return true;
		}
		return false;
	}
	
	public  void invoiceautoid()
	{
		try{
			
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring(invoiceno,locate('-',invoiceno)+1,length(invoiceno)" +
					"-locate('-',invoiceno)) as UNSIGNED)),0)+1 id from tbpurchaserecipentinfo";
			
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			if(rs.next())
			{
				String id=rs.getString("id");
				txtinvoiceno.setText("Invoice-"+id);
			}
			
			Dbconection.con.close();
			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, "exp");
		}
	}

	private void panelwork() 
	{
		setLayout(new BorderLayout());
		add(panelcenter,BorderLayout.CENTER);
		panelcenterwork();
		add(panelnorth,BorderLayout.NORTH);
		panelnorthwork();
		add(panelsouth,BorderLayout.SOUTH);
		panelsouthwork();		
	}
	private void panelsouthwork() 
	{
		panelsouth.setBackground(Color.LIGHT_GRAY);
		panelsouth.setBackground(Color.LIGHT_GRAY);
		panelsouth.setLayout(new BorderLayout());
		panelsouth.setPreferredSize(new Dimension(1160,215));
		panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouth.add(panelsouthcenter,BorderLayout.CENTER);
		panelsouthcenterwork();
		panelsouth.add(panelsouthnorth,BorderLayout.NORTH);
		panelsouthnorthwork();	
	}
	private void panelsouthnorthwork() 
	{
		panelsouthnorth.setBackground(Color.LIGHT_GRAY);
		panelsouthnorth.setPreferredSize(new Dimension(1160,150));
		panelsouthnorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelsouthnorth.add(scrollinsert);
		scrollinsert.setPreferredSize(new Dimension(1140,135));
		tableinsert.getTableHeader().setResizingAllowed(false);
	}
	private void panelsouthcenterwork() 
	{
		panelsouthcenter.setBackground(Color.LIGHT_GRAY);
		panelsouthcenter.setBackground(Color.LIGHT_GRAY);
		panelsouthcenter.setLayout(new FlowLayout());
		panelsouthcenter.add(lbltotoalamount);
		lbltotoalamount.setFont(font);
		panelsouthcenter.add(txttotalamount);
		txttotalamount.setEditable(false);
		txttotalamount.setFont(font);
		txttotalamount.setForeground(Color.BLUE);
		panelsouthcenter.add(btnconfirm);
		panelsouthcenter.add(btnrefreshall);	
	}
	private void panelnorthwork()
	{
		panelnorth.setBackground(Color.LIGHT_GRAY);
		panelnorth.setBackground(Color.LIGHT_GRAY);
		panelnorth.setPreferredSize(new Dimension(1160,40));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelnorth.setLayout(flow);
		panelnorth.add(lblinvoiceno);
		lblinvoiceno.setFont(font);
		panelnorth.add(txtinvoiceno);
		txtinvoiceno.setEditable(false);
		txtinvoiceno.setForeground(Color.green);
		
		panelnorth.add(lblusername);
		lblusername.setFont(font);
		panelnorth.add(txtusername);
		txtusername.setEditable(false);
		txtusername.setText(session.getusername());
		
		panelnorth.add(lblcurrentdate);
		lblcurrentdate.setFont(font);
		panelnorth.add(currentdate);
		currentdate.setDateFormatString("dd-MM-yy");
		currentdate.setDate(new Date());
		
		panelnorth.add(lblinvoicedate);
		lblinvoicedate.setFont(font);
		panelnorth.add(invoicedate);
		invoicedate.setDateFormatString("dd-MM-yy");
		invoicedate.setDate(new Date());
		
		flow.setVgap(6);
	}
	private void panelcenterwork() 
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);
		panelcenter.setBackground(Color.LIGHT_GRAY);
		panelcenter.setLayout(new BorderLayout());
		panelcenter.add(panelcentercenter,BorderLayout.CENTER);
		panelcenter.add(panelcenterwest,BorderLayout.WEST);
		panelcenterwestwork();
		panelcentercenterwork();		
	}
	private void panelcentercenterwork()
	{
		panelcentercenter.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Existing Invoice");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		titel.setTitlePosition(TitledBorder.LEFT);
		panelcentercenter.setBorder(titel);
		panelcentercenter.setLayout(new BorderLayout());
		panelcentercenter.add(panelcentercentercenter, BorderLayout.CENTER);
		panelcentercentercenterwork();
		panelcentercenter.add(panelcentercenternorth, BorderLayout.NORTH);
		panelcentercenternorthwork();		
	}
	private void panelcentercenternorthwork() 
	{
		panelcentercenternorth.setBackground(Color.LIGHT_GRAY);
		panelcentercenternorth.setBackground(Color.LIGHT_GRAY);
		panelcentercenternorth.setPreferredSize(new Dimension(580,60));
		panelcentercenternorth.setLayout(new FlowLayout());
		panelcentercenternorth.add(lblfromdate);
		lblfromdate.setFont(font);
		panelcentercenternorth.add(fromdate);
		fromdate.setDateFormatString("dd-MM-yy");
		fromdate.setDate(new Date());
		panelcentercenternorth.add(lbltodate);
		lbltodate.setFont(font);
		panelcentercenternorth.add(todate);
		todate.setDate(new Date());
		todate.setDateFormatString("dd-MM-yy");
		panelcentercenternorth.add(btnfind);
		btnfind.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 13));
		
	}
	private void panelcentercentercenterwork()
	{
		panelcentercentercenter.setBackground(Color.LIGHT_GRAY);
		panelcentercentercenter.setBackground(Color.LIGHT_GRAY);
		panelcentercentercenter.add(scrollfind);
		scrollfind.setPreferredSize(new Dimension(550,370));
	}
	private void panelcenterwestwork() 
	{
		panelcenterwest.setBackground(Color.LIGHT_GRAY);
		panelcenterwest.setPreferredSize(new Dimension(580,400));
		panelcenterwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelcenterwest.setLayout(new BorderLayout());
		panelcenterwest.add(panelcenterwestnorth,BorderLayout.NORTH);
		panelcenterwestnorthwork();
		panelcenterwest.add(panelcenterwestcenter,BorderLayout.CENTER);
		panelcenterwestcenterwork();
	}
	private void panelcenterwestcenterwork() 
	{
		panelcenterwestcenter.setBackground(Color.LIGHT_GRAY);
		panelcenterwestcenter.setLayout(new FlowLayout());
		panelcenterwestcenter.add(btnsubmit);
		btnsubmit.setFont(font);
		panelcenterwestcenter.add(btnedit);
		btnedit.setFont(font);
		panelcenterwestcenter.add(btnrefresh);
		btnrefresh.setFont(font);
		panelcenterwestcenter.add(btndelete);
		btndelete.setFont(font);			
	}
	private void panelcenterwestnorthwork()
	{
		panelcenterwestnorth.setBackground(Color.LIGHT_GRAY);
		panelcenterwestnorth.setBackground(Color.LIGHT_GRAY);
		panelcenterwestnorth.setPreferredSize(new Dimension(580,460));
		
		panelcenterwestnorth.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
		
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(0, 5, 5, 0);
		
		con.gridx=0;
		con.gridy=0;
		panelcenterwestnorth.add(lblproductid,con);
		lblcatagory.setFont(font);
		
		con.gridx=1;
		con.gridy=0;
		panelcenterwestnorth.add(cmbproductid.cmbSuggest,con);
		cmbproductid.cmbSuggest.setPreferredSize(new Dimension(300,25));
		
		con.gridx=0;
		con.gridy=1;
		panelcenterwestnorth.add(lblcatagory,con);
		lblsubcatagory.setFont(font);
		
		con.gridx=1;
		con.gridy=1;
		panelcenterwestnorth.add(cmbcatagory,con);
				
		con.gridx=0;
		con.gridy=2;
		panelcenterwestnorth.add(lblsubcatagory,con);
		lblproductid.setFont(font);
		
		con.gridx=1;
		con.gridy=2;
		panelcenterwestnorth.add(cmbsubcatagory,con);
		
		con.gridx=0;
		con.gridy=3;
		panelcenterwestnorth.add(lblsuppliername,con);
		lblunit.setFont(font);
		
		con.gridx=1;
		con.gridy=3;
		panelcenterwestnorth.add(cmbsuppliername,con);

		con.gridx=0;
		con.gridy=4;
		panelcenterwestnorth.add(lblunit,con);
		lblstock.setFont(font);
		
		con.gridx=1;
		con.gridy=4;
		panelcenterwestnorth.add(txtunit,con);
		txtunit.setEditable(false);
		
		con.gridx=0;
		con.gridy=5;
		panelcenterwestnorth.add(lblstock,con);
		lbldealerrate.setFont(font);
		
		con.gridx=1;
		con.gridy=5;
		panelcenterwestnorth.add(txtstock,con);
		
		con.gridx=0;
		con.gridy=6;
		panelcenterwestnorth.add(lblinvoicequantity,con);
		lblinvoicequantity.setFont(font);
		
		con.gridx=1;
		con.gridy=6;
		panelcenterwestnorth.add(txtinvoicequantity,con);
		
		con.gridx=0;
		con.gridy=7;
		panelcenterwestnorth.add(lblrecivequantity,con);
		lblshortoverquantity.setFont(font);
		
		con.gridx=1;
		con.gridy=7;
		panelcenterwestnorth.add(txtrecivequantity,con);
		
		con.gridx=0;
		con.gridy=8;
		panelcenterwestnorth.add(lblshortoverquantity,con);
		lblpresentstock.setFont(font);
		
		con.gridx=1;
		con.gridy=8;
		panelcenterwestnorth.add(txtshortoverquantity,con);
		
		con.gridx=0;
		con.gridy=9;
		panelcenterwestnorth.add(lblpresentstock,con);
		lblsuppliername.setFont(font);
		
		con.gridx=1;
		con.gridy=9;
		panelcenterwestnorth.add(txtpresentstock,con);
		
		con.gridx=0;
		con.gridy=10;
		panelcenterwestnorth.add(lbldealerrate,con);
		lblrecivequantity.setFont(font);
		
		con.gridx=1;
		con.gridy=10;
		panelcenterwestnorth.add(txtdealerrate,con);
		
		con.gridx=0;
		con.gridy=11;
		panelcenterwestnorth.add(lblamount,con);
		lblamount.setFont(font);
		
		con.gridx=1;
		con.gridy=11;
		panelcenterwestnorth.add(txtamount,con);
		txtamount.setEditable(false);
		
		con.gridx=0;
		con.gridy=12;
		panelcenterwestnorth.add(lblremarks,con);
		lblremarks.setFont(font);
		
		con.gridx=1;
		con.gridy=12;
		panelcenterwestnorth.add(scrollremarks,con);
		
	}
}

