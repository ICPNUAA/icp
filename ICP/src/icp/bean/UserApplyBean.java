package icp.bean;

public class UserApplyBean {
	private String mUserID;
	private String mCampusCardPath;
	private boolean mResult;
	
	public UserApplyBean() {
		
	}
	
	public UserApplyBean(String _userID,String _campusCardPath,boolean _result) {
		mUserID=_userID;
		mCampusCardPath=_campusCardPath;
		mResult=_result;
	}
	
	public void SetUserID(String _userID) {
		mUserID=_userID;
	}
	
	public String GetUserID() {
		return mUserID;
	}
	
	public void SetCampusCardPath(String _campusCardPath) {
		this.mCampusCardPath = _campusCardPath;
	}
	
	public String GetCampusCardPath() {
		return mCampusCardPath;
	}
	
	public void SetResult(boolean _result) {
		this.mResult = _result;
	}
	
	public boolean GetResult() {
		return mResult;
	}
}
