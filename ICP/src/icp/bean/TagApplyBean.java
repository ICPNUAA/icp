package icp.bean;

public class TagApplyBean {
	private String mTagID;
	private String mVeriedPath;
	private boolean mResult;
	
	public TagApplyBean(String _tagID,String _veriedPath,boolean _result) {
		mTagID=_tagID;
		mVeriedPath=_veriedPath;
		mResult=_result;
	}
	
	public void SetTagID(String _tagID) {
		mTagID=_tagID;
	}
	
	public String GetTagID() {
		return mTagID;
	}
	
	public void SetVeriedPath(String _veriedPath) {
		this.mVeriedPath = _veriedPath;
	}
	
	public String GetVeriedPath() {
		return mVeriedPath;
	}
	
	public void SetResult(boolean _result) {
		this.mResult = _result;
	}
	
	public boolean GetResult() {
		return mResult;
	}

}
