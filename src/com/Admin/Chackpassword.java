package com.Admin;
import javax.swing.*;
import com.Main.Mainclass;
import java.awt.*;

import java.awt.event.*;
import java.io.Closeable;
import java.sql.ResultSet;
public class Chackpassword extends JFrame
{
	JPanel panel=new JPanel();

	JPanel panelnourth=new JPanel();
	JPanel panelsouth=new JPanel();
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	
	JPanel panelcentersouth=new JPanel();
	JPanel panelcentercenter=new JPanel();

	JLabel lblcpw=new JLabel("Allright Reserved");
	JLabel lblemail=new JLabel("Email");
	JLabel lblpassword=new JLabel("Password");
	JLabel lblusertype=new JLabel("User Type");
	
	JTextField txtemail=new JTextField(15);
	JPasswordField txtpassword=new JPasswordField(15);
	SuggestText cmbusertype=new SuggestText();
	JButton btnlogin=new JButton("Login",new ImageIcon("img/login.png"));
	JButton btncencel=new JButton("Cencel",new ImageIcon("img/cencle.png"));
	JButton   btnreset=new JButton("Reset",new ImageIcon("img/reset0.png"));
	
	ImageIcon image=new ImageIcon("img/passok.png");
	ImageIcon image1=new ImageIcon("img/north1.png");
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	
	public Chackpassword()
	{
		frame();
		comp();
		btnAction();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/sicon.jpg"));
	}
	private void btnloginaction()
	{
		panel.setVisible(false);
		SessionBean session=new SessionBean();
		session.setusername(txtemail.getText().trim());
		session.setusertype(cmbusertype.txtSuggest.getText().trim());
		workingPanel wp=new workingPanel(this,session);
		add(wp);
		wp.setVisible(true);
		setSize(screen);
		setLocationRelativeTo(null);
	}
	
	private boolean chkusername()
	{
		int x=0;
		String username="";
		String password="";
		String usertype="";
		String passhint="";
		
		Dbconection.conect();
		String sql="select username from tbnewuserinfo";
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				username=txtemail.getText();
				if(username.equalsIgnoreCase(rs.getString("username")))
				{
					x=1;
					String passsql="select password,usertype,passwordhint from tbnewuserinfo where username like '"+username+"'";
					ResultSet rspass=Dbconection.sta.executeQuery(passsql);
					if(rspass.next())
					{
						password=rspass.getString("password");
						usertype=rspass.getString("usertype");
						passhint=rspass.getString("passwordhint");
					}
					if(txtpassword.getText().equals(password))
					{
						if(cmbusertype.txtSuggest.getText().equalsIgnoreCase(usertype))
						{
							return true;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Usertype is not valid !","Eroor",JOptionPane.ERROR_MESSAGE);
						}	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "unvalid password ! Try again","Error...........",JOptionPane.ERROR_MESSAGE);
						JOptionPane.showMessageDialog(null,"Password hint: "+passhint,"Eroor.........",JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
			}
			if(x==0)
			{
				JOptionPane.showMessageDialog(null, "username not found !","Eroor",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		
		return false;
	}
	private void btnAction()
	{
		btnlogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(cheackVeridation())
				{
					if(chkusername())
					{
						btnloginaction();
					}
				}
			}
		});
		btncencel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(confirmation())
				{
					dispose();
				}	
			}
		});
		btnreset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtemail.setText("");
				txtpassword.setText("");
				cmbusertype.txtSuggest.setText("");	
			}
		});
	}
	public boolean confirmation()
	{
		int a=JOptionPane.showConfirmDialog(null, "Do you want to cancel ?","Confirm...",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}
	private boolean cheackVeridation()
	{
		if(!txtemail.getText().trim().isEmpty()){
			if(!txtpassword.getText().trim().isEmpty()){
				if(!cmbusertype.txtSuggest.getText().trim().isEmpty())
				{
					return true;
				}
				else
				{
				JOptionPane.showMessageDialog(null, "insert your Usertype !","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
			JOptionPane.showMessageDialog(null, "insert your password !","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "insert your email !","Warning",JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
	public void comp()
	{
		add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		panel.setLayout(new BorderLayout());
		panel.add(panelnourth,BorderLayout.NORTH);
		panelnourthwork();
		panel.add(panelsouth,BorderLayout.SOUTH);
		panelsouthwork();
		panel.add(panelwest,BorderLayout.WEST);
		panelwesthwork();
		panel.add(panelcenter,BorderLayout.CENTER);
		panelcenter.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelcenterwork();		
	}
	private void panelcenterwork() 
	{
		panelcenter.setLayout(new BorderLayout());
		panelcenter.add(panelcentersouth,BorderLayout.SOUTH);
		panelcenter.add(panelcentercenter,BorderLayout.CENTER);
		panelcentercenterwork();
		panelcentersouthwork();
	}
	private void panelcentersouthwork() 
	{
		panelcentersouth.setPreferredSize(new Dimension(350,45));
		panelcentersouth.setBackground(Color.LIGHT_GRAY);
		panelcentersouth.setLayout(new FlowLayout());
		panelcentersouth.add(btnlogin);
		btnlogin.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentersouth.add(btncencel);
		btncencel.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		panelcentersouth.add(btnreset);
		btnreset.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
	}
	private void panelcentercenterwork()
	{
		GridBagLayout grid =new GridBagLayout();
		panelcentercenter.setBackground(Color.LIGHT_GRAY);
		panelcentercenter.setLayout(grid);
		GridBagConstraints con=new GridBagConstraints();
		
		con.fill=GridBagConstraints.BOTH;
		con.insets=new Insets(5, 5, 5, 5);
		con.gridx=0;
		con.gridy=0;
		panelcentercenter.add(lblemail,con);
		lblemail.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
			
		con.gridx=1;
		con.gridy=0;
		panelcentercenter.add(txtemail,con);
		txtemail.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		txtemail.setForeground(Color.DARK_GRAY);
		txtemail.setText("Sourav Mojumder");
			
		con.gridx=0;
		con.gridy=1;
		panelcentercenter.add(lblpassword,con);
		lblpassword.setFont(new Font("serif", Font.BOLD+Font.ITALIC,15));
		
		con.gridx=1;
		con.gridy=1;
		panelcentercenter.add(txtpassword,con);
		txtpassword.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		txtpassword.setForeground(Color.DARK_GRAY);
		txtpassword.setText("sourav");
		
		con.gridx=0;
		con.gridy=2;
		panelcentercenter.add(lblusertype,con);
		lblusertype.setFont(new Font("serif", Font.BOLD+Font.ITALIC,15));
		
		con.gridx=1;
		con.gridy=2;
		panelcentercenter.add(cmbusertype.cmbSuggest,con);
		cmbusertype.v.add("");
		cmbusertype.v.add("Admin");
		cmbusertype.v.add("SuperAdmin");
		cmbusertype.v.add("Executive");
			
		cmbusertype.txtSuggest.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 15));
		cmbusertype.txtSuggest.setForeground(Color.DARK_GRAY);
		cmbusertype.txtSuggest.setText("Admin");		
	}	
	private void panelwesthwork() 
	{
		FlowLayout flow=new FlowLayout();
		panelwest.setLayout(flow);
		BorderLayout border=new BorderLayout();
		panelwest.setLayout(border);
		panelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelwest.setBackground(Color.DARK_GRAY);
		panelwest.setPreferredSize(new Dimension(150,0));
		panelwest.add(new JLabel(image));
	}
	private void panelsouthwork() 
	{
		FlowLayout flow=new FlowLayout();
		panelsouth.setLayout(flow);
		panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelsouth.setPreferredSize(new Dimension(0,50));
		panelsouth.setBackground(Color.DARK_GRAY);
		panelsouth.add(lblcpw);
		lblcpw.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		lblcpw.setForeground(Color.WHITE);
	}
	private void panelnourthwork() 
	{
		FlowLayout flow=new FlowLayout();
		panelnourth.setLayout(flow);
		panelnourth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelnourth.setPreferredSize(new Dimension(0,75));
		panelnourth.setBackground(Color.DARK_GRAY);
		panelnourth.add(new JLabel(image1));
		flow.setAlignment(FlowLayout.CENTER);
	}
	private void frame()
	{
		setSize(500,320);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin");
		setResizable(false);
	}
}