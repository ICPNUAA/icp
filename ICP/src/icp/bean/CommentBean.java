package icp.bean;

public class CommentBean {
	private String mCommentID;
	private String mAnnouncementID;
	private String mUserID;
	private String mCommentContent;
	private int mLikeAmount;

	public CommentBean() {

	}

	public CommentBean(String _commentID, String _announcementID, String _userID, String _commentContent,
			int _liskAmount) {
		mCommentID = _commentID;
		mCommentContent = _commentContent;
		mAnnouncementID = _announcementID;
		mUserID = _userID;
		mLikeAmount = _liskAmount;
	}
	
	public String GetCommentID() {
		return mCommentID;
	}
	
	public void SetCommentID(String _commentID) {
		this.mCommentID = _commentID;
	}
	
	public String GetAnnouncementID() {
		return mAnnouncementID;
	}
	
	public void SetAnnouncementID(String _announcementID) {
		this.mAnnouncementID = _announcementID;
	}
	
	public String GetUserID() {
		return mUserID;
	}
	
	public void SetUserID(String _userID) {
		this.mUserID = _userID;
	}
	
	public String GetCommentContent() {
		return mCommentContent;
	}
	
	public void setmCommentContent(String _commentContent) {
		this.mCommentContent = _commentContent;
	}
	
	public int GetLikeAmount() {
		return mLikeAmount;
	}
	
	public void SetLikeAmount(int _likeAmount) {
		this.mLikeAmount = _likeAmount;
	}
}
