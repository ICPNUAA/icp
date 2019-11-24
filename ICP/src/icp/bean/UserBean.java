package icp.bean;

import java.util.Date;

public class UserBean {

	private String mUserID;
	private String mPassword;
	private boolean mIsAdmin;
	private String mStudentNumber;
	private String mRealName;
	private String mUserTag;
	private boolean mIsVerified;
	
	public String GetUserID() {
		return mUserID;
	}
	
	public String GetPassword() {
		return mPassword;
	}
	public String GetStudentNumber() {
		return mStudentNumber;
	}
	public String GetRealName() {
		return mRealName;
	}
	public String GetUserTag() {
		return mUserTag;
	}
	public boolean GetIsAdmin() {
		return mIsAdmin;
	}
	public boolean GetIsVerified() {
		return mIsVerified;
	}
	
	
	
	
	
	
	
	public void SetUserID(String _userid) {
		this.mUserID=_userid;
	}
	
	public void SetPassword(String _password) {
		this.mPassword=_password;
	}
	
	public void SetStudentNumber(String _studentnumber) {
		this.mStudentNumber=_studentnumber;
	}
	
	public void SetRealName(String _realname) {
		this.mRealName=_realname;
	}
	
	public void SetUserTag(String _usertag) {
		this.mUserTag=_usertag;
	}
	
	public void SetIsAdmin(boolean _isadmin) {
		this.mIsAdmin=_isadmin;
	}
	
	public void SetIsVerified(boolean _isverified) {
		this.mIsVerified=_isverified;
	}
	
	

	public UserBean() {
		
	}
	
	public UserBean(String _userid,String _password,boolean _isadmin,
			String _studentnumber,String _realname,String _usertag,
			boolean _isverified) {
		super();
		this.mUserID=_userid;
		this.mPassword=_password;
		this.mIsAdmin=_isadmin;
		this.mStudentNumber=_studentnumber;
		this.mRealName=_realname;
		this.mUserTag=_usertag;
		this.mIsVerified=_isverified;
	}
}
