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
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class ReturnToSupplier extends JPanel{
	
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
	
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel ("Sub Catagory");
	JLabel lblproductid=new JLabel ("Product Id");
	JLabel lblsuppliername=new JLabel ("Supplier Name");
	JLabel lblstockqty=new JLabel ("Stock Qty");
	JLabel lblreturnquantity=new JLabel ("Return Qty");
	JLabel lbldealerprice=new JLabel("Dealer Price");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblamount=new JLabel("Amount");
	JLabel lblremark=new JLabel("Remark");
	JLabel lblfromdate=new JLabel("FromDate");
	JLabel lbltodate=new JLabel("To Date");
	JLabel lblreturnno=new JLabel("Return No");
	JLabel lblusername=new JLabel("User Name");
	JLabel lbldate=new JLabel("Date");
	JLabel lblreturndate=new JLabel("Return Date");
	JLabel lbltotoalamount=new JLabel("Total Amount");
	
	JTextField txtreturnquentity=new JTextField(20);
	JTextField txtstockqty=new JTextField(20);
	JTextField txtunit=new JTextField(20);
	JTextField txtdealerprice=new JTextField(20);
	JTextField txtamount=new JTextField(20);
	JTextField txttotalstack=new JTextField(20);
	JTextField txtreturnno=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txttotalamount=new JTextField(20);
	
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate=new JDateChooser();
	JDateChooser date=new JDateChooser();
	JDateChooser returndate=new JDateChooser();
	
	JButton btnsubmit=new JButton("Submit",new ImageIcon("img/submit.png"));
	JButton btnedit=new JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new JButton("Delete",new ImageIcon("img/delete.png"));
	JButton btnfind=new JButton("Find",new ImageIcon("img/find.png"));
	JButton btnconfirm=new JButton("Confirm",new ImageIcon("img/confirm.png"));
	JButton btnrefreshall=new JButton("Refresh",new ImageIcon("img/donee.png"));

	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();
	SuggestText cmbproductid=new SuggestText();
	JComboBox cmbsuppliername=new JComboBox();
	
	JTextArea txtremarks=new JTextArea(4,2);
	JScrollPane scrollremarks=new JScrollPane(txtremarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
	String colname[]={"Product id","Product Name","Supplier Id","Supplier Name","Stock Qty","Dealer Price","Return qty","Unit","Amount","Remark"};
	Object rowname[][]={}; 
	DefaultTableModel modelinsert=new DefaultTableModel(rowname,colname);
	JTable tableinsert=new JTable(modelinsert);
	JScrollPane scrollinsert=new JScrollPane(tableinsert,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String colname1[]={"Return No","Total Amount","Date"};
	Object rowname1[][]={}; 
	DefaultTableModel modelfind=new DefaultTableModel(rowname1,colname1);
	JTable tablefind=new JTable(modelfind);
	JScrollPane scrollfind=new JScrollPane(tablefind,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	Font font=new Font("serif",Font.BOLD+Font.ITALIC,15);
	DecimalFormat dformet=new DecimalFormat("#0.00");
	SimpleDateFormat  dateformet=new SimpleDateFormat("yyyy-MM-dd");
	boolean findupdate=false;
	SessionBean session;
	public ReturnToSupplier(SessionBean bean)
	{
		this.session=bean;
		panelwork();
		btnaction();
		keyaction();
		initialamount();
		initial(true);
		editfalse();
	}
	
	private void editfalse()
	{
		cmbcatagory.setEnabled(false);
		cmbsubcatagory.setEnabled(false);
		cmbsuppliername.setEnabled(false);
		txtunit.setEditable(false);
		txtstockqty.setEditable(false);
		txtdealerprice.setEditable(false);
		txtamount.setEditable(false);
		txttotalamount.setEditable(false);
		txtusername.setEditable(false);
		txtreturnno.setEditable(false);		
	}
	
	private void amountcal()
	{
		double returnqty,dealerprice,amount;
		returnqty=Double.parseDouble(txtreturnquentity.getText().trim().isEmpty()?"0.00":txtreturnquentity.getText().trim());
		dealerprice=Double.parseDouble(txtdealerprice.getText().trim().isEmpty()?"0.00":txtdealerprice.getText().trim());
		amount=returnqty*dealerprice;
		txtamount.setText(dformet.format(amount));		
	}
	
	private void initialamount()
	{
		txtamount.setText("0.00");
		txttotalamount.setText("0.00");
	}
	
	private boolean initial(boolean b)
	{
		btnsubmit.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;	
	}
	
	public void productdataload()
	{
		cmbproductid.v.clear();
		cmbproductid.v.add("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		cmbsuppliername.removeAllItems();
		txtunit.setText("");
		txtstockqty.setText("");
		txtdealerprice.setText("");

		String sql="select ProductId,productname from tbproductinfo order by productname";
		Dbconection.conect();
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbproductid.v.add(rs.getString("ProductId")+"#"+rs.getString("productname"));
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
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
						submittbload();
						totalamountsum();
						reset();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Same Id already exist !","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnedit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				initial(true);
				findupdate=true;
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
						refreshallwork();
						JOptionPane.showMessageDialog(null, "All info deleted successfully  ! ");
						findtbdataload();
					}
				}
			}
		});
		
		btnconfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(confirmchk())
				{
					if(confirmation(findupdate?"Do you want to edit":"Do you want to save"))
					{
						if(findupdate)
						{
							if(deletework())
							{
								if(insertdata())
								{
									inserttbclear();
									returnautoid();
									findtbdataload();
									JOptionPane.showMessageDialog(null, "All info Edited Successfully","info",JOptionPane.INFORMATION_MESSAGE);
									refreshallwork();
								}
							}
							findupdate=false;
						}
						else
						{
							if(insertdata())
							{
								inserttbclear();
								returnautoid();
								findtbdataload();
								JOptionPane.showMessageDialog(null, "All info Edited Successfully","info",JOptionPane.INFORMATION_MESSAGE);
								refreshallwork();
							}
						}
					}
				}
			}
		});
		
		btnrefreshall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				refreshallwork();
			}
		});
		
		btnfind.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				findaction();
			}
		});
		
		cmbproductid.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!cmbproductid.txtSuggest.getText().trim().isEmpty())
				{
					String productidname=cmbproductid.txtSuggest.getText();
					StringTokenizer protoken=new StringTokenizer(productidname,"#");
					String productid=protoken.nextToken();
					 productwisedataload(productid);	
				}
				else
				{
					cmbcatagory.removeAllItems();
					cmbsubcatagory.removeAllItems();
					cmbsuppliername.removeAllItems();
					txtunit.setText("");
					txtstockqty.setText("");
					txtdealerprice.setText("");
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
				cmbproductid.txtSuggest.setText(modelinsert.getValueAt(a, 0)+"#"+modelinsert.getValueAt(a, 1));
				cmbproductid.cmbSuggest.setSelectedItem(modelinsert.getValueAt(a, 0)+"#"+ modelinsert.getValueAt(a, 1));
				txtreturnquentity.setText(modelinsert.getValueAt(a,6).toString());
				amountcal();
				modelinsert.removeRow(a);
				totalamountsum();
				initial(false);
			}
		});
	}
	
	private boolean insertdata()
	{
		try
		{
			String curdate=dateformet.format(date.getDate());
			String Rdate=dateformet.format(returndate.getDate());
			
			Dbconection.conect();
			Dbconection.con.setAutoCommit(false);
			String sqlinfo="insert into tbretrurntosupplierinfo (returnno,currentdate," +
					       "returndate,totalamount,entreytime,Userip)"+
                           "values ('"+txtreturnno.getText().trim()+"','"+curdate+"','"+Rdate+"'," +
                           "'"+txttotalamount.getText().trim()+"',now(),'')";
			Dbconection.sta.executeUpdate(sqlinfo);
			
			for(int a=0;a<tableinsert.getRowCount();a++)		
			{
				String sqldetails="insert into tbretrurntosupplierdetails (returnno,productid,productname,supplierid,suppliername," +
						          "stockqty,dealerprice,returnqty,unit,amount,remark,entrytime,userip)"+
                                  "values(" +
                                  "'"+txtreturnno.getText().trim()+"'," +
                                  "'"+modelinsert.getValueAt(a, 0)+"'," +
                                  "'"+modelinsert.getValueAt(a, 1)+"'," +
                                  "'"+modelinsert.getValueAt(a, 2)+"'," +
                                  "'"+modelinsert.getValueAt(a, 3)+"'," +
                                  "'"+modelinsert.getValueAt(a, 4)+"'," +
                                  "'"+modelinsert.getValueAt(a, 5)+"'," +
                                  "'"+modelinsert.getValueAt(a, 6)+"'," +
                                  "'"+modelinsert.getValueAt(a, 7)+"'," +
                                  "'"+modelinsert.getValueAt(a, 8)+"'," +
                                  "'"+modelinsert.getValueAt(a, 9)+"'," +
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
			JOptionPane.showMessageDialog(null, exp,"hello",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	private void inserttbclear()
	{
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);	
		}
	}
	
	private boolean doubleentry()
	{
		String idname=cmbproductid.txtSuggest.getText();
		StringTokenizer token=new StringTokenizer(idname,"#");
		String pid=token.nextToken();
		int a;
		for(a=0;a<modelinsert.getRowCount();a++)
		{
			String productid=modelinsert.getValueAt(a, 0).toString();
			if(productid.equals(pid))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean confirmchk()
	{
		if(!txtreturnno.getText().trim().isEmpty() && tableinsert.getRowCount()>=1)
		{
			return true;
		}
		return true;
	}
	
	private boolean chkvalidation()
	{
		if(!cmbproductid.txtSuggest.getText().isEmpty()){
			if(!txtstockqty.getText().trim().isEmpty()){
				if(!txtreturnquentity.getText().trim().isEmpty()){
					if(!txtdealerprice.getText().trim().isEmpty()){
						if(!txtunit.getText().trim().isEmpty()){
							if(!txtamount.getText().trim().isEmpty()){
								return true;
							}
							else
							{
							JOptionPane.showMessageDialog(null, "Insert amount plz","Info...",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
						JOptionPane.showMessageDialog(null, "Insert unit plz","Info...",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
					JOptionPane.showMessageDialog(null, "Insert dealer price plz","Info...",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insert returnqty plz","Info...",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insert stockqty plz","Info...",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insert product Id plz","Info...",JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}
	
	private void refreshallwork()
	{
		returnautoid();
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtamount.setText("0.00");
		txtstockqty.setText("");
		date.setDate(new Date());
	    returndate.setDate(new Date());
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		txtremarks.setText("");
		txttotalamount.setText("0.00");
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);		
		}
		findtbdataload();
	}
	
	private void reset()
	{
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtamount.setText("0.00");
		txtstockqty.setText("");
		txtremarks.setText("");
		txtdealerprice.setText("");
		txtreturnquentity.setText("");
		date.setDate(new Date());
		returndate.setDate(new Date());
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		cmbsuppliername.removeAllItems();
		initial(true);
	}
	
	private boolean deletework()
	{
		try
		{
			String sqlinfo="delete from tbretrurntosupplierinfo where returnno='"+txtreturnno.getText().trim()+"'";
			String sqlindetails="delete from tbretrurntosupplierdetails where returnno='"+txtreturnno.getText().trim()+"'";
			Dbconection.conect();
			Dbconection.sta.executeUpdate(sqlinfo);
			Dbconection.sta.executeUpdate(sqlindetails);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	
	private boolean confirmation(String caption)
	{
		int a=JOptionPane.showConfirmDialog(null, caption,"info",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}
	
	private void findaction()
	{
		String fdate=dateformet.format(fromdate.getDate());
		String tdate=dateformet.format(fromdate.getDate());
		
		int a;
		for(a=tablefind.getRowCount()-1;a>=0;a--)
		{
			modelfind.removeRow(a);
		}
		try
		{
			String sql="select returnno,totalamount,currentdate from tbretrurntosupplierinfo" +
					   " where currentdate between '"+fdate+"' and '"+tdate+"' " +
					   "order by currentdate";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				modelfind.addRow(new Object[]
				{
					rs.getString("returnno"),
					rs.getString("totalamount"),
					rs.getString("currentdate")
						
				});
				while(rs.next())
				{
					modelfind.addRow(new Object[]
							{
								rs.getString("returnno"),
								rs.getString("totalamount"),
								rs.getString("currentdate")	
							});
				}	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No data found","info",JOptionPane.INFORMATION_MESSAGE);
				findtbdataload();
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void productwisedataload(String productid)
	{
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		cmbsuppliername.removeAllItems();
		txtunit.setText("");
		txtstockqty.setText("");
		txtdealerprice.setText("");

		String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,supplierid,suppliername," +
				"unit,dealerprice,(select totalstock('"+productid+"')) stock  from tbproductinfo where ProductId ='"+productid+"' ";
		Dbconection.conect();
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				cmbsuppliername.addItem(rs.getString("supplierid")+"#"+rs.getString("suppliername"));
				txtunit.setText(rs.getString("unit"));
				txtstockqty.setText(rs.getString("stock"));
				txtdealerprice.setText(rs.getString("dealerprice"));
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void totalamountsum()
	{
		double sum=0;
		for(int a=0;a<tableinsert.getRowCount();a++)
		{
			sum=sum+Double.parseDouble(tableinsert.getValueAt(a, 8).toString());
		}
		txttotalamount.setText(dformet.format(sum));
	}
	
	public void returnautoid()
	{
		try
		{
			String sql="select ifnull(max(cast(substring(returnno,locate('-',returnno)+1,length"+
					   "(returnno)-locate('-',returnno)) as UNSIGNED)),0)+1 id from tbretrurntosupplierinfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				String returnid=rs.getString("id");
				txtreturnno.setText("ReturnNo-"+returnid);
			}		
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void submittbload()
	{
		String cmbproidname=cmbproductid.txtSuggest.getText();
		StringTokenizer cmbprotoken=new StringTokenizer(cmbproidname,"#");
		String cmbproid=cmbprotoken.nextToken();
		String cmbproname=cmbprotoken.nextToken();
		
		String supplieridname=cmbsuppliername.getSelectedItem().toString();
		StringTokenizer suptoken=new StringTokenizer(supplieridname,"#");
		String supid=suptoken.nextToken();
		String supname=suptoken.nextToken();

		modelinsert.addRow(new Object[]
				{
				cmbproid,
				cmbproname,
				supid,
				supname,
				txtstockqty.getText(),
				txtdealerprice.getText(),
				txtreturnquentity.getText(),
				txtunit.getText(),
				txtamount.getText(),
				txtremarks.getText()
		});	
	}
	
	public void findtbdataload()
	{
		int a;
		
		for(a=tablefind.getRowCount()-1;a>=0;a--)
		{
			modelfind.removeRow(a);
		}
		try
		{
			String sql="select returnno,totalamount,currentdate from tbretrurntosupplierinfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				modelfind.addRow(new Object[]
						{
							rs.getString("returnno"),
							rs.getString("totalamount"),
							rs.getString("currentdate")
						});	
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void datasearch(String retrunno)
	{
		int i;
		for(i=tableinsert.getRowCount()-1;i>=0;i--)
		{
			modelinsert.removeRow(i);
		}
		Dbconection.conect();
		String sql="select a.returnno,a.currentdate,a.username,a.returndate,a.totalamount,b.productid,b.productname," +
				   " b.Supplierid,b.suppliername,b.stockqty,b.returnqty,b.dealerprice,b.unit,b.amount,b.remark"+
                   " from tbretrurntosupplierinfo a inner join tbretrurntosupplierdetails b on a.returnno=b.returnno where a.returnno='"+retrunno+"'";
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
		     int x =0;
			 
			while(rs.next())
			{
				if(x==0)
				{
					txtreturnno.setText(rs.getString("returnno"));
					txtusername.setText(rs.getString("username"));
					date.setDate(rs.getDate("currentdate"));
					returndate.setDate(rs.getDate("returndate"));
					txttotalamount.setText(rs.getString("totalamount"));
					
					x++;
				}
				modelinsert.addRow(new Object[]
						{
							rs.getString("productid"),
							rs.getString("productname"),
							rs.getString("Supplierid"),
							rs.getString("suppliername"),
							rs.getString("stockqty"),
							rs.getString("dealerprice"),
							rs.getString("returnqty"),
							rs.getString("unit"),
							rs.getString("amount"),
							rs.getString("remark")
						});
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"info",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void keyaction()
	{
		tablefind.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				datasearch(modelfind.getValueAt(tablefind.getSelectedRow(), 0).toString());
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		tablefind.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0){}
			public void mouseClicked(MouseEvent arg0) 
			{
				datasearch(modelfind.getValueAt(tablefind.getSelectedRow(), 0).toString());
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
				cmbproductid.txtSuggest.setText(modelinsert.getValueAt(a, 0)+"#"+ modelinsert.getValueAt(a, 1));
				cmbproductid.cmbSuggest.setSelectedItem(modelinsert.getValueAt(a, 0)+"#"+modelinsert.getValueAt(a, 1));
				txtreturnquentity.setText(modelinsert.getValueAt(a, 6).toString());
				amountcal();
				modelinsert.removeRow(a);
				totalamountsum();
				initial(false);
			}
		});
		
		txtreturnquentity.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				amountcal();
			}
			public void keyPressed(KeyEvent arg0) {}
		});
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
		panelsouth.setPreferredSize(new Dimension(1160,300));
		panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouth.setLayout(new BorderLayout());
		panelsouth.add(panelsouthcenter,BorderLayout.CENTER);
		panelsouthcenterwork();
		panelsouth.add(panelsouthnorth,BorderLayout.NORTH);
		panelsouthnorthwork();
	}
	private void panelsouthnorthwork() 
	{
		panelsouthnorth.setBackground(Color.LIGHT_GRAY);
		panelsouthnorth.setPreferredSize(new Dimension(1160,220));
		panelsouthnorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelsouthnorth.add(scrollinsert);
		scrollinsert.setPreferredSize(new Dimension(1140,200));
	}
	private void panelsouthcenterwork() 
	{
		panelsouthcenter.setBackground(Color.LIGHT_GRAY);
		panelsouthcenter.setLayout(new FlowLayout());
		panelsouthcenter.add(lbltotoalamount);
		panelsouthcenter.add(txttotalamount);
		txttotalamount.setFont(font);
		txttotalamount.setForeground(Color.BLUE);
		lbltotoalamount.setFont(font);
		panelsouthcenter.add(btnconfirm);
		btnconfirm.setFont(font);
		panelsouthcenter.add(btnrefreshall);
		btnrefreshall.setFont(font);
	}
	private void panelnorthwork() 
	{
		panelnorth.setBackground(Color.LIGHT_GRAY);
		panelnorth.setPreferredSize(new Dimension(1160,60));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelnorth.setLayout(flow);
		panelnorth.add(lblreturnno);
		lblreturnno.setFont(font);
		panelnorth.add(txtreturnno);
		panelnorth.add(lblusername);
		lblusername.setFont(font);
		panelnorth.add(txtusername);
		txtusername.setText(session.getusername());
		panelnorth.add(lbldate);
		lbldate.setFont(font);
		panelnorth.add(date);
		date.setDate(new Date());
		date.setDateFormatString("dd-MM-yy");
		panelnorth.add(lblreturndate);
		lblreturndate.setFont(font);
		panelnorth.add(returndate);
		returndate.setDate(new Date());
		returndate.setDateFormatString("dd-MM-yy");
		flow.setVgap(20);
	}
	private void panelcenterwork() 
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);
		panelcenter.setLayout(new BorderLayout());
		panelcenter.add(panelcenterwest,BorderLayout.WEST);
		panelcenterwestwork();
		panelcenter.add(panelcentercenter,BorderLayout.CENTER);
		panelcentercenterwork();
	}
	private void panelcentercenterwork() 
	{
		panelcentercenter.setBackground(Color.LIGHT_GRAY);
		TitledBorder titel=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Existing Invoice");
		titel.setTitleColor(Color.DARK_GRAY);
		titel.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		titel.setTitlePosition(TitledBorder.TOP);
		titel.setTitlePosition(TitledBorder.LEFT);
		panelcentercenter.setBorder(titel);
		panelcentercenter.setLayout(new BorderLayout());
		panelcentercenter.add(panelcentercentercenter,BorderLayout.CENTER);
		panelcentercentercenterwork();
		panelcentercenter.add(panelcentercenternorth,BorderLayout.NORTH);
		panelcentercenternorthwork();
	}
	private void panelcentercenternorthwork() 
	{
		panelcentercenternorth.setBackground(Color.LIGHT_GRAY);
		panelcentercenternorth.setPreferredSize(new Dimension(400,60));
		panelcentercenternorth.setLayout(new FlowLayout());
		panelcentercenternorth.add(lblfromdate);
		panelcentercenternorth.add(fromdate);
		fromdate.setDate(new Date());
		lblfromdate.setFont(font);
		fromdate.setDateFormatString("dd-MM-yy");
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
		panelcentercentercenter.add(scrollfind);
		scrollfind.setPreferredSize(new Dimension(400,275));
	}
	private void panelcenterwestwork() 
	{
		panelcenterwest.setBackground(Color.LIGHT_GRAY);
		panelcenterwest.setPreferredSize(new Dimension(710,220));
		panelcenterwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelcenterwest.setLayout(new BorderLayout());
		panelcenterwest.add(panelcenterwestnorth, BorderLayout.NORTH);
		panelcenterwestnorthwork();
		panelcenterwest.add(panelcenterwestcenter, BorderLayout.CENTER);
		panelcenterwestcenterwork();
	}
	private void panelcenterwestcenterwork()
	{
		panelcenterwestcenter.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelcenterwestcenter.setLayout(flow);
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
		panelcenterwestnorth.setPreferredSize(new Dimension(730,320));
		panelcenterwestnorth.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelcenterwestnorth.add(lblproductid,con);
		lblproductid.setFont(font);
		
		con.gridx=1;
		con.gridy=0;
		panelcenterwestnorth.add(cmbproductid.cmbSuggest,con);
		cmbproductid.cmbSuggest.setPreferredSize(new Dimension(200,20));
		
		con.gridx=2;
		con.gridy=0;
		panelcenterwestnorth.add(lblstockqty,con);
		lblstockqty.setFont(font);
		
		con.gridx=3;
		con.gridy=0;
		panelcenterwestnorth.add(txtstockqty,con);
		
		con.gridx=0;
		con.gridy=1;
		panelcenterwestnorth.add(lblcatagory,con);
		lblcatagory.setFont(font);
	
		con.gridx=1;
		con.gridy=1;
		panelcenterwestnorth.add(cmbcatagory,con);
		
		con.gridx=2;
		con.gridy=1;
		panelcenterwestnorth.add(lblreturnquantity,con);
		lblreturnquantity.setFont(font);
	
		con.gridx=3;
		con.gridy=1;
		panelcenterwestnorth.add(txtreturnquentity,con);
		
		con.gridx=0;
		con.gridy=2;
		panelcenterwestnorth.add(lblsubcatagory,con);
		lblsubcatagory.setFont(font);
	
		con.gridx=1;
		con.gridy=2;
		panelcenterwestnorth.add(cmbsubcatagory,con);
		
		con.gridx=2;
		con.gridy=2;
		panelcenterwestnorth.add(lbldealerprice,con);
		lbldealerprice.setFont(font);
	
		con.gridx=3;
		con.gridy=2;
		panelcenterwestnorth.add(txtdealerprice,con);
			
		con.gridx=0;
		con.gridy=3;
		panelcenterwestnorth.add(lblsuppliername,con);
		lblsuppliername.setFont(font);
	
		con.gridx=1;
		con.gridy=3;
		panelcenterwestnorth.add(cmbsuppliername,con);
		
		con.gridx=2;
		con.gridy=3;
		panelcenterwestnorth.add(lblunit,con);
		lblunit.setFont(font);
	
		con.gridx=3;
		con.gridy=3;
		panelcenterwestnorth.add(txtunit,con);

		con.gridx=2;
		con.gridy=4;
		panelcenterwestnorth.add(lblamount,con);
		lblamount.setFont(font);
	
		con.gridx=3;
		con.gridy=4;
		panelcenterwestnorth.add(txtamount,con);
		
		con.gridx=2;
		con.gridy=5;
		panelcenterwestnorth.add(lblremark,con);
		lblremark.setFont(font);
	
		con.gridx=3;
		con.gridy=5;
		panelcenterwestnorth.add(scrollremarks,con);	
	}
}