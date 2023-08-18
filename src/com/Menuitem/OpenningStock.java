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
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class OpenningStock extends JPanel 
{
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelwestsouth=new JPanel();
	JPanel panelwestcenter=new JPanel();
	JPanel panelwestnorth=new JPanel();
	
	JLabel lblsearch=new JLabel("Search:  ");
	JLabel photoofsearch=new JLabel(new ImageIcon("img/search.png"));
	JLabel lblstockid=new JLabel("Stock Id");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Sub catagory");
	JLabel lblproduct=new JLabel("Product");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstockquentity=new JLabel("Stock Quentity");
	JLabel lblamount=new JLabel("Amount");
	JLabel lbldealerrate=new JLabel("Dealer Price");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblstockdate=new JLabel("Stock Date");
	
	JTextField txtstockid=new JTextField(20);
	JTextField txtunit=new JTextField(20);
	JTextField txtdealerrate=new JTextField(20);
	JTextField txtamount=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txtstockquentity=new JTextField(20);

	JButton btnadd=new  JButton("Add",new ImageIcon("img/add.png"));
	JButton btnedit=new  JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new  JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new  JButton("Delete",new ImageIcon("img/delete.png"));
	
	SuggestText cmbsearch=new SuggestText();
	
	SuggestText cmbproduct=new SuggestText();
	JComboBox cmbcatagory=new JComboBox();
	JComboBox cmbsubcatagory=new JComboBox();
	JComboBox cmbsuppliername=new JComboBox();

	JDateChooser stockdate=new JDateChooser();
	String colname[]={"Stock Id","Stock Quentity", "Stock Date"};
	Object rowname[][]={};
	DefaultTableModel model=new DefaultTableModel(rowname,colname);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	boolean isupdate=false;
	SessionBean session;
	DecimalFormat dformet=new DecimalFormat("#0.00");
	
	boolean update =false;
	
	public OpenningStock(SessionBean bean)
	{
		this.session=bean;
		comp();
		btnaction();
		openinitial(true);
		keyaction();
		mousekeyevent();
		editfalse();
		txtamount.setText("0.00");	
	}
	
	private boolean openinitial(boolean b)
	{
		btnadd.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;
	}
	
	private void datasearch(String id)
	{
		try
		{
			String sql="select Stockid,productid,productname,catagoryid,catagoryname,subcatagoryid,subcatagoryname,unit,stockquentity,dealerrate,amount," +
					"stockdate,supplierid,suppliername,username from tbopeningstockinfo  where stockid='"+id+"'";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbproduct.txtSuggest.setText(rs.getString("productid")+"#"+rs.getString("productname"));
				cmbproduct.cmbSuggest.setSelectedItem(rs.getString("productid")+"#"+rs.getString("productname"));
				txtstockid.setText(rs.getString("Stockid"));
				txtstockquentity.setText(rs.getString("stockquentity"));
				txtusername.setText(rs.getString("username"));
				txtamount.setText(rs.getString("amount"));
				stockdate.setDate(rs.getDate("stockdate"));
			}
			
			Dbconection.con.close();
			openinitial(false);
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error..",JOptionPane.ERROR_MESSAGE);
		}
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

	private void productwiseload(String productid)
	{
		try
		{
			cmbcatagory.removeAllItems();
			cmbsubcatagory.removeAllItems();
			cmbsuppliername.removeAllItems();
			txtunit.setText("");
			txtdealerrate.setText("");
			
			Dbconection.conect();
			String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,supplierid," +
					   " suppliername,unit,dealerprice" +
					   " from tbproductinfo  where productid like '"+productid+"'";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbcatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbsubcatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
				cmbsuppliername.addItem(rs.getString("supplierid")+"#"+rs.getString("suppliername"));
				txtunit.setText(rs.getString("unit"));
				txtdealerrate.setText(rs.getString("dealerprice"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error...",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void editfalse()
	{
		cmbcatagory.setEnabled(false);
		cmbsubcatagory.setEnabled(false);
		cmbsuppliername.setEnabled(false);
		txtunit.setEditable(false);
		txtamount.setEditable(false);
		txtdealerrate.setEditable(false);
	}
	
	public void productdataload()
	{
		try
		{
			cmbproduct.v.clear();
			cmbproduct.v.add("");
			
			cmbcatagory.removeAllItems();
			cmbsubcatagory.removeAllItems();
			cmbsuppliername.removeAllItems();
			txtunit.setText("");
			txtdealerrate.setText("");
			
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
	
	private void keyaction()
	{
		txtstockquentity.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				amountcalculation();
			}
			public void keyPressed(KeyEvent arg0) {}
		} );
		
		txtdealerrate.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				amountcalculation();
			}
			public void keyPressed(KeyEvent arg0) {}
		} );

	}
	
	private void amountcalculation()
	{
		double qty,dealer,amount;
		
		qty=Double.parseDouble(txtstockquentity.getText().trim().isEmpty()?"0":txtstockquentity.getText().trim());
		dealer=Double.parseDouble(txtdealerrate.getText().trim().isEmpty()?"0":txtdealerrate.getText().trim());
		amount=qty*dealer;
		txtamount.setText(dformet.format(amount));
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

		String supidname=cmbsuppliername.getSelectedItem().toString();
		StringTokenizer suptoken=new StringTokenizer(supidname,"#");
		String supid=suptoken.nextToken();
		String supname=suptoken.nextToken();
		
		
		String stdate=new SimpleDateFormat("yyyy-MM-dd").format(stockdate.getDate());
		
		Dbconection.conect();
		String sql="insert into tbopeningstockinfo (StockId,Productid,productname,Catagoryid,catagoryname,subcatagoryid,subcatagoryname,Unit,StockQuentity,dealerrate,Amount,StockDate,supplierid,SupplierName,UserName,EntryTime,UserIp)"+
				"values('"+txtstockid.getText().trim()+"','"+proid+"','"+proname+"','"+catid+"','"+catname+"','"+subcatid+"','"+subcatname+"','"+txtunit.getText().trim()+"','"+txtstockquentity.getText().trim()+"'," +
						"'"+txtdealerrate.getText().trim()+"','"+txtamount.getText().trim()+"','"+stdate+"','"+supid+"','"+supname+"','"+txtusername.getText().trim()+"',now(),'')";
		try
		{
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp);
		}
		
		return false;
	}
	
	public void tbdataload()
	{
		try
		{
			int a;
			for(a=table.getRowCount()-1;a>=0;a--)
			{
				model.removeRow(a);
				
			}
			Dbconection.conect();
			String sql="select stockid,StockQuentity,stockdate from tbopeningstockinfo order by productname ";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				model.addRow(new Object[]
						{
							rs.getString("stockid"),
							rs.getString("StockQuentity"),
							rs.getString("stockdate")
							
						});
			}
			
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp, "Error....",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean deletedata()
	{
		try
		{
			Dbconection.conect();
			String sql="delete from tbopeningstockinfo where stockid='"+txtstockid.getText().trim()+"'";
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
	
	public void cmbsearch()
	{
		try{
			cmbsearch.v.clear();
			cmbsearch.v.add(""); 
			
			String sql="select stockid,productname from tbopeningstockinfo order by productname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbsearch.v.add(rs.getString("stockid")+"#"+rs.getString("productname"));
				
			}
			Dbconection.con.close();
			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void reset()
	{
		cmbsearch.txtSuggest.setText("");
		cmbproduct.txtSuggest.setText("");
		cmbcatagory.removeAllItems();
		cmbsubcatagory.removeAllItems();
		cmbsuppliername.removeAllItems();
		txtunit.setText("");
		txtstockquentity.setText("");
		txtdealerrate.setText("");
		txtamount.setText("0.00");
		stockdate.setDate(new Date());
		txtusername.setText(session.getusername());
		
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
	private void btnaction() 
	{
		btnadd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkvalidation())
				{
					if(confirmation(isupdate?"Do you want to Edit ?":"Do you want to Save ?"))
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
									stockautoid();
									
								}
							}
							isupdate=false;
						}
						else
						{
							if(insertdata())
							{
								tbdataload();
								reset();
								JOptionPane.showMessageDialog(null, "All info Save successfully !","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
								cmbsearch();
								stockautoid();
							}
						}
					}			
				}	
			}
			}
		);
		btnedit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				isupdate=true;
				openinitial(true);
			}
		});
		
		btnrefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				reset();
				stockautoid();
				openinitial(true);
				
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
						deletedata();
						tbdataload();
						JOptionPane.showMessageDialog(null, "All info deleted successfully","Info",JOptionPane.INFORMATION_MESSAGE);
						stockautoid();
						reset();
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
	
	public void stockautoid()
	{
		try
		{
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring" +
				"(StockId,locate('-',StockId)+1,length(StockId)-locate('-',StockId)) " +
				"as UNSIGNED)),0)+1 id from tbopeningstockinfo";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				String id=rs.getString("id");
				txtstockid.setText("Stock-"+id);
			}
		}
		
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error..",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	private boolean chkvalidation()
	{
		if(!txtstockid.getText().isEmpty()){
			if(!cmbproduct.txtSuggest.getText().isEmpty()){
				if(!txtunit.getText().isEmpty()){
					if(!txtstockquentity.getText().isEmpty()){
						if(!txtdealerrate.getText().isEmpty()){
							if(!txtamount.getText().isEmpty()){
								if(!txtusername.getText().isEmpty())
								{	
									return true;	
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Select Username quentity plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Select Amount  plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Select dealer quentity plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Select Stock quentity plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Select Unit plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Select product plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Select Stock id plz..", "Info",JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}
	
	private void comp()
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
		panelcenter.setBorder(BorderFactory.createSoftBevelBorder(5));
		FlowLayout flow=new FlowLayout();
		panelcenter.setLayout(flow);
		panelcenter.add(scroll);
		table.getTableHeader().setReorderingAllowed(false);
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
		panelwestcenter.setBorder(BorderFactory.createLoweredBevelBorder());
		panelwestcenter.setPreferredSize(new Dimension(400,540));
		panelwestcenter.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();

		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelwestcenter.add(lblstockid,con);
		lblstockid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=0;
		panelwestcenter.add(txtstockid,con);
		txtstockid.setEditable(false);
		
		con.gridx=0;
		con.gridy=1;
		panelwestcenter.add(lblproduct,con);
		lblcatagory.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=1;
		panelwestcenter.add(cmbproduct.cmbSuggest,con);
		cmbproduct.cmbSuggest.setPreferredSize(new Dimension(300,30));
		
		con.gridx=0;
		con.gridy=2;
		panelwestcenter.add(lblcatagory,con);
		lblsubcatagory.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=2;
		panelwestcenter.add(cmbcatagory,con);

		con.gridx=0;
		con.gridy=3;
		panelwestcenter.add(lblsubcatagory,con);
		lblproduct.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=3;
		panelwestcenter.add(cmbsubcatagory,con);

		con.gridx=0;
		con.gridy=4;
		panelwestcenter.add(lblunit,con);
		lblunit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=4;
		panelwestcenter.add(txtunit,con);
		txtunit.setEditable(false);

		con.gridx=0;
		con.gridy=5;
		panelwestcenter.add(lblstockquentity,con);
		lblstockquentity.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=5;
		panelwestcenter.add(txtstockquentity,con);
		
		con.gridx=0;
		con.gridy=6;
		panelwestcenter.add(lbldealerrate,con);
		lbldealerrate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=6;
		panelwestcenter.add(txtdealerrate,con);

		con.gridx=0;
		con.gridy=7;
		panelwestcenter.add(lblamount,con);
		lblamount.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=7;
		panelwestcenter.add(txtamount,con);
		
		con.gridx=0;
		con.gridy=8;
		panelwestcenter.add(lblstockdate,con);
		lblstockdate.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=8;
		panelwestcenter.add(stockdate,con);
		stockdate.setDateFormatString("dd-MM-yyyy");
		stockdate.setDate(new Date());
		
		con.gridx=0;
		con.gridy=9;
		panelwestcenter.add(lblsuppliername,con);
		lblsuppliername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=9;
		panelwestcenter.add(cmbsuppliername,con);

		con.gridx=0;
		con.gridy=10;
		panelwestcenter.add(lblusername,con);
		lblusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=10;
		panelwestcenter.add(txtusername,con);
		txtusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		txtusername.setText(session.getusername());
		txtusername.setEditable(false);	
		
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
