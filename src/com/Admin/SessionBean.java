package com.Admin;

public class SessionBean 
{
	
	private String username;
	private String companyname;
	private String companyadress;
	private String devloperadress;
	private String usertype;
	public void setusername(String name)
	{
		this.username=name;
	}
	public void setusertype(String name)
	{
		this.usertype=name;
	}
	
	public void setcompanyname(String cname)
	{
		this.companyname=cname;
	}
	
	public void setucompanyadress(String cadress)
	{
		this.companyadress=cadress;
	}
	
	
	public void setdevloperadress(String devadress)
	{
		this.devloperadress=devadress;
	}

	public String getusername()
	{
		return username;
	}
	public String getusertype()
	{
		return usertype;
	}
	
	public String getcompanyname()
	{
		return companyname;
	}
	
	public String getcompanyadress()
	{
		return companyadress;
	}
	
	public String getdevloperadress()
	{
		return devloperadress;
	}

}
