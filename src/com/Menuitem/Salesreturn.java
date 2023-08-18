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

public class Salesreturn extends JPanel{
	JPanel panelcenter=new JPanel();
	JPanel panelnorth=new JPanel();
	JPanel panelsouth=new JPanel();
	JPanel panelsouthnorth=new JPanel();
	JPanel panelsouthcenter=new JPanel();
	JPanel panelcenterwest=new JPanel();
	JPanel panelcentercenter=new JPanel();
	JPanel panelcentercenternorth=new JPanel();
	JPanel panelcentercentercenter=new JPanel();
	JPanel panelcenterwestnorth=new JPanel();
	JPanel panelcenterwestcenter=new JPanel();
	
	JLabel lblsalesno=new JLabel("Sales No");
	JLabel lblalreadyreturn=new JLabel("Already Receive");
	JLabel lbltradeprice=new JLabel("Trade Price");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstockqty=new JLabel("Stock Qty");
	JLabel lblsalesqty=new JLabel("Sales Qty");
	JLabel lblreturnqty=new JLabel("Return qty");
	JLabel lbltotoalamount=new JLabel("Total Amount");
	JLabel lblsalesreturnno=new JLabel("Sales Return No");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblcurrentdate=new JLabel("Current Date");
	JLabel lblreturndate=new JLabel("S.Return Date");
	JLabel lblfromdate=new JLabel("FromDate");
	JLabel lbltodate=new JLabel("To Date");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel ("Sub Catagory");
	JLabel lblproductid=new JLabel ("Product");
	JLabel lbltotalstack=new JLabel ("Total Stack");
	JLabel lblsalesquantity=new JLabel("Sales Quantity");
	JLabel lblrecivequantity=new JLabel("Receive Quantity");
	JLabel lblremark=new JLabel("Remark");
	JLabel lblamount=new JLabel("Amount");
	
	JTextField txtamount=new JTextField(20);
	JTextField txtstockqty=new JTextField(20);
	JTextField txtunit=new JTextField(20);
	JTextField txttradeprice=new JTextField(20);
	JTextField txtalreadyreceive=new JTextField(20);
	JTextField txtsalesqty=new JTextField(20);
	JTextField txttotalamount=new JTextField(20);
	JTextField txtsalesreturnno=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txttotalstack=new JTextField(20);
	JTextField txtsalesquantity=new JTextField(20);
	JTextField txtrecivequantity=new JTextField(20);
	JTextArea txtremarks=new JTextArea(4,1);
	JScrollPane scrollremarks=new JScrollPane(txtremarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JDateChooser currentdate=new JDateChooser();
	JDateChooser returndate=new JDateChooser();
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate=new JDateChooser();
	
	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();
	SuggestText cmbproductid=new SuggestText();
	SuggestText cmbsalesno=new SuggestText();

	JButton btnconfirm=new JButton("Confirm",new ImageIcon("img/confirm.png"));
	JButton btnrefreshall=new JButton("Refresh",new ImageIcon("img/donee.png"));
	JButton btnfind=new JButton("Find",new ImageIcon("img/find.png"));
	JButton btnsubmit=new JButton("Submit",new ImageIcon("img/submit.png"));
	JButton btnedit=new JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new JButton("Delete",new ImageIcon("img/delete.png"));

	String colname[]={"Sales No","Product Id","Product Name","Stock Qty","Sales Qty","Receive Qty","Trade Price","Unit", "Already Return","Amount","Remark"};
	Object rowname[][]={}; 
	DefaultTableModel modelinsert=new DefaultTableModel(rowname,colname);
	JTable tableinsert=new JTable(modelinsert);
	JScrollPane scrolinsert=new JScrollPane(tableinsert,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String colname1[]={"Sales Return No","Total Amount","S.return Date"};
	Object rowname1[][]={}; 
	DefaultTableModel modelfind=new DefaultTableModel(rowname1,colname1);
	JTable tablefind=new JTable(modelfind);
	JScrollPane scrollfind=new JScrollPane(tablefind,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	Font font=new Font("serif", Font.BOLD+Font.ITALIC, 15);
	DecimalFormat deciformet=new DecimalFormat("#0.00");
	SimpleDateFormat  dateformet=new SimpleDateFormat("yyyy-MM-dd");
	boolean findupdate=false;
	SessionBean session;
	
	public Salesreturn(SessionBean bean)
	{
		this.session=bean;
		panelwork();
		btnaction();
		keyaction();
		initial(true);
		initialamount();
		editfalse();
	}

	private void editfalse() 
	{
		cmbcatagory.setEnabled(false);
		cmbsubcatagory.setEnabled(false);;
		txtunit.setEditable(false);
		txtstockqty.setEditable(false);
		txtsalesqty.setEditable(false);
		txttradeprice.setEditable(false);
		txtalreadyreceive.setEditable(false);
		txtamount.setEditable(false);
		txttotalamount.setEditable(false);
		txtusername.setEditable(false);
		txtsalesreturnno.setEditable(false);
	}

	private void amountcal()
	{
		double receiveqty,traderate,amount;
		receiveqty=Double.parseDouble(txtrecivequantity.getText().trim().isEmpty()?"0.00":txtrecivequantity.getText().trim());
		traderate=Double.parseDouble(txttradeprice.getText().trim().isEmpty()?"0.00":txttradeprice.getText().trim());
		amount=receiveqty*traderate;
		txtamount.setText(deciformet.format(amount));
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
	
	public void salesdataload()
	{
		cmbsalesno.v.clear();
		cmbsalesno.v.add("");
		try
		{
			String sql="select salesno from tbsalesinfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbsalesno.v.add(rs.getString("salesno"));
			}
			Dbconection.con.close();
		}
		catch(Exception ez)
		{
			JOptionPane.showMessageDialog(null, ez);
		}
	}
	
	public void productdataload()
	{
		cmbproductid.v.clear();
		cmbproductid.v.add("");
		
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		txtunit.setText("");
		txtstockqty.setText("");
		txttradeprice.setText("");

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
									salesreturnautoid();
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
								salesreturnautoid();
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
				if(!cmbproductid.txtSuggest.getText().isEmpty())
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
					txtunit.setText("");
					txttradeprice.setText("");
					txtstockqty.setText("");
				}
			}
		});
		
		cmbsalesno.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!cmbsalesno.txtSuggest.getText().isEmpty())
				{
					String sales=cmbsalesno.txtSuggest.getText();
					StringTokenizer troken=new StringTokenizer(sales);
					String salesid=troken.nextToken();
					saleswisesearch(salesid);
				}
				else
				{
					cmbproductid.txtSuggest.setText("");
				}
			}
		});
	}
	
	private boolean confirmchk()
	{
		if(!txtsalesreturnno.getText().trim().isEmpty() && tableinsert.getRowCount()>=1)
		{
			return true;
		}
		return true;
	}
	
	private boolean doubleentry()
	{
		String idname=cmbproductid.txtSuggest.getText();
		StringTokenizer token=new StringTokenizer(idname,"#");
		String pid=token.nextToken();
		int a;
		for(a=0;a<modelinsert.getRowCount();a++)
		{
			String productid=modelinsert.getValueAt(a, 1).toString();
			if(productid.equals(pid))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean chkvalidation()
	{
		if(!cmbsalesno.txtSuggest.getText().isEmpty()){
			if(!cmbproductid.txtSuggest.getText().isEmpty()){
				if(!txtstockqty.getText().trim().isEmpty()){
					if(!txtsalesqty.getText().trim().isEmpty()){
						if(!txttradeprice.getText().trim().isEmpty()){
							if(!txtalreadyreceive.getText().trim().isEmpty()){
								if(!txtrecivequantity.getText().trim().isEmpty()){
									if(!txtamount.getText().trim().isEmpty()){
										if(!txtunit.getText().trim().isEmpty())
										{
											return true;
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Insert unit plz","Info...",JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Insert amount plz","Info...",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Insert Receiveqty plz","Info...",JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Insert alreadyreceive plz","Info...",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Insert Tradeprice plz","Info...",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert Salesqty plz","Info...",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insert Stockqty plz","Info...",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insert ProductID plz","Info...",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insert SalesNo plz","Info...",JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}
	
	private void refreshallwork()
	{
		salesreturnautoid();
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtamount.setText("0.00");
		txttradeprice.setText("");
		txtrecivequantity.setText("");
		txtsalesqty.setText("");
		txttradeprice.setText("");
		txtstockqty.setText("");
		currentdate.setDate(new Date());
		returndate.setDate(new Date());
		cmbproductid.txtSuggest.setText("");
		cmbsalesno.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		txttotalamount.setText("0.00");
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);
				
		}
		findtbdataload();
	}
	
	private boolean insertdata()
	{
		try
		{
			String cdate=dateformet.format(currentdate.getDate());
			String rdate=dateformet.format(returndate.getDate());
			
			Dbconection.conect();
			Dbconection.con.setAutoCommit(false);
			String sqlinfo="insert into tbsalesreturninfo (salesreturnno,currentdate," +
					       "Returndate,totalamount,Username,entrytime,Userip)"+
                           "values('"+txtsalesreturnno.getText().trim()+"','"+cdate+"','"+rdate+"'," +
                           "'"+txttotalamount.getText().trim()+"','"+txtusername.getText().trim()+"',now(),'')";
			Dbconection.sta.executeUpdate(sqlinfo);
			
			for(int a=0;a<tableinsert.getRowCount();a++)		
			{
				String sqldetails="insert into tbsalesreturndetails (salesreturnno,salesno,productid,productname," +
						          "stockqty,alreadyreceive,traderprice,unit,salesqty,receiveqty,amount,remark,entrytime,Userip)"+
                                  "values('"+txtsalesreturnno.getText().trim()+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 0)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 1)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 2)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 3)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 8)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 6)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 7)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 4)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 5)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 9)+"'," +
                                  		  "'"+modelinsert.getValueAt(a, 10)+"'," +
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
	private void reset()
	{
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtrecivequantity.setText("");
		txtalreadyreceive.setText("");
		txtsalesqty.setText("");
		txtremarks.setText("");
		txtamount.setText("0.00");
		txttradeprice.setText("");
		txtstockqty.setText("");
		currentdate.setDate(new Date());
		returndate.setDate(new Date());
		cmbsalesno.txtSuggest.setText("");
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		initial(true);
	}
	
	private void totalamountsum()
	{
		double sum=0;
		for(int a=0;a<tableinsert.getRowCount();a++)
		{
			sum=sum+Double.parseDouble(tableinsert.getValueAt(a, 9).toString());
		}
		txttotalamount.setText(deciformet.format(sum));
	}
	
	private void submittbload()
	{
		String cmbsaleno=cmbsalesno.txtSuggest.getText();
		StringTokenizer salestoken=new StringTokenizer(cmbsaleno,"#");
		String sno=salestoken.nextToken();
		
		String cmbproidname=cmbproductid.txtSuggest.getText();
		StringTokenizer cmbprotoken=new StringTokenizer(cmbproidname,"#");
		String cmbproid=cmbprotoken.nextToken();
		String cmbproname=cmbprotoken.nextToken();
		
		modelinsert.addRow(new Object[]
				{
				sno,
				cmbproid,
				cmbproname,
				txtstockqty.getText(),
				txtsalesqty.getText(),
				txtrecivequantity.getText(),
				txttradeprice.getText(),
				txtunit.getText(),
				txtalreadyreceive.getText(),
				txtamount.getText(),
				txtremarks.getText()
		});	
	}
	
	private boolean deletework()
	{
		try
		{
			String sqlinfo="delete from tbsalesreturninfo where salesreturnno='"+txtsalesreturnno.getText().trim()+"'";
			String sqlindetails="delete from tbsalesreturndetails where salesreturnno='"+txtsalesreturnno.getText().trim()+"'";
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
	public void salesreturnautoid()
	{
		try
		{
			String sql="select ifnull(max(cast(substring(salesreturnno,locate('-',salesreturnno)+1,length"+
						"(salesreturnno)-locate('-',salesreturnno)) as UNSIGNED)),0)+1 id from tbsalesreturninfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				String returnid=rs.getString("id");
				txtsalesreturnno.setText("SalesReturnNo-"+returnid);
			}			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void findaction()
	{
		String fdate=dateformet.format(fromdate.getDate());
		String tdate=dateformet.format(todate.getDate());
		int a;
		for(a=tablefind.getRowCount()-1;a>=0;a--)
		{
			modelfind.removeRow(a);
			
		}
		try
		{
	        String sql="select salesreturnno,totalamount,returndate from tbsalesreturninfo"+
                       " where returndate between  '"+fdate+"' and '"+tdate+"' order by returndate";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				modelfind.addRow(new Object[]
				{
					rs.getString("salesreturnno"),
					rs.getString("totalamount"),
					rs.getString("returndate")
						
				});
				while(rs.next())
				{
					modelfind.addRow(new Object[]
							{
								rs.getString("salesreturnno"),
								rs.getString("totalamount"),
								rs.getString("returndate")	
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
	
	public void findtbdataload()
	{
		int a;
		for(a=tablefind.getRowCount()-1;a>=0;a--)
		{
			modelfind.removeRow(a);
		}
		try
		{
			String sql="select salesreturnno,totalamount," +
					   "Returndate from tbsalesreturninfo order by Returndate";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				modelfind.addRow(new Object[]
						{
							rs.getString("salesreturnno"),
							rs.getString("totalamount"),
							rs.getString("Returndate")
						});	
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void saleswisesearch(String id)
	{
		cmbproductid.v.clear();
		cmbproductid.v.add("");
		String sql="select productid,productname from tbsalesdetails where salesno='"+id+"'";
		Dbconection.conect();
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbproductid.v.add(rs.getString("productid")+"#"+rs.getString("productname"));
				
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
		txtunit.setText("");
		txttradeprice.setText("");
		txtstockqty.setText("");
		txtalreadyreceive.setText("");
		try
		{
			String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname," +
					   "unit,(select totalstock('"+productid+"')) stock ,(select ifnull(sum(receiveqty),0) from tbsalesreturndetails where productid ='"+productid+"')  alreadyreceive from tbproductinfo where ProductId ='"+productid+"' ";
			Dbconection.conect();
			Dbconection.con.setAutoCommit(false);
			
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				txtunit.setText(rs.getString("unit"));
				txtstockqty.setText(rs.getString("stock"));
				txtalreadyreceive.setText(rs.getString("alreadyreceive"));
			}
			String sqld="select salesqty,tradeprice from tbsalesdetails where salesno='"+cmbsalesno.txtSuggest.getText().trim()+"' and productid='"+productid+"'";
			ResultSet rss=Dbconection.sta.executeQuery(sqld);
			while(rss.next())
			{
				txttradeprice.setText(rss.getString("tradeprice"));
				txtsalesqty.setText(rss.getString("salesqty"));
			}
			Dbconection.con.commit();
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}

	private void datasearch(String salesreturnno)
	{
		int i;
		for(i=tableinsert.getRowCount()-1;i>=0;i--)
		{
			modelinsert.removeRow(i);
		}
		Dbconection.conect();
		String sql="select a.salesreturnno,a.Username,a.currentdate,a.Returndate," +
				   "a.totalamount,b.productid,b.productname,b.salesno,b.stockqty," +
				   "b.receiveqty,b.alreadyreceive,b.salesqty,b.traderprice,b.unit,b.amount,b.remark"+
                   " from tbsalesreturninfo a inner join tbsalesreturndetails b on a.salesreturnno=b.salesreturnno where a.salesreturnno='"+salesreturnno+"'";	
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
		     int x =0;
			 
			while(rs.next())
			{
				if(x==0)
				{
					txtsalesreturnno.setText(rs.getString("salesreturnno"));
					txtusername.setText(rs.getString("Username"));
					currentdate.setDate(rs.getDate("currentdate"));
					returndate.setDate(rs.getDate("Returndate"));
					txttotalamount.setText(rs.getString("totalamount"));
					
					x++;
				}
				modelinsert.addRow(new Object[]
						{
						    rs.getString("salesno"),
							rs.getString("productid"),
							rs.getString("productname"),
							rs.getString("stockqty"),
							rs.getString("salesqty"),
							rs.getString("receiveqty"),
							rs.getString("traderprice"),
							rs.getString("unit"),
							rs.getString("alreadyreceive"),
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
			public void mouseReleased(MouseEvent arg0){}
			public void mousePressed(MouseEvent arg0){}
			public void mouseExited(MouseEvent arg0){}
			public void mouseEntered(MouseEvent arg0){}
			public void mouseClicked(MouseEvent arg0) 
			{
				int a=tableinsert.getSelectedRow();
				cmbsalesno.txtSuggest.setText(modelinsert.getValueAt(a, 0).toString());
				cmbsalesno.cmbSuggest.setSelectedItem(modelinsert.getValueAt(a, 0).toString());
				cmbproductid.txtSuggest.setText(modelinsert.getValueAt(a, 1)+"#"+ modelinsert.getValueAt(a, 2));
				cmbproductid.cmbSuggest.setSelectedItem(modelinsert.getValueAt(a, 1)+"#"+ modelinsert.getValueAt(a, 2));
				txtrecivequantity.setText( modelinsert.getValueAt(a, 5).toString());
				amountcal();
				modelinsert.removeRow(tableinsert.getSelectedRow());
				totalamountsum();
				initial(false);
			}
		});
		
		txtrecivequantity.addKeyListener(new KeyListener() 
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
		add(panelcenter, BorderLayout.CENTER);
		panelcenterwork();
		add(panelnorth, BorderLayout.NORTH);
		panelnorthwork();
		add(panelsouth, BorderLayout.SOUTH);
		panelsouthwork();
	}

	private void panelsouthwork() 
	{
		panelsouth.setBackground(Color.LIGHT_GRAY);
		panelsouth.setLayout(new BorderLayout());
		panelsouth.setPreferredSize(new Dimension(1160,300));
		panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouth.add(panelsouthnorth, BorderLayout.NORTH);
		panelsouth.add(panelsouthcenter, BorderLayout.CENTER);
		panelsouthnorthwork();
		panelsouthcenterwork();
	}

	private void panelsouthcenterwork() 
	{
		panelsouthcenter.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelsouthcenter.setLayout(flow);
		flow.setVgap(8);
		panelsouthcenter.add(lbltotoalamount);
		lbltotoalamount.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelsouthcenter.add(txttotalamount);
		txttotalamount.setFont(font);
		txttotalamount.setForeground(Color.BLUE);
		panelsouthcenter.add(btnconfirm);
		btnconfirm.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelsouthcenter.add(btnrefreshall);
		btnrefreshall.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	}

	private void panelsouthnorthwork()
	{
		panelsouthnorth.setBackground(Color.LIGHT_GRAY);
		panelsouthnorth.setPreferredSize(new Dimension(1160,230));
		panelsouthnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouthnorth.add(scrolinsert);
		scrolinsert.setPreferredSize(new Dimension(1140,220));
	}

	private void panelnorthwork() 
	{
		panelnorth.setBackground(Color.LIGHT_GRAY);
		panelnorth.setPreferredSize(new Dimension(1160,60));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelnorth.setLayout(flow);
		panelnorth.add(lblsalesreturnno);
		lblsalesreturnno.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelnorth.add(txtsalesreturnno);
		panelnorth.add(lblusername);
		lblusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelnorth.add(txtusername);
		txtusername.setText(session.getusername());
		panelnorth.add(lblcurrentdate);
		lblcurrentdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelnorth.add(currentdate);
		currentdate.setDateFormatString("dd-MM-yy");
		currentdate.setDate(new Date());
		panelnorth.add(lblreturndate);
		lblreturndate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelnorth.add(returndate);
		returndate.setDateFormatString("dd-MM-yy");
		returndate.setDate(new Date());
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
		TitledBorder title=new TitledBorder(BorderFactory.createLineBorder(Color.WHITE),"Existing Invoice");
		title.setTitleColor(Color.BLACK);
		title.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		title.setTitleJustification(TitledBorder.TOP);
		panelcentercenter.setBorder(title);
		panelcentercenter.setLayout(new BorderLayout());
		panelcentercenter.add(panelcentercentercenter,BorderLayout.CENTER);
		panelcentercentercenterwork();
		panelcentercenter.add(panelcentercenternorth,BorderLayout.NORTH);
		panelcentercenternorthwork();
	}

	private void panelcentercenternorthwork()
	{
		panelcentercenternorth.setBackground(Color.LIGHT_GRAY);
		panelcentercenternorth.setPreferredSize(new Dimension(400,50));
		panelcentercenternorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		panelcentercenternorth.setLayout(flow);
		panelcentercenternorth.add(lblfromdate);
		panelcentercenternorth.add(fromdate);
		lblfromdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		fromdate.setDateFormatString("dd-MM-yy");
		fromdate.setDate(new Date());
		panelcentercenternorth.add(lbltodate);
		lbltodate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentercenternorth.add(todate);
		todate.setDateFormatString("dd-MM-yy");
		todate.setDate(new Date());
		panelcentercenternorth.add(btnfind);
		btnfind.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 13));
	}

	private void panelcentercentercenterwork() 
	{
		panelcentercentercenter.setBackground(Color.LIGHT_GRAY);
		panelcentercentercenter.add(scrollfind);
		scrollfind.setPreferredSize(new Dimension(400,290));
	}

	private void panelcenterwestwork() 
	{
		panelcenterwest.setBackground(Color.LIGHT_GRAY);
		panelcenterwest.setPreferredSize(new Dimension(710,410));
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
		btnsubmit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcenterwestcenter.add(btnedit);
		btnedit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcenterwestcenter.add(btnrefresh);
		btnrefresh.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcenterwestcenter.add(btndelete);
		btndelete.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	}

	private void panelcenterwestnorthwork()
	{
		panelcenterwestnorth.setBackground(Color.LIGHT_GRAY);
		panelcenterwestnorth.setPreferredSize(new Dimension(730,340));
		panelcenterwestnorth.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();

		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelcenterwestnorth.add(lblsalesno,con);
		lblsalesno.setFont(font);
		
		con.gridx=1;
		con.gridy=0;
		panelcenterwestnorth.add(cmbsalesno.cmbSuggest,con);
		cmbsalesno.cmbSuggest.setPreferredSize(new Dimension(120,30));

		con.gridx=2;
		con.gridy=0;
		panelcenterwestnorth.add(lblsalesqty,con);
		lblsalesqty.setFont(font);
		
		con.gridx=3;
		con.gridy=0;
		panelcenterwestnorth.add(txtsalesqty,con);
		
		con.gridx=0;
		con.gridy=1;
		panelcenterwestnorth.add(lblproductid,con);
		lblproductid.setFont(font);
	
		con.gridx=1;
		con.gridy=1;
		panelcenterwestnorth.add(cmbproductid.cmbSuggest,con);
		
		con.gridx=2;
		con.gridy=1;
		panelcenterwestnorth.add(lbltradeprice,con);
		lbltradeprice.setFont(font);
	
		con.gridx=3;
		con.gridy=1;
		panelcenterwestnorth.add(txttradeprice,con);
		
		con.gridx=0;
		con.gridy=2;
		panelcenterwestnorth.add(lblcatagory,con);
		lblcatagory.setFont(font);
	
		con.gridx=1;
		con.gridy=2;
		panelcenterwestnorth.add(cmbcatagory,con);
		
		con.gridx=2;
		con.gridy=2;
		panelcenterwestnorth.add(lblalreadyreturn,con);
		lblalreadyreturn.setFont(font);
	
		con.gridx=3;
		con.gridy=2;
		panelcenterwestnorth.add(txtalreadyreceive,con);
	
		con.gridx=0;
		con.gridy=3;
		panelcenterwestnorth.add(lblsubcatagory,con);
		lblsubcatagory.setFont(font);
	
		con.gridx=1;
		con.gridy=3;
		panelcenterwestnorth.add(cmbsubcatagory,con);
		
		con.gridx=2;
		con.gridy=3;
		panelcenterwestnorth.add(lblrecivequantity,con);
		lblrecivequantity.setFont(font);
	
		con.gridx=3;
		con.gridy=3;
		panelcenterwestnorth.add(txtrecivequantity,con);

		con.gridx=0;
		con.gridy=4;
		panelcenterwestnorth.add(lblstockqty,con);
		lblstockqty.setFont(font);
	
		con.gridx=1;
		con.gridy=4;
		panelcenterwestnorth.add(txtstockqty,con);
		
		con.gridx=2;
		con.gridy=4;
		panelcenterwestnorth.add(lblamount,con);
		lblamount.setFont(font);
	
		con.gridx=3;
		con.gridy=4;
		panelcenterwestnorth.add(txtamount,con);
		
		con.gridx=2;
		con.gridy=5;
		panelcenterwestnorth.add(lblunit,con);
		lblunit.setFont(font);
	
		con.gridx=3;
		con.gridy=5;
		panelcenterwestnorth.add(txtunit,con);
		
		con.gridx=2;
		con.gridy=6;
		panelcenterwestnorth.add(lblremark,con);
		lblremark.setFont(font);
	
		con.gridx=3;
		con.gridy=6;
		panelcenterwestnorth.add(scrollremarks,con);	
	}
}
