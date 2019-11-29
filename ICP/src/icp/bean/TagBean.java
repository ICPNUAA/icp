package icp.bean;

public class TagBean {
	private String mTagID;
	private boolean mTagType;
	private String mTagName;
	private int mUseNum;

	public String GetTagID() {
		return mTagID;
	}

	public void SetTagID(String _tagID) {
		this.mTagID = _tagID;
	}

	public boolean GetTagType() {
		return mTagType;
	}

	public void SetTagType(boolean _tagType) {
		mTagType = _tagType;
	}

	public String GetTagName() {
		return mTagName;
	}

	public void SetTagName(String _tagName) {
		this.mTagName = _tagName;
	}

	public int GetUseNum() {
		return mUseNum;
	}

	public void SetUseNum(int _useNum) {
		mUseNum = _useNum;
	}
}
