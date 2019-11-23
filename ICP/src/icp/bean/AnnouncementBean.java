package icp.bean;

public class AnnouncementBean {

	private String mAnnouncementID;
	private String mUserID;
	private String mAnnouncementTitle;
	private String mAnnouncementContent;
	private String mPublishTime;
	private boolean mCommentAllowed;
	private String mAnnouncementTags;
	private String mType;
	private int mReadAmount;

	public AnnouncementBean() {

	}

	public AnnouncementBean(String _announcementID, String _userID, String _announcementTitle,
			String _announcementContent, String _publishTime, boolean _commentAllowed, String _announcementTags,
			String _type, int _readAmount) {
		mAnnouncementID = _announcementID;
		mUserID = _userID;
		mAnnouncementTitle = _announcementTitle;
		mAnnouncementContent = _announcementContent;
		mPublishTime = _publishTime;
		mCommentAllowed = _commentAllowed;
		mAnnouncementTags = _announcementTags;
		mType = _type;
		mReadAmount = _readAmount;
	}

	public String GetAnnouncementID() {
		return mAnnouncementID;
	}

	public void SetAnnouncementID(String _announcementID) {
		mAnnouncementID = _announcementID;
	}

	public String GetUserID() {
		return mUserID;
	}

	public void SetUserID(String _userID) {
		mUserID = _userID;
	}

	public String GetAnnouncementTitle() {
		return mAnnouncementTitle;
	}

	public void SetAnnouncementTitle(String _announcementTitle) {
		mAnnouncementTitle = _announcementTitle;
	}

	public String GetAnnouncementContent() {
		return mAnnouncementContent;
	}

	public void SetAnnouncementContent(String _announcementContent) {
		mAnnouncementContent = _announcementContent;
	}

	public String GetPublishTime() {
		return mPublishTime;
	}

	public void SetPublishTime(String _publishTime) {
		mPublishTime = _publishTime;
	}

	public boolean GetCommentAllowed() {
		return mCommentAllowed;
	}

	public void SetCommentAllowed(boolean _commentAllowed) {
		mCommentAllowed = _commentAllowed;
	}

	public String GetAnnouncementTags() {
		return mAnnouncementTags;
	}

	public void SetAnnouncementTags(String _announcementTags) {
		mAnnouncementTags = _announcementTags;
	}

	public String GetType() {
		return mType;
	}

	public void SetType(String _type) {
		mType = _type;
	}

	public int GetReadAmount() {
		return mReadAmount;
	}

	public void SetReadAmount(int _readAmount) {
		mReadAmount = _readAmount;
	}
}
