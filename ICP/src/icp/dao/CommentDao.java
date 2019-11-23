package icp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import icp.bean.CommentBean;
import icp.database.DBUtil;

public class CommentDao {

	public List<CommentBean> GetComments(String _announcementID) {
		List<CommentBean> resultBeans = new ArrayList<>();
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "select * from comment where announcementID='" + _announcementID + "'";
			resultSet = statement.executeQuery(sqlstr);
			while (resultSet.next()) {
				String commentID = resultSet.getString("commentID");
				String userID = resultSet.getString("userID");
				String commentContent = resultSet.getString("commentContent");
				CommentBean bean = new CommentBean(commentID, _announcementID, userID, commentContent);
				resultBeans.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return resultBeans;
	}

	public boolean AddComment(String _announcementID, String _userID, String _commentContent) {
		boolean result = false;

		String commentId = UUID.randomUUID().toString().substring(24);
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			if (_commentContent.equals(""))
				return false;
			String sqlstr = "insert into comment values('" + commentId + "','" + _announcementID + "','" + _userID
					+ "','" + _commentContent + "')";
			result = statement.execute(sqlstr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public boolean DeleteCommentByAnnouncementID(String _announcementID) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "delete from comment where announcementID='" + _announcementID + "'";
			result = statement.execute(sqlstr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}
}
