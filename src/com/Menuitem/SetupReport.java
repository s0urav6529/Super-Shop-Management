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
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import com.Admin.Dbconection;
import com.Admin.SessionBean;
import com.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class SetupReport extends JPanel
{
	JPanel panelNorth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelProductReport=new JPanel();
	JPanel panelSupplierReport=new JPanel();
	JPanel panelClientReport=new JPanel();
	JPanel panelStockReport=new JPanel();
	
	JPanel panelProductReportCenter=new JPanel();
	JPanel panelProductReportSouth=new JPanel();
	JPanel panelSupplierReportCenter=new JPanel();
	JPanel panelSupplierReportSouth=new JPanel();
	JPanel panelClientReportCenter=new JPanel();
	JPanel panelClientReportSouth=new JPanel();
	JPanel panelStockReportCenter=new JPanel();
	JPanel panelStockReportSouth=new JPanel();
	
	SuggestText cmbProductReport=new SuggestText();
	SuggestText cmbSupplierReport=new SuggestText();
	SuggestText cmbClientReport=new SuggestText();
	
	JComboBox cmbStockReport=new JComboBox();
	JComboBox cmbReportType=new JComboBox();
	JComboBox cmbCatagory=new JComboBox();
	JComboBox cmbSubCatagory=new JComboBox();
	JComboBox cmbProductID=new JComboBox();
	JComboBox cmbTransactionNo=new JComboBox();

	JCheckBox chkProductReport=new JCheckBox("All");
	JCheckBox chkSupplierReport=new JCheckBox("All");
	JCheckBox chkClientReport=new JCheckBox("All");
	JCheckBox chkStockReport=new JCheckBox("All");
	
	JButton btnPreviewProductReport=new JButton("Preview",new ImageIcon("img/preview.png"));
	JButton btnPreviewSupplierReport=new JButton("Preview",new ImageIcon("img/preview.png"));
	JButton btnPreviewClientReport=new JButton("Preview",new ImageIcon("img/preview.png"));
	JButton btnPreviewStockReport=new JButton("Preview",new ImageIcon("img/preview.png"));

	JLabel lblCatagory=new JLabel("Catagory");
	JLabel lblSubCatagory=new JLabel("Sub Catagory");
	JLabel lblProductID=new JLabel("Product ID");	
	JLabel lblReporttype=new JLabel("Report Type");	
	JLabel lblTransactionNo=new JLabel("Transaction No: ");
	JLabel lblFromData=new JLabel("From Date: ");
	JLabel lblToDate=new JLabel("To Date: ");

	JCheckBox chkCatagoryAll=new JCheckBox("All");
	JCheckBox chkSubCatagoryAll=new JCheckBox("All");
	JCheckBox chkProductall=new JCheckBox("All");

	JButton btnPrintProductReport=new JButton("Print",new ImageIcon("img/print.png"));
	JButton btnPrintSupplierReport=new JButton("Print",new ImageIcon("img/print.png"));
	JButton btnPrintClientReport=new JButton("Print",new ImageIcon("img/print.png"));
	JButton btnPrintStockReport=new JButton("Print",new ImageIcon("img/print.png"));
	ButtonGroup group=new ButtonGroup();
	Font font=new Font("serif",Font.BOLD+Font.ITALIC,15);
	SessionBean sessionBean;

	SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
	JDateChooser dFromDate=new JDateChooser();
	JDateChooser dToDate=new JDateChooser();

	public SetupReport(SessionBean bean) 
	{
		this.sessionBean=bean;
		init();
		cmp();
		btnaction();
		cheackaction();
		cmbaction();
		stockReportTrueFalse(false);
	}

	private void cheackaction()
	{
		chkProductReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkProductReport.isSelected())
				{
					cmbProductReport.txtSuggest.setEnabled(false);
					cmbProductReport.cmbSuggest.setEnabled(false);
					cmbProductReport.txtSuggest.setText("");
				}
				else
				{
					cmbProductReport.txtSuggest.setEnabled(true);
					cmbProductReport.cmbSuggest.setEnabled(true);
				}
			}
		});
		
		chkClientReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkClientReport.isSelected())
				{
					cmbClientReport.txtSuggest.setEnabled(false);
					cmbClientReport.cmbSuggest.setEnabled(false);
					cmbClientReport.txtSuggest.setText("");
				}
				else
				{
					cmbClientReport.txtSuggest.setEnabled(true);
					cmbClientReport.cmbSuggest.setEnabled(true);
				}
			}		
		});
		
		chkSupplierReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkSupplierReport.isSelected())
				{
					cmbSupplierReport.txtSuggest.setEnabled(false);
					cmbSupplierReport.cmbSuggest.setEnabled(false);
					cmbSupplierReport.txtSuggest.setText("");
				}
				else
				{
					cmbSupplierReport.txtSuggest.setEnabled(true);
					cmbSupplierReport.cmbSuggest.setEnabled(true);
				}
			}
		});
		
		chkCatagoryAll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkCatagoryAll.isSelected())
				{
					cmbCatagory.setSelectedIndex(0);
					cmbCatagory.setEnabled(false);
				}
				else
				{
					cmbCatagory.setEnabled(true);
				}
			}
		});
		
		chkSubCatagoryAll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chkSubCatagoryAll.isSelected())
				{
					cmbSubCatagory.setSelectedIndex(0);
					cmbSubCatagory.setEnabled(false);
				}
				else
				{
					cmbSubCatagory.setEnabled(true);
				}
			}
		});
		
		chkProductall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(chkProductall.isSelected())
				{
					cmbProductID.setSelectedIndex(0);
					cmbProductID.setEnabled(false);
					cmbCatagory.setSelectedIndex(0);
					cmbCatagory.setEnabled(false);
					cmbSubCatagory.setSelectedIndex(0);
					cmbSubCatagory.setEnabled(false);
					chkCatagoryAll.setSelected(true);
					chkSubCatagoryAll.setSelected(true);
					
				}
				else
				{
					cmbProductID.setEnabled(true);
					cmbCatagory.setEnabled(true);
					cmbSubCatagory.setEnabled(true);
					chkCatagoryAll.setSelected(false);
					chkSubCatagoryAll.setSelected(false);
				}
			}
		});	
	}

	private void btnaction()
	{
		btnPreviewProductReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				previewproductreport();
			}
		});
		
		btnPreviewSupplierReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				previewsupplierreport();
			}
		});
		
		btnPreviewClientReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				previewclientreport();
			}
		});
		
		btnPreviewStockReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				previewstockreport();
			}
		});
		
		btnPrintProductReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Hello Boss");				
			}
		});
		
		btnPrintSupplierReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Hello Boss");				
			}
		});
		
		btnPrintClientReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Hello Boss");				
			}
		});
		
		btnPrintStockReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Hello Boss");
			}
		});
	}
	
	private void cmbaction() 
	{
		cmbReportType.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(cmbReportType.getSelectedIndex()!=0 && cmbReportType.getSelectedItem()!=null)
				{
					reportTypeWork();
				}
			}
		});
	}
	
	private boolean cmbreporttypeselected()
	{
		if(cmbReportType.getSelectedIndex()!=0 &&cmbReportType.getSelectedItem()!=null)
		{
			return true;		
		}
		return false;
	}
	private boolean chkvalidationopenningandprofit()
	{
		if(cmbCatagory.getSelectedIndex()!=0 && cmbCatagory.getSelectedItem()!=null || chkCatagoryAll.isSelected())
		{
			if(cmbSubCatagory.getSelectedIndex()!=0 && cmbSubCatagory.getSelectedItem()!=null || chkSubCatagoryAll.isSelected())
			{
				if(cmbProductID.getSelectedIndex()!=0 && cmbProductID.getSelectedItem()!=null || chkProductall.isSelected())
				{
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select ProductID Plz !","Warn...",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Select SubCatagory Plz !","Warn...",JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select catagory Plz !","Warn...",JOptionPane.WARNING_MESSAGE);
		}
		return false;		
	}
	
	private boolean chkreport(String sql)
	{
		try
		{
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			if(rs.next())
			{
				return true;
			}	
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	
	private void previewstockreport()
	{
		String catagoryId="%";
		String subCatagoryId="%";
		String productId="%";
		String transactionNo="%";
		String sql="";
		
		HashMap<String,String> hasmap=new HashMap<String,String>();
		hasmap.put("company",sessionBean.getcompanyname());
		hasmap.put("adderss",sessionBean.getcompanyadress());
		hasmap.put("developeraddress",sessionBean.getdevloperadress());
		
		if(cmbreporttypeselected())
		{
			if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Opening Stock")||
					   cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Profit Statement"))
				{
				     if(chkvalidationopenningandprofit())
				     {
				        if(cmbCatagory.getSelectedIndex()!=0 && cmbCatagory.getSelectedItem()!=null)
						{
							String product=cmbCatagory.getSelectedItem().toString();
							StringTokenizer token=new StringTokenizer(product,"#");
							catagoryId=token.nextToken();
						}
						if(cmbSubCatagory.getSelectedIndex()!=0 && cmbSubCatagory.getSelectedItem()!=null )
						{
							String product=cmbSubCatagory.getSelectedItem().toString();
							StringTokenizer token=new StringTokenizer(product,"#");
							subCatagoryId=token.nextToken();
						}
						if(cmbProductID.getSelectedIndex()!=0 && cmbProductID.getSelectedItem()!=null)
						{
							String product=cmbProductID.getSelectedItem().toString();
							StringTokenizer token=new StringTokenizer(product,"#");
						    productId=token.nextToken();
						}	
						if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Opening Stock"))
						{
							sql="select catagoryId,catagoryName,subcatagoryId,subCatagoryName,productId,"+
								"productName,unit,stockQuentity,dealerrate,amount from tbopeningstockinfo where "+
								"catagoryId like '"+catagoryId+"' and subcatagoryId like '"+subCatagoryId+"' and productId like '"+productId+"'"+
								" order by catagoryName,subCatagoryName,productName";
							if(chkreport(sql))
							{
								allStockreportShow("ReportFile/rptOpeningStock.jrxml",sql,hasmap);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "There is no ValidData, Sorry !","Info...",JOptionPane.INFORMATION_MESSAGE);
							}	
					    }
						else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Profit Statement"))
						{
							sql="select c.catagoryid,c.catagoryname,c.subcatagoryid,c.subcatagoryname,b.productid,b.productName,b.unit,b.dealerPrice," +
								"b.tradePrice,ifnull(sum(b.salesqty),0)salesqty from tbsalesinfo a inner join tbsalesdetails b on a.salesNo=b.salesNo inner" +
								" join tbproductinfo c on b.productId=c.productid where a.salesdate between '' and '' group by b.productid," +
								"b.productName,b.unit,b.dealerPrice,b.tradePrice order by c.catagoryname,c.subcatagoryname,b.productName";
								System.out.println(sql);
								
								if(chkreport(sql))
								{
									allStockreportShow("ReportFile/profitSummary.jrxml",sql,hasmap);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "There is no ValidData, Sorry !","Info...",JOptionPane.INFORMATION_MESSAGE);
								}
							}							
				        }						
					}
			else			
		    {
				if(cmbTransactionNo.getSelectedIndex()!=0&& cmbTransactionNo.getSelectedItem()!=null)
				{
					transactionNo=cmbTransactionNo.getSelectedItem().toString();
							
					if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Purchase Receipt"))
					{
							sql="select b.invoiceno,b.productname,b.stock,b.dealerrate,b.receiveqty,b.presentstock," +
								"b.suppliername,b.amount,a.invoicedate,a.currentdate,a.totalamount from tbpurchaserecipentinfo" +
								" a inner join tbpurchaserecipentdetails b on a.invoiceno=b.invoiceno where a.invoiceno='"+transactionNo+"'";							
							allStockreportShow("ReportFile/perchaserecipentfile.jrxml",sql,hasmap);					
						
					}
					else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Return To Supplier"))
					{
						sql="select b.returnno,b.productname,b.suppliername,b.unit,b.stockqty,b.returnqty,b.dealerprice,b.amount,"+
						    "a.currentdate,a.returndate,a.totalamount from tbretrurntosupplierinfo a inner join tbretrurntosupplierdetails"+
						    " b on a.returnno=b.returnno where a.returnno='"+transactionNo+"'";
						allStockreportShow("ReportFile/Returntosupplierfile.jrxml",sql,hasmap);
					}
					else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Sales"))
					{
						sql="select b.salesno,b.productname,b.salesqty,b.stockqty,b.dealerprice,b.tradeprice,b.amount,a.ClientType,"+
							"a.clientname,a.salesdate,a.totalamount from tbsalesinfo a inner join tbsalesdetails" +
							" b on a.salesno=b.salesno where a.salesno='"+transactionNo+"'";
						allStockreportShow("ReportFile/Salesfile.jrxml",sql,hasmap);
					}
					else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Sales Return"))
					{
						sql="select b.salesreturnno,b.productname,b.stockqty,b.traderprice,b.salesqty,b.alreadyreceive,b.receiveqty," +
							"b.amount,a.currentdate,a.Returndate,a.totalamount   from tbsalesreturninfo a inner join tbsalesreturndetails" +
							" b on a.salesreturnno=b.salesreturnno where a.salesreturnno='"+transactionNo+"'";
						allStockreportShow("ReportFile/Salesreturnfile.jrxml",sql,hasmap);
					}
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "Select Transection No. Plz !","Warn...",JOptionPane.WARNING_MESSAGE);
				}
			}		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Select ReportType plz !","Error",JOptionPane.ERROR_MESSAGE);
		}		
	}
	public void allStockreportShow(String path,String query,HashMap<String, String > hasmap)
	{
		try
		{
			Dbconection.conect();
			JasperDesign jd=JRXmlLoader.load(path);
			JRDesignQuery jq=new JRDesignQuery();
			jq.setText(query);
			jd.setQuery(jq);
			JasperReport jr=JasperCompileManager.compileReport(jd) ;
			JasperPrint jp=JasperFillManager.fillReport(jr,hasmap,Dbconection.con);
			JasperViewer.viewReport(jp,false);
			Dbconection.con.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	private void reportTypeWork() 
	{
		if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Profit Statement"))
		{
			stockReportTrueFalse(false);
		}
		else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Opening Stock"))
		{
			stockReportTrueFalse(false);
			lblFromData.setVisible(false);
			dFromDate.setVisible(false);
			lblToDate.setVisible(false);
			dToDate.setVisible(false);
		}
		else
		{
			stockReportTrueFalse(true);
			
			if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Purchase Receipt"))
			{
				reprotTypeWiseTransactionNoLoad("PurchaseReceipt");
			}
			
			else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Sales"))
			{
				reprotTypeWiseTransactionNoLoad("Sales");
			}
			
			else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Return To Supplier"))
			{
				reprotTypeWiseTransactionNoLoad("Return To Supplier");
			}
			
			else if(cmbReportType.getSelectedItem().toString().equalsIgnoreCase("Sales Return"))
			{
				reprotTypeWiseTransactionNoLoad("Sales Return");
			}
		}
	}
	
	private void reprotTypeWiseTransactionNoLoad(String caption) 
	{
		String sql="";
		cmbTransactionNo.removeAllItems();
		cmbTransactionNo.addItem("");
		
		if(caption.equalsIgnoreCase("PurchaseReceipt"))
		{
			sql="select invoiceno transactionNo from tbpurchaserecipentinfo";
		}
		
		else if(caption.equalsIgnoreCase("Sales"))
		{
			sql="select salesno transactionNo from tbsalesinfo";
		}
		
		else if(caption.equalsIgnoreCase("Return To Supplier"))
		{
			sql="select returnno transactionNo  from tbretrurntosupplierinfo";
		}
		
		else if(caption.equalsIgnoreCase("Sales Return"))
		{
			sql="select salesreturnno transactionNo from tbsalesreturninfo";
		}
		
		Dbconection.conect();
		try
		{
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbTransactionNo.addItem(rs.getString("transactionNo"));
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void stockReportTrueFalse(boolean b)
	{
		lblTransactionNo.setVisible(b);
		cmbTransactionNo.setVisible(b);

		lblCatagory.setVisible(!b);
		cmbCatagory.setVisible(!b);
		chkCatagoryAll.setVisible(!b);

		lblSubCatagory.setVisible(!b);
		cmbSubCatagory.setVisible(!b);
		chkSubCatagoryAll.setVisible(!b);

		lblProductID.setVisible(!b);
		cmbProductID.setVisible(!b);
		chkProductall.setVisible(!b);

		lblFromData.setVisible(!b);
		dFromDate.setVisible(!b);

		lblToDate.setVisible(!b);
		dToDate.setVisible(!b);
	}
	
	public void cmbCatloadforreporttype()
	{
		try
		{
			cmbCatagory.removeAllItems();
			cmbCatagory.addItem("");
			String query="select catagoryid,catagoryname from tbCatagoryInfo  order by catagoryname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(query);
			while(rs.next())
			{
				cmbCatagory.addItem(rs.getString("catagoryid")+"#"+rs.getString("catagoryname"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp,"Error..",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cmbSubCatloadforreporttype()
	{
		try
		{
			cmbSubCatagory.removeAllItems();
			cmbSubCatagory.addItem("");
			
			String sql="select subcatagoryid,subcatagoryname from tbsubcatagoryinfo  order by subcatagoryname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql); 
			while(rs.next())
			{
				cmbSubCatagory.addItem(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryname"));    
		    }
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp+"()","**Error**",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void cmbProloadforreporttype()
	{
		try
		{
			cmbProductID.removeAllItems();
			cmbProductID.addItem("");
			
			String sql="Select productid,productname from tbproductinfo order by productname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbProductID.addItem(rs.getString("productid").trim()+"#"+rs.getString("productname").trim());
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp,"**Error**",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void previewproductreport()
	{
		HashMap<String,String> hasmap=new HashMap<String,String>();
		hasmap.put("companyname",sessionBean.getcompanyname());
	    hasmap.put("companyadress",sessionBean.getcompanyadress());
		hasmap.put("developeradress",sessionBean.getdevloperadress());
		String productname="%";
		
		if(!cmbProductReport.txtSuggest.getText().trim().isEmpty())
		{
			String product=cmbProductReport.txtSuggest.getText().trim();
			StringTokenizer token=new StringTokenizer(product,"#");
			productname=token.nextToken();
		}
		
		String sql="select productid,productname,unit,dealerprice," +
				   "tradeprice,suppliername from tbproductinfo where productid like '"+productname+"'";		
		
		 if(!cmbProductReport.txtSuggest.getText().isEmpty()|| chkProductReport.isSelected())
	     {
			 ProductreportShow("ReportFile/productfile.jrxml",sql,hasmap);
	     }
		 else
         {
        	JOptionPane.showMessageDialog(null, "select productid pls !","Warn...",JOptionPane.WARNING_MESSAGE);
         }
	}
	
	public void ProductreportShow(String path,String query,HashMap<String,String> hasmap)
	{
		try
		{
			Dbconection.conect();
			JasperDesign jd=JRXmlLoader.load(path);
			JRDesignQuery jq=new JRDesignQuery();
			jq.setText(query);
			jd.setQuery(jq);
			JasperReport jr=JasperCompileManager.compileReport(jd) ;
			JasperPrint jp=JasperFillManager.fillReport(jr,hasmap,Dbconection.con);
			JasperViewer.viewReport(jp,false);
			Dbconection.con.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,e+" (reportShowSupplier)","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void previewsupplierreport()
	{
		HashMap<String,String> hasmap=new HashMap<String,String>();
		hasmap.put("companyName",sessionBean.getcompanyname());
		hasmap.put("companyAdderss",sessionBean.getcompanyadress());
		hasmap.put("developerAddress",sessionBean.getdevloperadress());
		String Supplierid="%";
		if(!cmbSupplierReport.txtSuggest.getText().trim().isEmpty())
		{
			String supName=cmbSupplierReport.txtSuggest.getText();
			StringTokenizer token=new StringTokenizer(supName,"#");
			Supplierid=token.nextToken();
		}
		String sql="select suppliername,mailid,address,phonenumber from tbsupplierinfo" +
				   " where supplierid like '"+Supplierid+"' order by suppliername";

		 if(!cmbSupplierReport.txtSuggest.getText().isEmpty()|| chkSupplierReport.isSelected())
	     {
			 SupplierreportShow("ReportFile/supplierfile.jrxml",sql,hasmap);
	     }
		 else
         {
        	JOptionPane.showMessageDialog(null, "select supplierid pls !","Warn...",JOptionPane.WARNING_MESSAGE);
         }
	}
	
	public void SupplierreportShow(String path,String query,HashMap<String, String > hasmap)
	{
		try
		{
			Dbconection.conect();
			JasperDesign jd=JRXmlLoader.load(path);
			JRDesignQuery jq=new JRDesignQuery();
			jq.setText(query);
			jd.setQuery(jq);
			JasperReport jr=JasperCompileManager.compileReport(jd) ;
			JasperPrint jp=JasperFillManager.fillReport(jr,hasmap,Dbconection.con);
			JasperViewer.viewReport(jp,false);
			Dbconection.con.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,e+" (reportShowSupplier)","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void previewclientreport()
	{
		HashMap<String,String> hasmap=new HashMap<String,String>();
		hasmap.put("companyName",sessionBean.getcompanyname());
		hasmap.put("companyAdderss",sessionBean.getcompanyadress());
		hasmap.put("developerAddress",sessionBean.getdevloperadress());
		String clientId="%";
		if(!cmbClientReport.txtSuggest.getText().trim().isEmpty())
		{
			String idName=cmbClientReport.txtSuggest.getText();
			StringTokenizer token=new StringTokenizer(idName,"#");
			clientId=token.nextToken();
		}
		String sql="select clientname,address,Mobileno,EmailId,nationalid,"+
                   "referencebyname from tbclientinfo "+
                   "where clientid like '"+clientId+"' order by clientname";

        if(!cmbClientReport.txtSuggest.getText().isEmpty()|| chkClientReport.isSelected())
        {
        	clientreportShow("ReportFile/clientfile.jrxml",sql,hasmap);
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "select clientid pls !","Warn...",JOptionPane.WARNING_MESSAGE);
        }
	}
	
	
	public void clientreportShow(String path, String query,HashMap<String, String> hasmap)
	{
		try
		{
			Dbconection.conect();
			JasperDesign jd=JRXmlLoader.load(path);
			JRDesignQuery jq=new JRDesignQuery();
			jq.setText(query);
			jd.setQuery(jq);
			JasperReport jr=JasperCompileManager.compileReport(jd) ;
			JasperPrint jp=JasperFillManager.fillReport(jr,hasmap,Dbconection.con);
			JasperViewer.viewReport(jp,false);
			Dbconection.con.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void cmbproductnameload()
	{
		try
		{
			cmbProductReport.v.clear();
			cmbProductReport.v.add("");
			String sql="select productid, productname from tbproductinfo order by productname";
			Dbconection.conect();
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbProductReport.v.add(rs.getString("productid")+"#"+rs.getString("productname"));
			}
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,e+" (cmbproductnameload)","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cmbsuppliernameload()
	{
		try
		{
			cmbSupplierReport.v.clear();
			cmbSupplierReport.v.add("");
			Dbconection.conect();
			String sql="select supplierid,supplierName from tbsupplierinfo order by supplierName";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbSupplierReport.v.add(rs.getString("supplierid")+"#"+rs.getString("supplierName"));
			}
			Dbconection.con.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,e+" (cmbsuppliernameload)","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void clientNameLoad()
	{
		try{
			cmbClientReport.v.clear();
			Dbconection.conect();
			String sql="select clientId,clientName from tbClientINfo order by clientName";
			ResultSet rs=Dbconection.sta.executeQuery(sql);
			cmbClientReport.v.add("");
			while(rs.next())
			{
				cmbClientReport.v.add(rs.getString("clientId")+"#"+rs.getString("clientName"));
			}
			Dbconection.con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	public void cmp()
	{
		add(panelNorth,BorderLayout.NORTH);
		panelNorth();
		add(panelCenter,BorderLayout.CENTER);
		panelCenter();
	}

	public void panelProductReportCenter()
	{
		GridBagLayout grid=new GridBagLayout();
		panelProductReportCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		cmbProductReport.cmbSuggest.setPreferredSize(new Dimension(350,40));
		panelProductReportCenter.add(cmbProductReport.cmbSuggest,cn);
		cn.gridx=1;
		cn.gridy=0;
		panelProductReportCenter.add(chkProductReport,cn);
		chkProductReport.setFont(font);
	}
	
	public void panelProductReportSouth()
	{
		panelProductReportSouth.setPreferredSize(new Dimension(0,100));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(10);
		panelProductReportSouth.setLayout(flow);
		btnPreviewProductReport.setPreferredSize(new Dimension(120,45));
		panelProductReportSouth.add(btnPreviewProductReport);
		btnPreviewProductReport.setFont(font);
		btnPrintProductReport.setPreferredSize(new Dimension(120,45));
		panelProductReportSouth.add(btnPrintProductReport);
		btnPrintProductReport.setFont(font);
	}
	
	public void panelProductReport()
	{
		panelProductReport.setPreferredSize(new Dimension(570,1));
		TitledBorder productreportTitle=new TitledBorder("Product Report");
		productreportTitle.setTitleFont(font);
		productreportTitle.setTitleColor(Color.DARK_GRAY);
		productreportTitle.setTitleJustification(TitledBorder.CENTER);
		panelProductReport.setBorder(productreportTitle);
		BorderLayout border=new BorderLayout();
		panelProductReport.setLayout(border);
		panelProductReport.add(panelProductReportCenter,BorderLayout.CENTER);
		panelProductReportCenter();
		panelProductReport.add(panelProductReportSouth,BorderLayout.SOUTH);
		panelProductReportSouth();
	}
	
	public void panelSupplierReportCenter()
	{	
		GridBagLayout grid=new GridBagLayout();
		panelSupplierReportCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		cmbSupplierReport.cmbSuggest.setPreferredSize(new Dimension(350,40));
		panelSupplierReportCenter.add(cmbSupplierReport.cmbSuggest,cn);
		cn.gridx=1;
		cn.gridy=0;
		panelSupplierReportCenter.add(chkSupplierReport,cn);
		chkSupplierReport.setFont(font);
	}
	
	public void panelSupplierReportSouth()
	{
		panelSupplierReportSouth.setPreferredSize(new Dimension(0,100));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(10);
		panelSupplierReportSouth.setLayout(flow);
		btnPreviewSupplierReport.setPreferredSize(new Dimension(120,45));
		panelSupplierReportSouth.add(btnPreviewSupplierReport);
		btnPreviewSupplierReport.setFont(font);

		btnPrintSupplierReport.setPreferredSize(new Dimension(120,45));
		panelSupplierReportSouth.add(btnPrintSupplierReport);
		btnPrintSupplierReport.setFont(font);
	}
	
	public void panelSupplierReport()
	{
		panelSupplierReport.setPreferredSize(new Dimension(570,1));
		TitledBorder supplierreportTitle=new TitledBorder("Supplier Report");
		supplierreportTitle.setTitleFont(font);
		supplierreportTitle.setTitleColor(Color.DARK_GRAY);
		supplierreportTitle.setTitleJustification(TitledBorder.CENTER);
		panelSupplierReport.setBorder(supplierreportTitle);
		BorderLayout border=new BorderLayout();
		panelSupplierReport.setLayout(border);
		panelSupplierReport.add(panelSupplierReportCenter,BorderLayout.CENTER);
		panelSupplierReportCenter();
		panelSupplierReport.add(panelSupplierReportSouth,BorderLayout.SOUTH);
		panelSupplierReportSouth();
	}
	
	public void panelNorth()
	{
		panelNorth.setPreferredSize(new Dimension(1140,365));
		BorderLayout border=new BorderLayout();
		border.setHgap(10);
		panelNorth.setLayout(border);
		panelNorth.add(panelProductReport,BorderLayout.WEST);
		panelProductReport();
		panelNorth.add(panelSupplierReport,BorderLayout.CENTER);
		panelSupplierReport();
	}
	
	public void panelClientReport()
	{
		panelClientReport.setPreferredSize(new Dimension(570,1));
		TitledBorder clientreportTitle=new TitledBorder("Client Report");
		clientreportTitle.setTitleFont(font);
		clientreportTitle.setTitleColor(Color.DARK_GRAY);
		clientreportTitle.setTitleJustification(TitledBorder.CENTER);
		panelClientReport.setBorder(clientreportTitle);
		BorderLayout border=new BorderLayout();
		panelClientReport.setLayout(border);
		panelClientReport.add(panelClientReportCenter,BorderLayout.CENTER);
		panelClientReportCenter();
		panelClientReport.add(panelClientReportSouth,BorderLayout.SOUTH);
		panelClientReportSouth();
	}
	
	public void panelClientReportCenter()
	{
		GridBagLayout grid=new GridBagLayout();
		panelClientReportCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		cmbClientReport.cmbSuggest.setPreferredSize(new Dimension(350,40));
		panelClientReportCenter.add(cmbClientReport.cmbSuggest,cn);
		cn.gridx=1;
		cn.gridy=0;
		panelClientReportCenter.add(chkClientReport,cn);
		chkClientReport.setFont(font);
	}
	
	public void panelClientReportSouth()
	{
		panelClientReportSouth.setPreferredSize(new Dimension(0,100));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(10);
		panelClientReportSouth.setLayout(flow);
		btnPreviewClientReport.setPreferredSize(new Dimension(120,45));
		panelClientReportSouth.add(btnPreviewClientReport);
		btnPreviewClientReport.setFont(font);
		btnPrintClientReport.setPreferredSize(new Dimension(120,45));
		panelClientReportSouth.add(btnPrintClientReport);
		btnPrintClientReport.setFont(font);
	}
	
	public void panelStockReport()
	{
		panelStockReport.setPreferredSize(new Dimension(570,1));
		TitledBorder stockreportTitle=new TitledBorder("Stock Report");
		stockreportTitle.setTitleFont(font);
		stockreportTitle.setTitleColor(Color.DARK_GRAY);
		stockreportTitle.setTitleJustification(TitledBorder.CENTER);
		panelStockReport.setBorder(stockreportTitle);
		BorderLayout border=new BorderLayout();
		panelStockReport.setLayout(border);
		panelStockReport.add(panelStockReportCenter,BorderLayout.CENTER);
		panelStockReportCenter();
		panelStockReport.add(panelStockReportSouth,BorderLayout.SOUTH);
		panelStockReportSouth();
	}
	
	public void panelStockReportCenter()
	{
		GridBagLayout grid=new GridBagLayout();
		panelStockReportCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		
		cn.gridx=0;
		cn.gridy=0;
		lblReporttype.setFont(font);
		panelStockReportCenter.add(lblReporttype,cn);
		
		cn.gridx=1;
		cn.gridy=0;
		cmbReportType.setPreferredSize(new Dimension(300,30));
		panelStockReportCenter.add(cmbReportType,cn);
		cmbReportType.addItem("");
		cmbReportType.addItem("Profit Statement");
		cmbReportType.addItem("Opening Stock");
		cmbReportType.addItem("Purchase Receipt");
		cmbReportType.addItem("Return To Supplier");
		cmbReportType.addItem("Sales");
		cmbReportType.addItem("Sales Return");
	
		cn.gridx=0;
		cn.gridy=1;
		lblCatagory.setFont(font);
		panelStockReportCenter.add(lblProductID,cn);
		
		cn.gridx=1;
		cn.gridy=1;
		cmbCatagory.setPreferredSize(new Dimension(300,30));
		panelStockReportCenter.add(cmbProductID,cn);
		
		cn.gridx=2;
		cn.gridy=1;
		chkCatagoryAll.setFont(font);
		panelStockReportCenter.add(chkProductall,cn);
		
		cn.gridx=0;
		cn.gridy=2;
		lblSubCatagory.setFont(font);
		panelStockReportCenter.add(lblCatagory,cn);
		
		cn.gridx=1;
		cn.gridy=2;
		cmbSubCatagory.setPreferredSize(new Dimension(300,30));
		panelStockReportCenter.add(cmbCatagory,cn);
		
		cn.gridx=2;
		cn.gridy=2;
		chkSubCatagoryAll.setFont(font);
		panelStockReportCenter.add(chkCatagoryAll,cn);
		
		cn.gridx=0;
		cn.gridy=3;
		lblProductID.setFont(font);
		panelStockReportCenter.add(lblSubCatagory,cn);
		
		cn.gridx=1;
		cn.gridy=3;
		cmbProductID.setPreferredSize(new Dimension(300,30));
		panelStockReportCenter.add(cmbSubCatagory,cn);
		
		cn.gridx=2;
		cn.gridy=3;
		chkProductall.setFont(font);
		panelStockReportCenter.add(chkSubCatagoryAll,cn);
		
		cn.gridx=0;
		cn.gridy=4;
		lblTransactionNo.setFont(font);
		panelStockReportCenter.add(lblTransactionNo,cn);
		
		cn.gridx=1;
		cn.gridy=4;
		cmbProductID.setPreferredSize(new Dimension(300,30));
		panelStockReportCenter.add(cmbTransactionNo,cn);	
		
		cn.gridx=0;
		cn.gridy=5;
		lblFromData.setFont(font);
		panelStockReportCenter.add(lblFromData,cn);
		
		cn.gridx=1;
		cn.gridy=5;
		cmbProductID.setPreferredSize(new Dimension(200,30));
		panelStockReportCenter.add(dFromDate,cn);
		dFromDate.setDateFormatString("dd-MM-yyyy");
		dFromDate.setDate(new Date());
		cn.gridx=0;
		cn.gridy=6;
		lblToDate.setFont(font);
		panelStockReportCenter.add(lblToDate,cn);
		
		cn.gridx=1;
		cn.gridy=6;
		cmbProductID.setPreferredSize(new Dimension(200,30));
		panelStockReportCenter.add(dToDate,cn);
		dToDate.setDateFormatString("dd-MM-yyyy");
		dToDate.setDate(new Date());
	}
	public void panelStockReportSouth()
	{
		panelStockReportSouth.setPreferredSize(new Dimension(0,100));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(10);
		panelStockReportSouth.setLayout(flow);
		btnPreviewStockReport.setPreferredSize(new Dimension(120,45));
		panelStockReportSouth.add(btnPreviewStockReport);
		btnPreviewStockReport.setFont(font);
		btnPrintStockReport.setPreferredSize(new Dimension(120,45));
		panelStockReportSouth.add(btnPrintStockReport);
		btnPrintStockReport.setFont(font);
	}
	public void panelCenter()
	{
		panelCenter.setPreferredSize(new Dimension(1140,365));
		BorderLayout border=new BorderLayout();
		panelCenter.setLayout(border);
		border.setHgap(10);
		panelCenter.setLayout(border);
		panelCenter.add(panelClientReport,BorderLayout.WEST);
		panelClientReport();
		panelCenter.add(panelStockReport,BorderLayout.CENTER);
		panelStockReport();
	}
	public void init()
	{
		{
			setPreferredSize(new Dimension(1140,740));
			BorderLayout border=new BorderLayout();
			setLayout(border);
		}
	}
}

