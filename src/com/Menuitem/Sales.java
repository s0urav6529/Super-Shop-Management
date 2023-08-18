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
import java.awt.image.TileObserver;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ItalicAction;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class Sales extends JPanel {

	JPanel panelnorth=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelsouth=new JPanel();
	JPanel panelsouthcenter=new JPanel();
	JPanel panelsouthcenterwest=new JPanel();
	JPanel panelsouthcentercenter=new JPanel();
	JPanel panelsouthnorth=new JPanel();

	JPanel panelcenterwest=new JPanel();
	JPanel panelcentercenter=new JPanel();
	JPanel panelcentercenternorth=new JPanel();
	JPanel panelcentercentercenter=new JPanel();
	JPanel panelcenterwestnorth=new JPanel();
	JPanel panelcenterwestcenter=new JPanel();

	JCheckBox chkregisterclient=new JCheckBox("Register Client");
	JCheckBox chkunregisterclient=new JCheckBox("Unregister Client");

	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel ("Sub Catagory");
	JLabel lblproductid=new JLabel ("Product Id");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstockqty=new JLabel("Stock Qty");
	JLabel lblsalesno=new JLabel("Sales No");
	JLabel lblsalesqty=new JLabel("Sales Qty");
	JLabel lbldealerrate=new JLabel("Dealer Rate");
	JLabel lbltraderate=new JLabel("Trade Rate");
	JLabel lblremarks=new JLabel("Remarks");
	JLabel lblfromdate=new JLabel("From Date");
	JLabel lbltodate=new JLabel("To Date");
	JLabel lblclientid=new JLabel("Client Id");
	JLabel lblusername=new JLabel ("User Name");
	JLabel lblcurrentdate=new JLabel ("C.Date");
	JLabel lbltotoalamount=new JLabel("Total Amount");
	JLabel lbldue=new JLabel("Due Amount");
	JLabel lblpaymentprotocol=new JLabel("Payment Protocol");
	JLabel lblpaidamount=new JLabel("Paid Amount");
	JLabel lbldiscountamount=new JLabel("Discount Amount");
	JLabel lblreference=new JLabel("Reference");
	JLabel lblamount=new JLabel("Amount");

	ButtonGroup group=new ButtonGroup();

	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate=new JDateChooser();
	JDateChooser salesdate=new JDateChooser();

	JTextField txttraderate=new JTextField(20);
	JTextField txtdealerrate=new JTextField(20);
	JTextField txtamount=new JTextField(20);
	JTextField txtsalesno=new JTextField(20);
	JTextField txtsalesqty=new JTextField(20);
	JTextField txtstockqty=new JTextField(20);
	JTextField txtunit=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txttotalamount=new JTextField(10);
	JTextField txtdue=new JTextField(10);
	JTextField txtdiscountamount=new JTextField(10);
	JTextField txtpaidamount=new JTextField(10);
	JTextField txtreference=new JTextField(10);

	SuggestText cmbproductid=new SuggestText();
	SuggestText cmbclientid=new SuggestText();
	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();

	
	SuggestText cmbpaymentpotocol=new SuggestText();

	JButton btnsubmit=new JButton("Submit",new ImageIcon("img/submit.png"));
	JButton btnedit=new JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new JButton("Delete",new ImageIcon("img/delete.png"));
	JButton btnfind=new JButton("Find",new ImageIcon("img/find.png"));
	JButton btnconfirm=new JButton("Confirm",new ImageIcon("img/confirm.png"));
	JButton btnrefreshall=new JButton("Refresh",new ImageIcon("img/donee.png"));
	JTextArea txtremarks=new JTextArea(3,3);
	JScrollPane scrollremarks=new JScrollPane(txtremarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


	String colname[]={"Product id","Product Name","Unit","Stock Qty","Sales Qty","Dealer Rate","Trade Rate","Amount","Remarks"};
	Object rowname[][]={}; 
	DefaultTableModel modelinsert=new DefaultTableModel(rowname,colname);
	JTable tableinsert=new JTable(modelinsert);
	JScrollPane scrollinsert=new JScrollPane(tableinsert,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	String colname1[]={"Sales No","Total Amount","Sales Date"};
	Object rowname1[][]={}; 
	DefaultTableModel modelfind=new DefaultTableModel(rowname1,colname1);
	JTable tablefind=new JTable(modelfind);
	JScrollPane scrollfind=new JScrollPane(tablefind,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	SessionBean session;
	DecimalFormat dformet=new DecimalFormat("#0.00");

	Font font=new Font("serif", Font.BOLD+Font.ITALIC, 15);
	SimpleDateFormat  dateformet=new SimpleDateFormat("yyyy-MM-dd");

	boolean findupdate=false;

	public Sales(SessionBean bean)
	{
		this.session=bean;
		panelwork();
		btnaction();
		keyaction();
		initial(true);
		initialamount();
		editfalse();
		chkeditfalse();
	}

	private void chkeditfalse()
	{
		chkunregisterclient.setSelected(true);
		txtdue.setEnabled(false);
		cmbclientid.txtSuggest.setEnabled(false);

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

	public void clientdataload()
	{
		try
		{
			cmbclientid.v.clear();
			cmbclientid.v.add("");

			String sql="select clientid,clientname from tbclientinfo";

			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbclientid.v.add(rs.getString("clientid")+"#"+rs.getString("clientname"));
			}
			Dbconection.con.close();

		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}

	private boolean doubleentry()
	{
		String productidname=cmbproductid.txtSuggest.getText();
		StringTokenizer token=new StringTokenizer(productidname,"#");
		String productid=token.nextToken();

		int a;
		for(a=0;a<modelinsert.getRowCount();a++)
		{
			String pid=modelinsert.getValueAt(a, 0).toString();
			if(productid.equals(pid))
			{
				return true;
			}

		}
		return false;
	}

	private void totalamountsum()
	{
		double sum=0;
		for(int a=0;a<tableinsert.getRowCount();a++)
		{
			sum=sum+Double.parseDouble(tableinsert.getValueAt(a, 7).toString());
		}
		txttotalamount.setText(dformet.format(sum));
		txtpaidamount.setText(dformet.format(sum));
	}

	private void submittbload()
	{
		String cmbproidname=cmbproductid.txtSuggest.getText();
		StringTokenizer cmbprotoken=new StringTokenizer(cmbproidname,"#");
		String cmbproid=cmbprotoken.nextToken();
		String cmbproname=cmbprotoken.nextToken();

		modelinsert.addRow(new Object[]
				{
				cmbproid,
				cmbproname,
				txtunit.getText(),
				txtstockqty.getText(),
				txtsalesqty.getText(),
				txtdealerrate.getText(),
				txttraderate.getText(),
				txtamount.getText(),
				txtremarks.getText()
				});	
	}

	public void productdataload()
	{

		cmbproductid.v.clear();
		cmbproductid.v.add("");

		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		txtunit.setText("");
		txtstockqty.setText("");
		txtdealerrate.setText("");
		txttraderate.setText("");

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

	private boolean chkvalidation()
	{
		if(!cmbproductid.txtSuggest.getText().isEmpty())
		{
			if(!txtstockqty.getText().trim().isEmpty())
			{
				if(!txtsalesqty.getText().trim().isEmpty())
				{
					if(!txtdealerrate.getText().trim().isEmpty())
					{
						return true;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert rate Plz !","Info",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insert Sales qty Plz !","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insert Stock qty Plz !","Info",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insert product id Plz !","Info",JOptionPane.INFORMATION_MESSAGE);
		}

		return false;
	}

	private void productwiseload(String productid)
	{
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		txtunit.setText("");
		txtstockqty.setText("");
		txtdealerrate.setText("");
		txttraderate.setText("");

		String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,unit," +
				"dealerprice,tradeprice,(select totalstock('"+productid+"')) stcok from tbproductinfo where ProductId ='"+productid+"' ";
		Dbconection.conect();

		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				txtunit.setText(rs.getString("unit"));
				txtdealerrate.setText(rs.getString("dealerprice"));
				txttraderate.setText(rs.getString("tradeprice"));
				txtstockqty.setText(rs.getString("stcok"));
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
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtsalesqty.setText("");
		txtamount.setText("0.00");
		txtdealerrate.setText("");
		txttraderate.setText("");
		txtstockqty.setText("");
		salesdate.setDate(new Date());
		chkunregisterclient.setEnabled(true);
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		initial(true);
		txtreference.setEditable(true);
	}

	private void dueamountcal()
	{
		double total,discount,paid,due;
		total=Double.parseDouble(txttotalamount.getText().trim().isEmpty()?"0.00":txttotalamount.getText().trim());
		discount=Double.parseDouble(txtdiscountamount.getText().trim().isEmpty()?"0.00":txtdiscountamount.getText().trim());
		paid=Double.parseDouble(txtpaidamount.getText().trim().isEmpty()?"0.00":txtpaidamount.getText().trim());
		due=total-(discount+paid);
		txtdue.setText(dformet.format(due));
	}

	private void discountamountcal()
	{
		double paid,discount,totalamount;
		paid=Double.parseDouble(txtpaidamount.getText().trim().isEmpty()?"0.00":txtpaidamount.getText().trim());
		totalamount=Double.parseDouble(txttotalamount.getText().trim().isEmpty()?"0.00":txttotalamount.getText().trim());
		discount=totalamount-paid;
		txtdiscountamount.setText(dformet.format(discount));
	}
	
	private void paidamountcaldue()
	{
		double paidamount,dueamount,totalamount;
		dueamount=Double.parseDouble(txtdue.getText().trim().isEmpty()?"0.00":txtdue.getText().trim());
		totalamount=Double.parseDouble(txttotalamount.getText().trim().isEmpty()?"0.00":txttotalamount.getText().trim());
		paidamount=totalamount-dueamount;
		txtpaidamount.setText(dformet.format(paidamount));
	}
	private void paidamountcaldiscount()
	{
		double paidamount,discount,totalamount;
		discount=Double.parseDouble(txtdiscountamount.getText().trim().isEmpty()?"0.00":txtdiscountamount.getText().trim());
		totalamount=Double.parseDouble(txttotalamount.getText().trim().isEmpty()?"0.00":txttotalamount.getText().trim());
		paidamount=totalamount-discount;
		txtpaidamount.setText(dformet.format(paidamount));
	}
	private void amountcal()
	{
		double salesqty,traderate,amount;
		salesqty=Double.parseDouble(txtsalesqty.getText().trim().isEmpty()?"0.00":txtsalesqty.getText().trim());
		traderate=Double.parseDouble(txttraderate.getText().trim().isEmpty()?"0.00":txttraderate.getText().trim());
		amount=salesqty*traderate;
		txtamount.setText(dformet.format(amount));
	}
	
	private boolean insertdata()
	{
		try
		{
			String clientid="No client";
			String clientname="No client";
			String ClientType="UnRegisterClient";
			String due="0.00";
			String reference=txtreference.getText().trim();			
			if(cmbpaymentpotocol.txtSuggest.getText().equalsIgnoreCase("Cash"))
			{
				reference="";
			}
			if(chkregisterclient.isSelected())
			{
				String clientidname=cmbclientid.txtSuggest.getText();
				StringTokenizer clienttoken=new StringTokenizer(clientidname,"#");
				clientid=clienttoken.nextToken();
				clientname=clienttoken.nextToken();	
				ClientType="RegisterClient";
				due=txtdue.getText().trim();
			}
			String sdate=dateformet.format(salesdate.getDate());

			Dbconection.conect();
			Dbconection.con.setAutoCommit(false);
			
			String sqlinfo="insert into tbsalesinfo(salesno,clientid,clientname,clienttype,salesdate,"+
					"paymentprotocol,totalamount,paidamount,discountamount,dueamount,"+
					"username,reference,entrytime,userip)"+
					"values " +
					"('"+txtsalesno.getText().trim()+"'," +
					"'"+clientid+"'," +
					"'"+clientname+"'," +
					"'"+ClientType+"'," +
					"'"+sdate+"'," +
					"'"+cmbpaymentpotocol.txtSuggest.getText().trim()+"'," +
					"'"+txttotalamount.getText().trim()+"'," +
					"'"+txtpaidamount.getText().trim()+"'," +
					"'"+txtdiscountamount.getText().trim()+"'," +
					"'"+due+"'," +
					"'"+txtusername.getText().trim()+"'," +
					"'"+reference+"'," +
					"now(),'')";
			Dbconection.sta.executeUpdate(sqlinfo);

			for(int a=0;a<tableinsert.getRowCount();a++)		
			{
				String sqldetails="insert into tbsalesdetails(salesno,productid,productname," +
								  "unit,stockqty,salesqty,dealerprice," +
								  "tradeprice,amount,remark,username,entrytime,userip)" +
								  "values "
								  +
								  "('"+txtsalesno.getText().trim()+"'," +
								  "'"+modelinsert.getValueAt(a, 0)+"'," +
								  "'"+modelinsert.getValueAt(a, 1)+"'," +
								  "'"+modelinsert.getValueAt(a, 2)+"'," +
								  "'"+modelinsert.getValueAt(a, 3)+"'," +
								  "'"+modelinsert.getValueAt(a, 4)+"'," +
								  "'"+modelinsert.getValueAt(a, 5)+"'," +
								  "'"+modelinsert.getValueAt(a, 6)+"'," +
								  "'"+modelinsert.getValueAt(a, 7)+"'," +
								  "'"+modelinsert.getValueAt(a, 8)+"'," +
								  "'"+txtusername.getText().trim()+"'," +
								  "now()," +
								  "'')";
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
	private boolean deletework()
	{
		try
		{
			String sqlinfo="delete from tbsalesinfo where salesno='"+txtsalesno.getText().trim()+"'";
			String sqlindetails="delete from tbsalesdetails where salesno='"+txtsalesno.getText().trim()+"'";
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

	private void datasearch(String salesno)
	{
		int i;
		for(i=tableinsert.getRowCount()-1;i>=0;i--)
		{
			modelinsert.removeRow(i);
		}
		try
		{
			Dbconection.conect();
			String sql="select a.salesno,a.clientid,a.clientname,a.clienttype,a.salesdate,a.paymentprotocol," +
					"a.totalamount,a.paidamount,a.discountamount,a.dueamount,a.reference,a.username,b.productid," +
					"b.productname,b.unit,b.stockqty,b.salesqty,b.dealerprice,b.tradeprice,b.amount,"+
					"b.remark from tbsalesinfo a  "+
					"inner join tbsalesdetails b on a.salesno=b.salesno where a.salesno='"+salesno+"'";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			int a=0;
			while(rs.next())
			{
				if(a==0)
				{
					if(rs.getString("clienttype").equalsIgnoreCase("RegisterClient"))
					{
						chkregisterclient.setSelected(true);
						cmbclientid.txtSuggest.setText(rs.getString("clientid")+"#"+rs.getString("clientname"));
						txtdue.setText(rs.getString("dueamount"));
						cmbclientid.txtSuggest.setEnabled(true);
						txtdue.setEnabled(true);
					}
					else
					{
						chkunregisterclient.setSelected(true);
						cmbclientid.txtSuggest.setEnabled(false);
						txtdue.setEnabled(false);
						txtdue.setText("0.00");
						cmbclientid.txtSuggest.setText("");
					}
					txtsalesno.setText(rs.getString("salesno"));
					txtusername.setText(rs.getString("username"));
					txtpaidamount.setText(rs.getString("paidamount"));
					txtdiscountamount.setText(rs.getString("discountamount"));
					txttotalamount.setText(rs.getString("totalamount"));
					txtreference.setText(rs.getString("reference"));
					salesdate.setDate(rs.getDate("salesdate"));
					cmbpaymentpotocol.txtSuggest.setText(rs.getString("paymentprotocol"));
					a++;
				}
				modelinsert.addRow(new Object[]
						{
						rs.getString("productid"),
						rs.getString("productname"),
						rs.getString("unit"),
						rs.getString("stockqty"),
						rs.getString("salesqty"),
						rs.getString("dealerprice"),
						rs.getString("tradeprice"),
						rs.getString("amount"),
						rs.getString("remark")
						});
				findupdate=true;
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void keyaction()
	{	
		tablefind.addKeyListener(new KeyListener() {

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
				cmbproductid.txtSuggest.setText(modelinsert.getValueAt(tableinsert.getSelectedRow(), 0)+"#"+
						modelinsert.getValueAt(tableinsert.getSelectedRow(), 1));
				cmbproductid.cmbSuggest.setSelectedItem(modelinsert.getValueAt(tableinsert.getSelectedRow(), 0)+"#"+
						modelinsert.getValueAt(tableinsert.getSelectedRow(), 1));
				txtsalesqty.setText(modelinsert.getValueAt(tableinsert.getSelectedRow(), 4).toString());
				amountcal();

				modelinsert.removeRow(tableinsert.getSelectedRow());
				totalamountsum();
				initial(false);
			}
		});

		txtpaidamount.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				if(chkunregisterclient.isSelected())
				{
					discountamountcal();
				}
				if(chkregisterclient.isSelected())
				{
					dueamountcal();
				}
			}
			public void keyPressed(KeyEvent arg0) {}
		});

		txtdiscountamount.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				paidamountcaldiscount();
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		txtdue.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				paidamountcaldue();
			}
			public void keyPressed(KeyEvent arg0) {}
		});

		txtsalesqty.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				amountcal();
			}
			public void keyPressed(KeyEvent arg0) {}
		});

		txtdealerrate.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				amountcal();
			}
			public void keyPressed(KeyEvent arg0) {}
		});
	}

	private boolean chkconfirm()
	{
		if(!txtsalesno.getText().trim().isEmpty() && tableinsert.getRowCount()>=1)
		{
			return true;
		}
		return false;
	}

	private boolean confirmchkvalidation()
	{
		if(!txtsalesno.getText().trim().isEmpty()){
			if(!txtusername.getText().trim().isEmpty()){
				if(!cmbpaymentpotocol.txtSuggest.getText().isEmpty()){
					if(!txttotalamount.getText().trim().isEmpty()){
						if(!txtpaidamount.getText().trim().isEmpty())
						{
							return true;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Insert paidamount plz !","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert totalamountsum plz !","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insert Paymentprotocal plz !","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insert Username plz !","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insert SalesNo plz !","Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	private void editfalse()
	{
		cmbcatagory.setEnabled(false);;
		cmbsubcatagory.setEnabled(false);;
		txtunit.setEditable(false);
		txtstockqty.setEditable(false);
		txtdealerrate.setEditable(false);
		txttraderate.setEditable(false);
		txtamount.setEditable(false);
		txttotalamount.setEditable(false);
		txtsalesno.setEditable(false);
		txtusername.setEditable(false);
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

	private void btnaction()
	{
		chkunregisterclient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkunregisterclient.isSelected())
				{
					cmbclientid.txtSuggest.setEnabled(false);
					cmbclientid.txtSuggest.setText("");
					txtdue.setEnabled(false);
				}
			}
		});

		chkregisterclient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkregisterclient.isSelected())
				{
					txtdue.setEnabled(true);
					cmbclientid.txtSuggest.setEnabled(true);
				}
			}
		});
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
				if(chkconfirm())
				{
					if(confirmchkvalidation())
					{
						if(confirmation(findupdate?"Do you want to edit ?":"Do you want to save ?"))
						{
							if(findupdate)
							{
								if(deletework())
								{
									if(insertdata())
									{
										inserttbclear();
										salesautoid();
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
									salesautoid();
									findtbdataload();
									JOptionPane.showMessageDialog(null, "All info Saved Successfully","info",JOptionPane.INFORMATION_MESSAGE);
									refreshallwork();
								}

							}
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nothing find to save !","Error",JOptionPane.ERROR_MESSAGE);
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
				resettxt();
				if(!cmbproductid.txtSuggest.getText().isEmpty())
				{
					String proidname=cmbproductid.txtSuggest.getText();
					StringTokenizer protoken=new StringTokenizer(proidname,"#");
					String proid=protoken.nextToken();
					productwiseload(proid);
				}
			}
		});
	}
	
	private void resettxt()
	{
		txtsalesqty.setText("");
		txtamount.setText("0.00");
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
			String sql="select salesno,totalamount,salesdate from tbsalesinfo" +
					" where salesdate between '"+fdate+"' and '"+tdate+"' " +
					"order by salesdate";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				modelfind.addRow(new Object[]
						{
						rs.getString("salesno"),
						rs.getString("totalamount"),
						rs.getString("salesdate")

						});
				while(rs.next())
				{
					modelfind.addRow(new Object[]
							{
							rs.getString("salesno"),
							rs.getString("totalamount"),
							rs.getString("salesdate")

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

	private void refreshallwork()
	{
		chkunregisterclient.setSelected(true);
		cmbclientid.txtSuggest.setEnabled(false);
		cmbclientid.txtSuggest.setText("");
		txtdue.setEnabled(false);
		salesautoid();
		txtusername.setText(session.getusername());
		txtunit.setText("");
		txtsalesqty.setText("");
		txtamount.setText("0.00");
		txtdealerrate.setText("");
		txttraderate.setText("");
		txtstockqty.setText("");
		salesdate.setDate(new Date());
		cmbproductid.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		findupdate=false;
		initial(true);
		txtpaidamount.setText("");
		txttotalamount.setText("0.00");
		txtdue.setText("");
		txtdiscountamount.setText("");
		txtreference.setText("");
		cmbpaymentpotocol.txtSuggest.setText("");
		txtreference.setEditable(true);
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);

		}
		findtbdataload();		
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
			String sql="select salesno,totalamount,salesdate from tbsalesinfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				modelfind.addRow(new Object[]
						{
						rs.getString("salesno"),
						rs.getString("totalamount"),
						rs.getString("salesdate")
						});	
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}

	private void inserttbclear()
	{
		int a;
		for(a=tableinsert.getRowCount()-1;a>=0;a--)
		{
			modelinsert.removeRow(a);
		}
	}
	public void salesautoid()
	{
		try
		{
			String sql="select ifnull(max(cast(substring(salesno,locate('-',salesno)+1,length" +
					"(salesno)-locate('-',salesno)) as UNSIGNED)),0)+1 id from tbsalesinfo";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				String salesid=rs.getString("id");
				txtsalesno.setText("Sales-"+salesid);
			}
			Dbconection.con.close();

		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error",JOptionPane.ERROR_MESSAGE);
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
		panelsouth.setPreferredSize(new Dimension(1160,300));
		panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouth.setLayout(new BorderLayout());
		panelsouth.add(panelsouthcenter,BorderLayout.CENTER);
		panelsouthcenterwork();
		panelsouth.add(panelsouthnorth,BorderLayout.NORTH);
		panelsouthnorthwork();
	}

	private void panelsouthcenterwork() 
	{
		panelsouthcenter.setLayout(new BorderLayout());
		panelsouthcenter.add(panelsouthcenterwest,BorderLayout.WEST);
		panelsouthcenterwestwork();
		panelsouthcenter.add(panelsouthcentercenter,BorderLayout.CENTER);
		panelsouthcentercentertwork();
	}

	private void panelsouthcenterwestwork()
	{
		panelsouthcenterwest.setPreferredSize(new Dimension(1000,100));
		panelsouthcenterwest.setBackground(Color.LIGHT_GRAY);

		panelsouthcenterwest.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelsouthcenterwest.add(lblpaymentprotocol,c);
		lblpaymentprotocol.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));

		c.gridx=1;
		c.gridy=0;
		panelsouthcenterwest.add(cmbpaymentpotocol.cmbSuggest,c);
		cmbpaymentpotocol.cmbSuggest.setPreferredSize(new Dimension(200,30));
		cmbpaymentpotocol.v.add("Cash");
		cmbpaymentpotocol.v.add("Bikash");
		cmbpaymentpotocol.v.add("Debit Card");
		cmbpaymentpotocol.v.add("creadit Card");
		cmbpaymentpotocol.v.add("Check");

		c.gridx=2;
		c.gridy=0;
		panelsouthcenterwest.add(lbltotoalamount,c);
		lbltotoalamount.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));
		c.gridx=3;
		c.gridy=0;
		panelsouthcenterwest.add(txttotalamount,c);
		txttotalamount.setForeground(Color.blue);
		txttotalamount.setFont(font);

		c.gridx=4;
		c.gridy=0;
		panelsouthcenterwest.add(lblpaidamount,c);
		lblpaidamount.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));
		c.gridx=5;
		c.gridy=0;
		panelsouthcenterwest.add(txtpaidamount,c);

		c.gridx=0;
		c.gridy=1;
		panelsouthcenterwest.add(lbldue,c);
		lbldue.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));

		c.gridx=1;
		c.gridy=1;
		panelsouthcenterwest.add(txtdue,c);

		c.gridx=2;
		c.gridy=1;
		panelsouthcenterwest.add(lbldiscountamount,c);
		lbldiscountamount.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));
		c.gridx=3;
		c.gridy=1;
		panelsouthcenterwest.add(txtdiscountamount,c);

		c.gridx=4;
		c.gridy=1;
		panelsouthcenterwest.add(lblreference,c);
		lblreference.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 15));
		c.gridx=5;
		c.gridy=1;
		panelsouthcenterwest.add(txtreference,c);	

	}

	private void panelsouthcentercentertwork()
	{
		panelsouthcentercenter.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelsouthcentercenter.setLayout(flow);
		flow.setVgap(15);
		panelsouthcentercenter.add(btnconfirm);
		btnconfirm.setPreferredSize(new Dimension(110,35));
		btnconfirm.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelsouthcentercenter.add(btnrefreshall);
		btnrefreshall.setFont(font);
		btnrefreshall.setPreferredSize(new Dimension(110,35));
	}

	private void panelsouthnorthwork()
	{
		panelsouthnorth.setBackground(Color.LIGHT_GRAY);
		panelsouthnorth.setPreferredSize(new Dimension(1160,160));
		panelsouthnorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelsouthnorth.add(scrollinsert);
		scrollinsert.setPreferredSize(new Dimension(1140,150));
	}
	
	private void panelnorthwork()
	{
		group.add(chkregisterclient);
		group.add(chkunregisterclient);
		panelnorth.setBackground(Color.LIGHT_GRAY);
		panelnorth.setPreferredSize(new Dimension(1160,80));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelnorth.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);

		con.gridx=0;
		con.gridy=0;
		panelnorth.add(chkregisterclient,con);
		chkregisterclient.setFont(font);

		con.gridx=1;
		con.gridy=0;
		panelnorth.add(lblclientid,con);
		lblclientid.setFont(font);

		con.gridx=2;
		con.gridy=0;
		panelnorth.add(cmbclientid.cmbSuggest,con);
		cmbclientid.cmbSuggest.setPreferredSize(new Dimension(300,20));

		con.gridx=3;
		con.gridy=0;
		panelnorth.add(lblsalesno,con);
		lblsalesno.setFont(font);

		con.gridx=4;
		con.gridy=0;
		panelnorth.add(txtsalesno,con);

		con.gridx=0;
		con.gridy=1;
		panelnorth.add(chkunregisterclient,con);
		chkunregisterclient.setFont(font);

		con.gridx=1;
		con.gridy=1;
		panelnorth.add(lblusername,con);
		lblusername.setFont(font);

		con.gridx=2;
		con.gridy=1;
		panelnorth.add(txtusername,con);
		txtusername.setText(session.getusername());

		con.gridx=3;
		con.gridy=1;
		panelnorth.add(lblcurrentdate,con);
		lblcurrentdate.setFont(font);

		con.gridx=4;
		con.gridy=1;
		panelnorth.add(salesdate,con);
		salesdate.setDateFormatString("dd-MM-yyyy");
		salesdate.setDate(new Date());
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
	private void panelcenterwestwork()
	{
		panelcenterwest.setBackground(Color.LIGHT_GRAY);
		panelcenterwest.setPreferredSize(new Dimension(700,220));
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
		panelcenterwestnorth.setPreferredSize(new Dimension(700,335));

		panelcenterwestnorth.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();

		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 0, 5, 0);

		con.gridx=0;
		con.gridy=0;
		panelcenterwestnorth.add(lblproductid,con);
		lblproductid.setFont(font);

		con.gridx=1;
		con.gridy=0;
		panelcenterwestnorth.add(cmbproductid.cmbSuggest,con);
		cmbproductid.cmbSuggest.setPreferredSize(new Dimension(250,30));
		
		con.gridx=2;
		con.gridy=0;
		panelcenterwestnorth.add(lblsalesqty,con);
		lblsalesqty.setFont(font);

		con.gridx=3;
		con.gridy=0;
		panelcenterwestnorth.add(txtsalesqty,con);

		con.gridx=0;
		con.gridy=1;
		panelcenterwestnorth.add(lblcatagory,con);
		lblcatagory.setFont(font);

		con.gridx=1;
		con.gridy=1;
		panelcenterwestnorth.add(cmbcatagory,con);
		cmbcatagory.setPreferredSize(new Dimension(250,30));
		
		con.gridx=2;
		con.gridy=1;
		panelcenterwestnorth.add(lbldealerrate,con);
		lbldealerrate.setFont(font);

		con.gridx=3;
		con.gridy=1;
		panelcenterwestnorth.add(txtdealerrate,con);

		con.gridx=0;
		con.gridy=2;
		panelcenterwestnorth.add(lblsubcatagory,con);
		lblsubcatagory.setFont(font);

		con.gridx=1;
		con.gridy=2;
		panelcenterwestnorth.add(cmbsubcatagory,con);
		
		con.gridx=2;
		con.gridy=2;
		panelcenterwestnorth.add(lbltraderate,con);
		lbltraderate.setFont(font);

		con.gridx=3;
		con.gridy=2;
		panelcenterwestnorth.add(txttraderate,con);

		con.gridx=0;
		con.gridy=3;
		panelcenterwestnorth.add(lblunit,con);
		lblunit.setFont(font);

		con.gridx=1;
		con.gridy=3;
		panelcenterwestnorth.add(txtunit,con);
		
		con.gridx=2;
		con.gridy=3;
		panelcenterwestnorth.add(lblamount,con);
		lblamount.setFont(font);

		con.gridx=3;
		con.gridy=3;
		panelcenterwestnorth.add(txtamount,con);

		con.gridx=0;
		con.gridy=4;
		panelcenterwestnorth.add(lblstockqty,con);
		lblstockqty.setFont(font);

		con.gridx=1;
		con.gridy=4;
		panelcenterwestnorth.add(txtstockqty,con);

		con.gridx=2;
		con.gridy=5;
		panelcenterwestnorth.add(lblremarks,con);
		lblremarks.setFont(font);

		con.gridx=3;
		con.gridy=5;
		panelcenterwestnorth.add(scrollremarks,con);
	}
	private void panelcentercenterwork() 
	{
		panelcentercenter.setBackground(Color.LIGHT_GRAY);
		TitledBorder title=new TitledBorder(BorderFactory.createLineBorder(Color.WHITE),"Existing Invoice");
		title.setTitleColor(Color.BLACK);
		title.setTitleFont(font);
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
		panelcentercenternorth.setPreferredSize(new Dimension(460,60));
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
		panelcentercentercenter.add(scrollfind);
		scrollfind.setPreferredSize(new Dimension(440,255));
		scrollfind.setBackground(Color.blue);
	}
}
