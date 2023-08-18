package com.Menuitem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class Clintinfo extends JPanel
{
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	
	JPanel panelwestsouth=new JPanel();
	JPanel panelwestcenter=new JPanel();
	JPanel panelwestnorth=new JPanel();
	JPanel panelwestcenterwest=new JPanel();
	JPanel panelwestcentercenter=new JPanel();
	JPanel panelwestcentercenternorth=new JPanel();
	JPanel panelwestcentercentercenter=new JPanel();
	
	JDateChooser dateofbirth=new JDateChooser();
	JDateChooser dateofjoin=new JDateChooser();
	
	JLabel photo=new JLabel();
	JLabel lblsearch=new JLabel("Search:  ");
	JLabel photoofsearch=new JLabel(new ImageIcon("img/search.png"));
	JLabel lblclientid=new JLabel("Client Id");
	JLabel lblclientname=new JLabel("Client Name");
	JLabel lblgender=new JLabel("Gender");
	JLabel lblfathername=new JLabel("Father's Name");
	JLabel lblmothername=new JLabel("Mother's Name");
	JLabel lblreligion=new JLabel("Religion");
	JLabel lbldateofbirth=new JLabel("Date Of Birth");
	JLabel lbldateofjoin=new JLabel("Date Of Join");
	JLabel lblmobileno=new JLabel("Mobile No");
	JLabel lbladdress=new JLabel("Address");
	JLabel lblemail=new JLabel("Email");
	JLabel lblnationalid=new JLabel("National Id");
	JLabel lblnationality=new JLabel("Nationality");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblreferencby=new JLabel("Reference By");
	
	JTextField txtclientid=new JTextField(20);
	JTextField txtclientname=new JTextField(20);
	JTextField txtfathername=new JTextField(20);
	JTextField txtmothername=new JTextField(20);
	JTextField txtmobileno=new JTextField(20);
	JTextField txtemail=new JTextField(20);
	JTextField txtnationalid=new JTextField(20);
	JTextField txtnationality=new JTextField(20);
	JTextField txtusername=new JTextField(20);
	
	JTextArea txtaddrerss=new JTextArea(5,3);
	JScrollPane scoll=new JScrollPane(txtaddrerss,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	

	JButton btnadd=new  JButton("Add",new ImageIcon("img/add.png"));
	JButton btnedit=new  JButton("Edit",new ImageIcon("img/edit.png"));
	JButton btnrefresh=new  JButton("Refresh",new ImageIcon("img/refresh.png"));
	JButton btndelete=new  JButton("Delete",new ImageIcon("img/delete.png"));
	JButton btnupload=new JButton("Upload",new ImageIcon("img/Upload.png"));
	
	
	SuggestText cmbsearch=new SuggestText();
	SuggestText cmbgender=new SuggestText();	
	SuggestText cmbreligion=new SuggestText();
	
	SuggestText cmbreferenceby=new SuggestText();
	
	

	String colname[]={"Client Id","Clint Name", "Mobile Number","Email"};
	Object rowname[][]={};
	DefaultTableModel clientmodel=new DefaultTableModel(rowname,colname);
	JTable clienttable=new JTable(clientmodel);
	JScrollPane clientscroll=new JScrollPane(clienttable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	boolean isupdate=false;
	boolean isdelete=false;
	int flag=0;
	
	JFileChooser filechooser=null;
	File file=null;	
	
	SessionBean session;
	public Clintinfo(SessionBean bean)
	
	{
		this.session=bean;
		
		panelwork();
		btnaction();
		clientinitialze(true);
		mousekeyevent();
	}
	private void searchdataload(String id)
	{
		try
		{
			Dbconection.conect();
			
			String sql="select clientid,clientname,gender,fathername,mothername,religion,birthdate,joindate," +
					"mobileno,address,emailid,nationalid,nationality,username,referencebyid,referencebyname,picture from tbclientinfo where  clientid='"+id+"'";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			if(rs.next())
			{
				txtclientid.setText(rs.getString("clientid"));
				txtclientname.setText(rs.getString("clientname"));
				cmbgender.txtSuggest.setText(rs.getString("gender"));
				txtfathername.setText(rs.getString("fathername"));
				txtmothername.setText(rs.getString("mothername"));
				cmbreligion.txtSuggest.setText(rs.getString("religion"));
				dateofbirth.setDate(rs.getDate("birthdate"));
				dateofjoin.setDate(rs.getDate("joindate"));
				txtmobileno.setText(rs.getString("mobileno"));
				txtaddrerss.setText(rs.getString("address"));
				txtemail.setText(rs.getString("emailid"));
				txtnationalid.setText(rs.getString("nationalid"));
				txtnationality.setText(rs.getString("nationality"));
				txtusername.setText(rs.getString("username"));
				cmbreferenceby.txtSuggest.setText(rs.getString("referencebyid")+"#"+rs.getString("referencebyname"));
				
				if(!rs.getString("picture").toString().equalsIgnoreCase("0"))
				{
					Image img=Toolkit.getDefaultToolkit().getImage("F:/softwareimage/clientimage/"+txtclientid.getText().toString()+".jpg");
					Image resize=img.getScaledInstance(photo.getWidth(), photo.getHeight(), img.SCALE_DEFAULT);
					
					photo.setIcon(new ImageIcon(resize));
				}
				else
				{
					photo.setIcon(new ImageIcon(""));
				}	
			}
			Dbconection.con.close();
			clientinitialze(false);
			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error..",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void mousekeyevent()
	{
		 clienttable.addMouseListener(new MouseListener() 
		 {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0)
			{
				searchdataload(clientmodel.getValueAt(clienttable.getSelectedRow(),0).toString());
				
			}
		});
		 clienttable.addKeyListener(new KeyListener()
		 {
			 
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) 
			{
				searchdataload(clientmodel.getValueAt(clienttable.getSelectedRow(), 0).toString());
				
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
					searchdataload(token.nextToken());
				}
				
			}
		});
		
	}
	private  boolean clientinitialze(boolean b)
	{
		
		btnadd.setEnabled(b);
		btnedit.setEnabled(!b);
		return b;
		
		
		
	}
	private void imagedelete()
	{
		String imgdestination="F://softwareimage//clientimage//"+txtclientid.getText()+".jpg";
		File file=new File(imgdestination);
		if(file.exists())
		{
			file.delete();
		}
		
	}
	private boolean delete()
	{
		try
		{
			Dbconection.conect();
			String sql="delete from tbclientinfo where  clientid='"+txtclientid.getText().trim()+"'";
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
	
	
	
	public void tbdataload()
	{
		try
		{
			int a;
			for(a=clienttable.getRowCount()-1;a>=0;a--)
			{
				clientmodel.removeRow(a);
				
			}
			
			
			Dbconection.conect();
			String sql="select clientid,clientname,mobileno,emailid from tbclientinfo order by clientname ";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				clientmodel.addRow(new Object[]
						{
							rs.getString("clientid"),
							rs.getString("clientname"),
							rs.getString("mobileno"),
							rs.getString("emailid")
						});
				
			}
			
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp, "Error....",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean insertdata()
	{
		
	       String referenceby=cmbreferenceby.txtSuggest.getText();
	       StringTokenizer token=new StringTokenizer(referenceby,"#");
	       String rebyid=token.nextToken();
	       String rebyname=token.nextToken();
		
		String birthdate=new SimpleDateFormat("yyyy-MM-dd").format(dateofbirth.getDate());
		String joindate=new SimpleDateFormat("yyyy-MM-dd").format(dateofjoin.getDate());
			
		String sql="insert into tbclientinfo(ClientId,clientname,Gender,FatherName,MotherName,Religion,Birthdate,Joindate,Mobileno,Address,picture,EmailId,NationalId,Nationality,UserName,referencebyid,referencebyname,entrytime,userip)" +
				   " values ('"+txtclientid.getText().trim()+"','"+txtclientname.getText().trim()+"','"+cmbgender.txtSuggest.getText().trim()+"','"+txtfathername.getText().trim()+"','"+txtmothername.getText().trim()+"'," +
				   "'"+cmbreligion.txtSuggest.getText().trim()+"','"+birthdate+"','"+joindate+"','"+txtmobileno.getText().trim()+"','"+txtaddrerss.getText().trim()+"','"+txtclientid.getText().trim()+".jpg','"+txtemail.getText().trim()+"'," +
				   "'"+txtnationalid.getText().trim()+"','"+txtnationality.getText().trim()+"','"+txtusername.getText().trim()+"'," +
				   "'"+rebyid+"','"+rebyname+"',now(),'')";
			try
			{
				
				Dbconection.conect();
				Dbconection.sta.executeUpdate(sql);
						
			
				if(flag==1)
				{
					
					BufferedImage biffer=ImageIO.read(file);
					
					String destination="F:\\softwareimage\\clientimage";
					
					File folderdestination=new File(destination);
					
					if(!folderdestination.isDirectory())
					{
						folderdestination.mkdirs();
						
					}
					
					
					String imgdestination=destination+"//"+txtclientid.getText().trim()+".jpg";
					
					File imagedestination=new File(imgdestination);
					
					if(!imagedestination.exists())
					{
						imagedestination.delete();
					}
					
					
					ImageIO.write(biffer, "jpg", imagedestination);
					
				}
					Dbconection.con.close();	
					return true;
					
			
			}
			catch(Exception exp)
			{
				JOptionPane.showMessageDialog(null,exp, "Error..",JOptionPane.ERROR_MESSAGE);
			}
			return false;
	}
	
	
	
	private void uploadaction()
	{
		
		filechooser =new JFileChooser();
		filechooser.setDialogType(filechooser.OPEN_DIALOG);
		
		FileNameExtensionFilter filter=new FileNameExtensionFilter("image", "jpg","png","gif");
		filechooser.setFileFilter(filter);
		filechooser.setDialogTitle("Image selection");
		
		
		filechooser.showOpenDialog(this);
		
		file=filechooser.getSelectedFile();
		
		if(file!=null)
		{
			Image img=Toolkit.getDefaultToolkit().getImage(file.getPath());
			
			Image resize=img.getScaledInstance(photo.getWidth(),photo.getHeight() ,img.SCALE_DEFAULT );
			
			photo.setIcon(new ImageIcon(resize));
			flag=1;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Image/file not selected...!","Warning",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	private void btnaction()
	{
		
		btnupload.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				
				uploadaction();
				
				
			}
		});
		
		
		btnadd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkvalidation())
				{
					if(confirmation(isupdate?"Do you want to Edit ?":"Do you want to save ?"))
					{
						if(isupdate)
						{
							if(delete())
							{
								if(insertdata())
								{
									tbdataload();
									JOptionPane.showMessageDialog(null, "All information edited successfully !","Info...",JOptionPane.INFORMATION_MESSAGE);
									cmbsearch();
									reset();
									clientautoid();
								}
							}
						}
						else
						{

							if(insertdata())
							{
								tbdataload();
								reset();
								JOptionPane.showMessageDialog(null, "All information saved successfully !","Info...",JOptionPane.INFORMATION_MESSAGE);
								cmbsearch();
								clientautoid();
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
				isupdate=true;
				clientinitialze(true);	
			}
		});
		btnrefresh.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{

				clientinitialze(true);
				reset();
				clientautoid();
			}
		});
		btndelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				isdelete=true;
				
				if(chkvalidation())
				{
					if(confirmation("Do you want to Delete ?"))
					{
						if(delete())
						{
							reset();
							tbdataload();
							JOptionPane.showMessageDialog(null, "All information deleted successfully","Info...",JOptionPane.INFORMATION_MESSAGE);
							clientautoid();
						}	
					}
					
				}
			}
		});
		
		
	}
	public void cmbsearch()
	{
		try
		{
			cmbsearch.v.clear();
			cmbsearch.v.add("");
			
			
			Dbconection.conect();
			String sql="select ClientId,clientname from tbclientinfo order by clientname";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			
			while(rs.next())
			{
				cmbsearch.v.add(rs.getString("ClientId")+"#"+rs.getString("clientname"));
				
			}
			Dbconection.con.close();
			
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp, "Error..",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void reset()
	{
		cmbsearch.txtSuggest.setText("");
		txtclientid.setText("");
		txtclientname.setText("");
		cmbgender.txtSuggest.setText("");
		txtfathername.setText("");
		txtmothername.setText("");
		cmbreligion.txtSuggest.setText("");
		dateofbirth.setDate(new Date());
		dateofjoin.setDate(new Date());
		txtmobileno.setText("");
		txtaddrerss.setText("");
		txtemail.setText("");
		txtnationalid.setText("");
		txtnationality.setText("");
		cmbreferenceby.txtSuggest.setText("");
		txtusername.setText(session.getusername());
		file=null;
		photo.setIcon(new ImageIcon(""));
		isupdate=false;
		isdelete=false;
		flag=0;

	}
	public void referenceby()
	{
		cmbreferenceby.v.clear();
		cmbreferenceby.v.add("");
		try
		{
			Dbconection.conect();
			String sql="select userid,username from tbnewuserinfo order by username";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbreferenceby.v.add(rs.getString("userid")+"#"+rs.getString("username"));
			}
		}
		catch(Exception exp)
		{
			
			JOptionPane.showMessageDialog(null, exp,"Error...",JOptionPane.ERROR_MESSAGE);
		}
	}
	private boolean chkvalidation()
	{
		
		if(!txtclientid.getText().isEmpty()){
			if(!txtclientname.getText().isEmpty()){
				if(!cmbgender.txtSuggest.getText().isEmpty()){
					if(!txtfathername.getText().isEmpty()){
						if(!txtmothername.getText().isEmpty()){
							if(!cmbreligion.txtSuggest.getText().isEmpty()){
								if(!txtmobileno.getText().isEmpty()){
									if(!txtaddrerss.getText().isEmpty()){
										if(!txtemail.getText().isEmpty()){
											if(!txtnationalid.getText().isEmpty()){
												if(!txtnationality.getText().isEmpty()){
													if(!txtusername.getText().isEmpty()){
														if(!cmbreferenceby.txtSuggest.getText().trim().isEmpty())
														{														
															if(file!=null||isupdate||isdelete)
															{
																return true;
															}
															else
															{
																JOptionPane.showMessageDialog(null, "Select file/img plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
															}
														}
														else
														{
															JOptionPane.showMessageDialog(null, "Select Reference plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
														}
														
													}
													else
													{
														JOptionPane.showMessageDialog(null, "Insert UserName plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
													}
													
												}
												else
												{
													JOptionPane.showMessageDialog(null, "Insert Naitonality plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
												}
											}
											else
											{
												JOptionPane.showMessageDialog(null, "Insert National Id plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
											}
											
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Insert Email Id plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
										}
										
									}
									
									else
									{
										JOptionPane.showMessageDialog(null, "Insert Address plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Insert MObile no plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Insert Religion plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Insert Mather's Name plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert Father's Name plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select Gender plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
					
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insert ClientName plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
				
			}	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Insert Client Id plz !","Warning ...",JOptionPane.WARNING_MESSAGE);
			
		}
		return false;
	}
	private boolean confirmation(String caption)
	{
		int a=JOptionPane.showConfirmDialog(null, caption,"Confirm...",JOptionPane.YES_NO_OPTION);
		
		if(a==JOptionPane.YES_OPTION)
		{
			return true;
		}
		
		return false;
	}
	
	public void clientautoid()
	{
		try
		{
			Dbconection.conect();
			String sql="select ifnull(max(cast(substring" +
					"(ClientId,locate('-',ClientId)+1,length(ClientId)-locate('-',ClientId)) " +
					"as UNSIGNED)),0)+1 id from tbclientinfo";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				String id=rs.getString("id");
				txtclientid.setText("Client-"+id);
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
		panelwestcenter.setLayout(new BorderLayout());
		panelwestcenter.add(panelwestcentercenter, BorderLayout.CENTER);
		panelwestcentercenterwork();
		panelwestcenter.add(panelwestcenterwest, BorderLayout.WEST);
		panelwestcenterwestwork();
	}

	private void panelwestcentercenterwork() 
	{
		panelwestcentercenter.setBackground(Color.LIGHT_GRAY);
		panelwestcentercenter.setLayout(new BorderLayout());
		panelwestcentercenter.add(panelwestcentercenternorth,BorderLayout.NORTH);
		panelwestcentercenternorthwork();
		panelwestcentercenter.add(panelwestcentercentercenter,BorderLayout.CENTER);
		panelwestcentercentercenterwork();
	}

	private void panelwestcentercentercenterwork()
	{
		panelwestcentercentercenter.setBackground(Color.LIGHT_GRAY);
		panelwestcentercentercenter.setLayout(new FlowLayout());
		panelwestcentercentercenter.add(btnupload);
		btnupload.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
	}

	private void panelwestcentercenternorthwork() 
	{
		panelwestcentercenternorth.setBackground(Color.LIGHT_GRAY);
		panelwestcentercenternorth.setLayout(new BorderLayout());
		panelwestcentercenternorth.setPreferredSize(new Dimension(180,22));
		photo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		photo.setPreferredSize(new Dimension(100,140));
		FlowLayout flow=new FlowLayout();
		panelwestcentercentercenter.setLayout(flow);
		flow.setVgap(0);
		panelwestcentercentercenter.add(photo);
		
	}

	private void panelwestcenterwestwork() 
	{
		panelwestcenterwest.setBackground(Color.LIGHT_GRAY);
		panelwestcenterwest.setPreferredSize(new Dimension(400,540));
		panelwestcenterwest.setLayout(new GridBagLayout());
		GridBagConstraints con=new GridBagConstraints();
		
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 0, 5);
		
		con.gridx=0;
		con.gridy=0;
		panelwestcenterwest.add(lblclientid,con);
		lblclientid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=0;
		panelwestcenterwest.add(txtclientid,con);
		txtclientid.setEditable(false);
		
		con.gridx=0;
		con.gridy=1;
		panelwestcenterwest.add(lblclientname,con);
		lblclientname.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=1;
		panelwestcenterwest.add(txtclientname,con);
		
		con.gridx=0;
		con.gridy=2;
		panelwestcenterwest.add(lblgender,con);
		lblgender.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=2;
		panelwestcenterwest.add(cmbgender.cmbSuggest,con);
		cmbgender.v.add("");
		cmbgender.v.add("Male");
		cmbgender.v.add("Female");
		cmbgender.cmbSuggest.setPreferredSize(new Dimension(200,30));
	
		con.gridx=0;
		con.gridy=3;
		panelwestcenterwest.add(lblfathername,con);
		lblfathername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=3;
		panelwestcenterwest.add(txtfathername,con);
		
		con.gridx=0;
		con.gridy=4;
		panelwestcenterwest.add(lblmothername,con);
		lblmothername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=4;
		panelwestcenterwest.add(txtmothername,con);
		
		
		con.gridx=0;
		con.gridy=5;
		panelwestcenterwest.add(lblreligion,con);
		lblreligion.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=5;
		panelwestcenterwest.add(cmbreligion.cmbSuggest,con);
		cmbreligion.v.add("");
		cmbreligion.v.add("Hindues");
		cmbreligion.v.add("Muslim");
		cmbreligion.v.add("Buddish");
		cmbreligion.v.add("Cristan");
		
		con.gridx=0;
		con.gridy=6;
		panelwestcenterwest.add(lbldateofbirth,con);
		lbldateofbirth.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=6;
		panelwestcenterwest.add(dateofbirth,con);
		dateofbirth.setDateFormatString("dd-MM-yyyy");
		dateofbirth.setDate(new Date());
		
		con.gridx=0;
		con.gridy=7;
		panelwestcenterwest.add(lbldateofjoin,con);
		lbldateofjoin.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=7;
		panelwestcenterwest.add(dateofjoin,con);
		dateofjoin.setDateFormatString("dd-MM-yyyy");
		dateofjoin.setDate(new Date());
	
		con.gridx=0;
		con.gridy=8;
		panelwestcenterwest.add(lblmobileno,con);
		lblmobileno.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	
		con.gridx=1;
		con.gridy=8;
		panelwestcenterwest.add(txtmobileno,con);
		
		con.gridx=0;
		con.gridy=9;
		panelwestcenterwest.add(lbladdress,con);
		lbladdress.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=9;
		panelwestcenterwest.add(scoll,con);
		
		con.gridx=0;
		con.gridy=10;
		panelwestcenterwest.add(lblemail,con);
		lblemail.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=10;
		panelwestcenterwest.add(txtemail,con);
		
		con.gridx=0;
		con.gridy=11;
		panelwestcenterwest.add(lblnationalid,con);
		lblnationalid.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=11;
		panelwestcenterwest.add(txtnationalid,con);
	
		con.gridx=0;
		con.gridy=12;
		panelwestcenterwest.add(lblnationality,con);
		lblnationality.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=12;
		panelwestcenterwest.add(txtnationality,con);
		
		con.gridx=0;
		con.gridy=13;
		panelwestcenterwest.add(lblusername,con);
		lblusername.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=13;
		panelwestcenterwest.add(txtusername,con);
		txtusername.setText(session.getusername());
		
		con.gridx=0;
		con.gridy=14;
		panelwestcenterwest.add(lblreferencby,con);
		lblreferencby.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		
		con.gridx=1;
		con.gridy=14;
		panelwestcenterwest.add(cmbreferenceby.cmbSuggest,con);	
		
	}
	
	private void panelwestnorthwork() 
	{
		panelwestnorth.setBackground(Color.LIGHT_GRAY);
		panelwestnorth.setPreferredSize(new Dimension(580,80));
		panelwestnorth.setBorder(BorderFactory.createRaisedBevelBorder());

		FlowLayout flow=new FlowLayout();
		panelwestnorth.setLayout(flow);
		flow.setVgap(20);
		panelwestnorth.add(lblsearch);
		lblsearch.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		panelwestnorth.add(photoofsearch);
		panelwestnorth.add(cmbsearch.cmbSuggest);
		cmbsearch.cmbSuggest.setPreferredSize(new Dimension(300,30));
		
	}

	private void panelcenterwork()
	{
		panelcenter.setBackground(Color.LIGHT_GRAY);
		FlowLayout flow=new FlowLayout();
		panelcenter.setLayout(flow);
		panelcenter.add(clientscroll);
		clientscroll.setPreferredSize(new Dimension(550,700));
		
		
	}
}
