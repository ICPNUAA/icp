package icp.bean;

public class TagApplyBean {
	private String mTagID;
	private String mUserID;
	private String mVerifyPath;
	private boolean mResult;

	public TagApplyBean() {

	}

	public TagApplyBean(String _tagID, String _userID, String _verifyPath, boolean _result) {
		mTagID = _tagID;
		mUserID = _userID;
		mVerifyPath = _verifyPath;
		mResult = _result;
	}

	public void SetTagID(String _tagID) {
		mTagID = _tagID;
	}

	public String GetTagID() {
		return mTagID;
	}

	public void SetUserID(String _userID) {
		mUserID = _userID;
	}

	public String GetUserID() {
		return mUserID;
	}

	public void SetVerifyPath(String _verifyPath) {
		this.mVerifyPath = _verifyPath;
	}

	public String GetVerifyPath() {
		return mVerifyPath;
	}

	public void SetResult(boolean _result) {
		this.mResult = _result;
	}

	public boolean GetResult() {
		return mResult;
	}

}
