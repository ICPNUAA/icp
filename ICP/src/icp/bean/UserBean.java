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

	public void SetUserID(String _userid) {
		this.mUserID = _userid;
	}

	public void SetPassword(String _password) {
		this.mPassword = _password;
	}

	public UserBean() {

	}

	public UserBean(String _userid, String _password) {
		super();
		this.mUserID = _userid;
		this.mPassword = _password;
	}
}
