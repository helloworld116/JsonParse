package com.jdtx.sort;

/*
 * ��¼
 */
public class Logins
{
	private String id; // ����Id

	private String account; // �ʺ�

	private String pwd; // ����

	private String tryCount; // ���Ե�¼����

	private String lastTry; // �����ʱ��

	private String lastLogin; // ����¼ʱ��

	private String status;// ״̬�� 0.ʧ��

	private String description; // ʧ��ԭ��

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
