package com.jdtx.sort;

/*
 * 登录
 */
public class Logins
{
	private String id; // 主键Id

	private String account; // 帐号

	private String pwd; // 密码

	private String tryCount; // 尝试登录次数

	private String lastTry; // 最后尝试时间

	private String lastLogin; // 最后登录时间

	private String status;// 状态： 0.失败

	private String description; // 失败原因

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getTryCount()
	{
		return tryCount;
	}

	public void setTryCount(String tryCount)
	{
		this.tryCount = tryCount;
	}

	public String getLastTry()
	{
		return lastTry;
	}

	public void setLastTry(String lastTry)
	{
		this.lastTry = lastTry;
	}

	public String getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(String lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	

}
