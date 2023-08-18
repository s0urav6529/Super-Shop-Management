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
import java.nio.channels.SeekableByteChannel;
import java.sql.ResultSet;
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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.Admin.Chackpassword;
import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;

public class Catagory extends JPanel
{
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelwestsouth=new JPanel();
	JPanel panelwestcenter=new JPanel();
	JPanel panelwestnorth=new JPanel();
	JPanel panelwestcentersouth=new JPanel();
	JPanel panelwestcentercenter=new JPanel();
	JPanel panelcentersouth=new JPanel();
	JPanel panelcentercenter=new JPanel();
	JPanel panelcenternorth=new JPanel();
	JPanel panelcentercentersouth=new JPanel();
	JPanel panelcentercentercenter=new JPanel();

	SuggestText cmbsearch=new SuggestText();
	SuggestText cmbsubsearch=new SuggestText();
	SuggestText cmbcatagoryid=new SuggestText();

	JLabel lblcatagoryid=new JLabel("Catagory Id");
	JLabel lblcmbsubcatagoryid=new JLabel("Catagory Id");
	JLabel lblcatagoryname=new JLabel("Catagory Name ");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblsubsearch=new JLabel("Search:  ");
	JLabel photoofsearch1=new JLabel(new ImageIcon("img/search.png"));
	JLabel lblsearch=new JLabel("Search:  ");
	JLabel photoofsearch2=new JLabel(new ImageIcon("img/search.png"));
	JLabel lblsubcatagoryid=new JLabel("SubCatagory Id");
	JLabel lblsubcatagoryname=new JLabel("SubCatagory Name ");
	JLabel lblsubusername=new JLabel("User Name");

	JTextField txtcatagoryid=new JTextField(20);
	JTextField txtcatagoryname=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	JTextField txtsubcatagoryid=new JTextField(20);
	JTextField txtsubcatagoryname=new JTextField(20);
	JTextField txtsubusername=new JTextField(20);

	JButton btnadd=new  JButton("Add",new ImageIcon("img/add.png"));
	JButton btnedit=new  JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new  JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new  JButton("Delete",new ImageIcon("img/delete.png"));
	JButton btnsubadd=new  JButton("Add",new ImageIcon("img/add.png"));
	JButton btnsubedit=new  JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnsubrefresh=new  JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btnsubdelete=new  JButton("Delete",new ImageIcon("img/delete.png"));
	
	String colname[]={"Catagory Id","Catagory Name", "User Name"};
	Object rowname[][]={};
	DefaultTableModel catmodel=new DefaultTableModel(rowname,colname);
	JTable cattable=new JTable(catmodel);
	JScrollPane catscroll=new JScrollPane(cattable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String colname1[]={"Catagory Id","SubCatagory Id","SubCatagory Name","User Name"};
	Object rowname1[][]={};
	DefaultTableModel submodel=new DefaultTableModel(rowname1,colname1);
	JTable subtable=new JTable(submodel);
	JScrollPane subscroll=new JScrollPane(subtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	boolean isupdatecat=false;
	boolean isupdatesubcat=false;
	
	SessionBean session;
	
	public Catagory(SessionBean bean)
	{
		this.session=bean;
		setBackground(Color.white);
		comp();
		catbtnevent();//cat btn
		subcatbtnevent();//mouse and key
		catagoryevent();//cat btn
		subcatagoryevent();//mouse and key
		catinitialaction(true);//catinitial
		subcatinitialaction(true);//subcatinitial
	}
	
	private boolean catinitialaction(boolean b)
	{
		btnadd.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;
	}
	
	private boolean subcatinitialaction(boolean b)
	{
		btnsubadd.setEnabled(b);
		btnsubedit.setEnabled(!b);
		return b;
	}
	
	private void subcatsearchcatdataload(String id)
	{
		String sql="select catagoryid,catagoryname,subcatagoryid,subcatagoryname,username from tbsubcatagoryinfo where subcatagoryid='"+id+"'";
		Dbconection.conect();
		try{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				cmbcatagoryid.txtSuggest.setText(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				txtsubcatagoryid.setText(rs.getString("subcatagoryid"));
				txtsubcatagoryname.setText(rs.getString("subcatagoryname"));
				txtsubusername.setText(rs.getString("username"));
			}
			Dbconection.con.close();
			subcatinitialaction(false);
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp,"error...",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void catsearchcatdataload(String id)
	{
		String sql="select  catagoryid,catagoryname ,username from tbcatagoryinfo where catagoryid='"+id+"'";
		Dbconection.conect();
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				txtcatagoryid.setText(rs.getString("catagoryid"));
				txtcatagoryname.setText(rs.getString("catagoryname"));
				txtusername.setText(rs.getString("username"));	
			}
			Dbconection.con.close();
			catinitialaction(false); 
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp, "error loading",JOptionPane.WARNING_MESSAGE);
			
		}
	}
	public void subcatagoryevent()
	{
		subtable.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0){}
			public void mousePressed(MouseEvent arg0){}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				subcatsearchcatdataload(submodel.getValueAt(subtable.getSelectedRow(),1).toString());	
			}
		});
		
		subtable.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				subcatsearchcatdataload(submodel.getValueAt(subtable.getSelectedRow(),1).toString());
			}
			public void keyPressed(KeyEvent arg0) {}
		});
	}
	
	public void catagoryevent()
	{
		cattable.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {	}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				catsearchcatdataload(catmodel.getValueAt(cattable.getSelectedRow(),0).toString());		
			}
		});
		
		cattable.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0)
			{
				catsearchcatdataload(catmodel.getValueAt(cattable.getSelectedRow(),0).toString());	
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		cmbsearch.cmbSuggest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!cmbsearch.txtSuggest.getText().trim().isEmpty())
				{
					String idname=cmbsearch.txtSuggest.getText();
					StringTokenizer token=new StringTokenizer(idname,"#");
					catsearchcatdataload(token.nextToken());
				}
			}
		});
		
		cmbsubsearch.cmbSuggest.addActionListener(new  ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				if(!cmbsubsearch.txtSuggest.getText().trim().isEmpty())
				{
					String s=cmbsubsearch.txtSuggest.getText();
					StringTokenizer token=new StringTokenizer(s,"#");
					subcatsearchcatdataload(token.nextToken());
				}
			}
		});
	}
	
	private void subcatbtnevent()
	{
		subcatagorybtnaction();
	}
	
	public  void subautoid()
	{
		try
		{
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring(subcatagoryid," +
					   "locate('-',subcatagoryid)+1," +
					   "length(subcatagoryid)-locate('-',subcatagoryid))" +
					   " as UNSIGNED)),0)+1 id from tbsubcatagoryinfo";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			if(rs.next())
			{
				String id=rs.getString("id");
				txtsubcatagoryid.setText("Subcat-"+id);
			}
			
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp);
		}
	}

	public boolean subcatcheakvalidation()
	{	
		if(!cmbcatagoryid.txtSuggest.getText().trim().isEmpty()){
			if(!txtsubcatagoryname.getText().trim().isEmpty()){
				if(!txtsubusername.getText().trim().isEmpty())
				{
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "insert username plz !","warning...",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "insert subCatagoryname plz !","warning...",JOptionPane.WARNING_MESSAGE);		
			}			
		}		
		else
		{
			JOptionPane.showMessageDialog(null, "Select CatagoryId plz !","Warinig....",JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
	
	public boolean  subcatconfirmation(String caption)
	{
		int a=JOptionPane.showConfirmDialog(null,caption ,"confirm..",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;		
		}
		else
		{
			return false;
		}
	}
	
	public boolean subcatinsertdata()
	{
		try
		{
			String idname=cmbcatagoryid.txtSuggest.getText();
			StringTokenizer token=new StringTokenizer(idname,"#");
			String catid=token.nextToken();
			String catname=token.nextToken();
			
			String sql="insert into tbsubcatagoryinfo (catagoryid,catagoryname,subcatagoryid," +
					   "subcatagoryname,username,entrytime,userip) values ('"+catid+"','"+catname+"'," +
					   "'"+txtsubcatagoryid.getText().trim()+"','"+txtsubcatagoryname.getText().trim()+"'," +
					   "'"+txtusername.getText().trim()+"',now(),'')";
			Dbconection.conect();
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)		
		{
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public void resetsubcat()
	{
		cmbcatagoryid.txtSuggest.setText("");
		subautoid();
		txtsubcatagoryname.setText("");
		txtsubusername.setText(session.getusername());
	}
	
	public void subcatdataload()
	{
		try
		{
			int a;
			for(a=subtable.getRowCount()-1;a>=0;a--)
			{
				submodel.removeRow(a);
			}
			String sql="select catagoryid,subcatagoryid,subcatagoryname,username from tbsubcatagoryinfo order by subcatagoryname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				submodel.addRow(new Object[]
						{
								rs.getString("catagoryid"),
								rs.getString("subcatagoryid"),
								rs.getString("subcatagoryname"),
								rs.getString("username")
						});
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"error..",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void subcatcmbsearch()
	{
		try
		{
			cmbsubsearch.v.clear();
			cmbsubsearch.v.add("");
			
			Dbconection.conect();
			String sql="select subcatagoryid,subcatagoryname from tbsubcatagoryinfo order by subcatagoryname";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbsubsearch.v.add(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void subcatagorybtnaction() 
	{

		btnsubadd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(subcatcheakvalidation())
				{
					if(subcatconfirmation(isupdatesubcat?"Do you want to edit ?":"Do you want to save ?"))
					{
							if(isupdatesubcat)
							{
								if(deletedatasubcat())
								{
									if(subcatinsertdata())
									{
										subcatdataload();
										JOptionPane.showMessageDialog(null, "All info edit successfully !","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
										subcatcmbsearch();
										resetsubcat();
										subautoid();
									}
								}
							}
							else
							{
								if(subcatinsertdata())
								{
									subcatdataload();
									JOptionPane.showMessageDialog(null, "All info saved successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
									subcatcmbsearch();
									resetsubcat();
									subautoid();
								}
							}
					}	
				}
			}
		});
		
		btnsubedit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				subcatinitialaction(true);
				isupdatesubcat=true;
			}
		});
		
		btnsubrefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				subcatrefreshwork();
			}
		});
		
		btnsubdelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(subcatcheakvalidation())
				{
					if(subcatconfirmation("Sure to Delete ?"))
					{
						deletedatasubcat();
						resetsubcat();
						subcatdataload();
						JOptionPane.showMessageDialog(null, "Deleted Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						subautoid();
					}
				}
			}
		});
	}
	
	private void subcatrefreshwork()
	{
		txtsubusername.setText(session.getusername());
		txtsubcatagoryname.setText("");
		cmbcatagoryid.txtSuggest.setText("");
		cmbsubsearch.txtSuggest.setText("");
		subcatdataload();
		subcatinitialaction(true);
		subautoid();
		subcatcmbsearch();
	}
	
	private boolean deletedatasubcat()
	{
		try
		{
			Dbconection.conect();
			String sql="delete from tbsubcatagoryinfo where subcatagoryid='"+txtsubcatagoryid.getText().trim()+"'";
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp ,"Error..",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	private void catbtnevent()
	{
		catgorybtnaction();
	}
	
	public boolean catcheakvalidation()
	{
		if(!txtcatagoryname.getText().trim().isEmpty()){
			if(!txtusername.getText().trim().isEmpty())
			{
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "insert username plz...!","warning...",JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "insert Catagoryname plz...!","warning...",JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}

	public boolean catconfirmation(String caption )
	{
		int a=JOptionPane.showConfirmDialog(null,caption ,"confirm...",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	
	public boolean insertdata()
	{
		try
		{
			String sql="insert into tbcatagoryinfo(catagoryid,catagoryname,username,entrytime,userip)" 
						+"values('"+txtcatagoryid.getText().trim()+"','"+txtcatagoryname.getText().trim()+"','"+txtusername.getText().trim()+"',now(),'') ";
			Dbconection.conect();
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
		
	}
	
	public void resetcat()
	{
		txtcatagoryid.setText("");
		txtcatagoryname.setText("");
		txtusername.setText(session.getusername());
		isupdatecat=false;
	}
	
	public void catdataload()
	{
		try
		{
			int a;
			for(a=cattable.getRowCount()-1;a>=0;a--)
			{
				catmodel.removeRow(a);
				
			}
			String sql="select catagoryid,catagoryname,username from tbcatagoryinfo order by catagoryname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				catmodel.addRow(new Object[]
						{
								rs.getString("catagoryid"),
								rs.getString("catagoryname"),
								rs.getString("username")
						});
			}
			
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	public void catcmbsearch()
	{
		try
		{
			cmbsearch.v.clear();
			cmbsearch.v.add("");
			cmbcatagoryid.v.clear();
			cmbcatagoryid.v.add("");
			
			String sql="select catagoryid,catagoryname from tbcatagoryinfo order by catagoryname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbsearch.v.add(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
				cmbcatagoryid.v.add(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		
	}
	
	public void catgorybtnaction()
	{
		btnadd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(catcheakvalidation())
				{
					if(catconfirmation(isupdatecat?"Do you want to edit ?":"Do you want to save ?"))
					{
							if(isupdatecat)
								{
									if(deletedatacat())
									{
										if(insertdata())
										{
											catdataload();
											JOptionPane.showMessageDialog(null, "All info Edit successfully","information....!",JOptionPane.INFORMATION_MESSAGE);
											catcmbsearch();
											resetcat();
											catautoid();
										}
									}
								}
							else
							{
								if(insertdata())
								{
									catdataload();
									JOptionPane.showMessageDialog(null, "All info saved successfully..!","information....",JOptionPane.INFORMATION_MESSAGE);
									catcmbsearch();
									resetcat();
									catautoid();
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
				catinitialaction(true);
				isupdatecat=true;
			}
		});
		btnrefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				catrefreshwork();
			}
		});
		btndelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(catcheakvalidation())
				{
					if(catconfirmation("Sure to Delete ?"))
					{
						deletedatacat();
						resetcat();
						catdataload();
						JOptionPane.showMessageDialog(null, "Deleted Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						catautoid();
					}
				}
			}
		});
	}
	
	private void catrefreshwork()
	{
		cmbsearch.txtSuggest.setText("");
		txtcatagoryname.setText("");
		txtusername.setText(session.getusername());
		catautoid();
		catdataload();
		catinitialaction(true);
	}
	
	private boolean deletedatacat()
	{
		try
		{
			Dbconection.conect();
			String sql="delete from tbcatagoryinfo where catagoryid='"+txtcatagoryid.getText().trim()+"'";
			Dbconection.sta.executeUpdate(sql);
			Dbconection.con.close();
			return true;
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
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
	
	public  void catautoid()
	{
		try{
			
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring(catagoryid," +
					   "locate('-',catagoryid)+1," +
					   "length(catagoryid)-locate('-',catagoryid))" +
					   " as UNSIGNED)),0)+1 id from tbcatagoryinfo";
			
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			if(rs.next())
			{
				String id=rs.getString("id");
				txtcatagoryid.setText("cat-"+id);
			}
			
			Dbconection.con.close();	
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, "exp");
		}
	}
	
	private void panelcenterwork() 
	{
		panelcenter.setLayout(new BorderLayout());
		panelcenter.setBackground(Color.LIGHT_GRAY);
		panelcenter.add(panelcenternorth, BorderLayout.NORTH);
		panelcenternorthwork();
		panelcenter.add(panelcentercenter, BorderLayout.CENTER);
		panelcentersouthwork();
		panelcenter.add(panelcentersouth, BorderLayout.SOUTH);
		panelcentercenterwork();
	}

	private void panelcentercenterwork() 
	{
		panelcentercenter.setLayout(new BorderLayout());
		panelcentercenter.setBackground(Color.LIGHT_GRAY);
		panelcentercenter.add(panelcentercentercenter, BorderLayout.CENTER);
		panelcentercenter.add(panelcentercentersouth, BorderLayout.SOUTH);
		panelcentercentersouthwork();
		panelcentercentercenterwork();
	}
	
	private void panelcentercentercenterwork()
	{
		panelcentercentercenter.setBackground(Color.LIGHT_GRAY);
		TitledBorder title=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Sub Catagory");
		title.setTitleColor(Color.BLACK);
		title.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		title.setTitleJustification(TitledBorder.LEFT);
		panelcentercentercenter.setBorder(title);
		panelcentercentercenter.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();

		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelcentercentercenter.add(lblcmbsubcatagoryid,con);
		lblcmbsubcatagoryid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		
		con.gridx=1;
		con.gridy=0;
		panelcentercentercenter.add(cmbcatagoryid.cmbSuggest,con);

		con.gridx=0;
		con.gridy=1;
		panelcentercentercenter.add(lblsubcatagoryid,con);
		lblsubcatagoryid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=1;
		panelcentercentercenter.add(txtsubcatagoryid,con);
		txtsubcatagoryid.setEditable(false);
		
		con.gridx=0;
		con.gridy=2;
		panelcentercentercenter.add(lblsubcatagoryname,con);
		lblsubcatagoryname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=2;
		panelcentercentercenter.add(txtsubcatagoryname,con);

		con.gridx=0;
		con.gridy=3;
		panelcentercentercenter.add(lblsubusername,con);
		lblsubusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=3;
		panelcentercentercenter.add(txtsubusername,con);
		txtsubusername.setEditable(false);
		txtsubusername.setText(session.getusername());
	}
	
	private void panelcentercentersouthwork()
	{
		panelcentercentersouth.setPreferredSize(new Dimension(580,60));
		panelcentercentersouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelcentercentersouth.setBackground(Color.LIGHT_GRAY);
		panelcentercentersouth.setLayout(new FlowLayout());
		panelcentercentersouth.add(btnsubadd);
		btnsubadd.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentercentersouth.add(btnsubedit);
		btnsubedit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentercentersouth.add(btnsubrefresh);
		btnsubrefresh.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentercentersouth.add(btnsubdelete);
		btnsubdelete.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	}

	private void panelcentersouthwork() 
	{
		panelcentersouth.setPreferredSize(new Dimension(580,350));
		panelcentersouth.setBackground(Color.LIGHT_GRAY);
		panelcentersouth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelcentersouth.setLayout(flow);
		panelcentersouth.add(subscroll);
		subtable.getTableHeader().setReorderingAllowed(false);
		subscroll.setPreferredSize(new Dimension(500,300));	
	}

	private void panelcenternorthwork()
	{
		panelcenternorth.setPreferredSize(new Dimension(580,80));
		panelcenternorth.setBackground(Color.LIGHT_GRAY);
		panelcenternorth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		FlowLayout flow=new FlowLayout();
		panelcenternorth.setLayout(flow);
		flow.setVgap(20);
		panelcenternorth.add(lblsubsearch);
		lblsubsearch.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		panelcenternorth.add(photoofsearch2);
		panelcenternorth.add(cmbsubsearch.cmbSuggest);
		cmbsubsearch.cmbSuggest.setPreferredSize(new Dimension(300,30));
	}

	private void panelwestwork() 
	{
		panelwest.setLayout(new BorderLayout());
		panelwest.setBackground(Color.LIGHT_GRAY);
		panelwest.setPreferredSize(new Dimension(580,740));
		panelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwest.add(panelwestnorth, BorderLayout.NORTH);
		panelwestnorthwork();
		panelwest.add(panelwestcenter, BorderLayout.CENTER);
		panelwestcenterwork();
		panelwest.add(panelwestsouth, BorderLayout.SOUTH);
		panelwestsouthwork();	
	}

	private void panelwestcenterwork()
	{
		panelwestcenter.setLayout(new BorderLayout());
		panelwestcenter.setBackground(Color.LIGHT_GRAY);
		panelwestcenter.add(panelwestcentersouth,BorderLayout.SOUTH);
		panelwestcentersouthwork();
		panelwestcenter.add(panelwestcentercenter,BorderLayout.CENTER);
		panelwestcentercenterwork();	
	}
	
	
	
	private void panelwestcentercenterwork() 
	{
		panelwestcentercenter.setBackground(Color.LIGHT_GRAY);
		TitledBorder title=new TitledBorder(BorderFactory.createRaisedBevelBorder(),"Catagory");
		title.setTitleColor(Color.BLACK);
		title.setTitleFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		title.setTitleJustification(TitledBorder.LEFT);
		panelwestcentercenter.setBorder(title);
		panelwestcentercenter.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
	
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelwestcentercenter.add(lblcatagoryid,con);
		lblcatagoryid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=0;
		panelwestcentercenter.add(txtcatagoryid,con);
		txtcatagoryid.setEditable(false);
		
		con.gridx=0;
		con.gridy=1;
		panelwestcentercenter.add(lblcatagoryname,con);
		lblcatagoryname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=1;
		panelwestcentercenter.add(txtcatagoryname,con);
		
		con.gridx=0;
		con.gridy=2;
		panelwestcentercenter.add(lblusername,con);
		lblusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=2;
		panelwestcentercenter.add(txtusername,con);
		txtusername.setEditable(false);
		txtusername.setText(session.getusername());	
	}
	
	private void panelwestcentersouthwork()
	{ 
		panelwestcentersouth.setBackground(Color.LIGHT_GRAY);
		panelwestcentersouth.setPreferredSize(new Dimension(580,60));
		panelwestcentersouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwestcentersouth.setLayout(new FlowLayout());
		panelwestcentersouth.add(btnadd);
		btnadd.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestcentersouth.add(btnedit);
		btnedit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestcentersouth.add(btnrefresh);
		btnrefresh.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelwestcentersouth.add(btndelete);
		btndelete.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));		
	}
	
	private void panelwestsouthwork() 
	{
		panelwestsouth.setBackground(Color.LIGHT_GRAY);
		panelwestsouth.setPreferredSize(new Dimension(580,350));
		panelwestsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		panelwestsouth.setLayout(flow);
		panelwestsouth.add(catscroll);
		cattable.getTableHeader().setReorderingAllowed(false);
		catscroll.setPreferredSize(new Dimension(500,300));		
	}
	
	private void panelwestnorthwork() 
	{
		panelwestnorth.setBackground(Color.LIGHT_GRAY);
		panelwestnorth.setPreferredSize(new Dimension(580,80));
		panelwestnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		flow.setVgap(20);
		panelwestnorth.setLayout(flow);
		panelwestnorth.add(lblsearch);
		lblsearch.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		panelwestnorth.add(photoofsearch1);
		panelwestnorth.add(cmbsearch.cmbSuggest);
		cmbsearch.cmbSuggest.setPreferredSize(new Dimension(300,30));	
	}
}