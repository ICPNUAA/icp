package icp.bean;

import java.util.Date;

public class UserBean {

	private String mUserName;
	private String mPassword;
	
	public String GetUserName() {
		return mUserName;
	}
	
	public String GetPassword() {
		return mPassword;
	}
	
	public void SetUserName(String _username) {
		this.mUserName=_username;
	}
	
	public void SetPassword(String _password) {
		this.mPassword=_password;
	}
	
	public UserBean() {
		
	}
	
	public UserBean(String _username,String _password) {
		super();
		this.mUserName=_username;
		this.mPassword=_password;
	}
}
