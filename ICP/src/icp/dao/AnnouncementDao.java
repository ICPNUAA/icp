package icp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;

import icp.bean.AnnouncementBean;
import icp.bean.UserBean;
import icp.database.DBUtil;

public class AnnouncementDao {

	public static boolean AddAnnouncement(String _userID, String _announcementTitle, String _announcementContent,
			boolean _commentAllowed, String _announcementTags, String _announcementTypes) {
		String _announcementId = UUID.randomUUID().toString().substring(24);
		Date _publishTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(_publishTime);

		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {

			statement = connection.createStatement();
			String sqlsen = "insert into announcement values('" + _announcementId + "','" + _userID + "','"
					+ _announcementTitle + "','" + _announcementContent + "','" + dateStr + "','"
					+ (_commentAllowed ? 1 : 0) + "','" + _announcementTags + "','" + _announcementTypes + "',0)";
			result = statement.execute(sqlsen);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static AnnouncementBean GetAnnouncementByID(String _announcementID) {
		AnnouncementBean announcementBean = new AnnouncementBean();
		announcementBean.SetAnnouncementID(_announcementID);

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "select * from announcement where announcementID='" + _announcementID + "'";
			resultSet = statement.executeQuery(sqlstr);
			if (resultSet.next()) {
				announcementBean.SetUserID(resultSet.getString("userID"));
				announcementBean.SetAnnouncementTitle(resultSet.getString("announcementTitle"));
				announcementBean.SetAnnouncementContent(resultSet.getString("announcementContent"));
				announcementBean.SetAnnouncementTags(resultSet.getString("announcementTags"));
				announcementBean.SetCommentAllowed(resultSet.getBoolean("commentAllowed"));
				announcementBean.SetPublishTime(resultSet.getString("publishTime"));
				announcementBean.SetReadAmount(resultSet.getInt("readAmount"));
				announcementBean.SetType(resultSet.getString("announcementType"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return announcementBean;
	}

	public static List<AnnouncementBean> GetAnnouncementsByUserID(String _userid) {
		List<AnnouncementBean> announcementBeans = new ArrayList<>();

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String strsql = "select * from announcement where userID='" + _userid + "'";
			resultSet = statement.executeQuery(strsql);
			while (resultSet.next()) {
				// String anID=resultSet.getString("announcementID");
				AnnouncementBean tempBean = new AnnouncementBean(resultSet.getString("announcementID"), _userid,
						resultSet.getString("announcementTitle"), resultSet.getString("announcementContent"),
						resultSet.getString("publishTime"), resultSet.getBoolean("commentAllowed"),
						resultSet.getString("announcementTags"), resultSet.getString("announcementType"),
						resultSet.getInt("readAmount"));
				announcementBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return announcementBeans;
	}

	public static List<AnnouncementBean> GetAnnouncementsByType(String _type) {
		List<AnnouncementBean> announcementBeans = new ArrayList<>();

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String strsql = "select * from announcement where announcementType='" + _type + "' order by readAmount desc limit 50";
			resultSet = statement.executeQuery(strsql);
			while (resultSet.next()) {
				// String anID=resultSet.getString("announcementID");
				AnnouncementBean tempBean = new AnnouncementBean(resultSet.getString("announcementID"),
						resultSet.getString("userID"), resultSet.getString("announcementTitle"),
						resultSet.getString("announcementContent"), resultSet.getString("publishTime"),
						resultSet.getBoolean("commentAllowed"), resultSet.getString("announcementTags"),
						resultSet.getString("announcementType"), resultSet.getInt("readAmount"));
				announcementBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return announcementBeans;
	}
	
	public static List<AnnouncementBean> GetAnnouncementsByTitle(String _title){
		List<AnnouncementBean> announcementBeans = new ArrayList<>();

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String strsql = "select * from announcement where announcementTitle like '%" + _title + "%' order by readAmount desc";
			resultSet = statement.executeQuery(strsql);
			while (resultSet.next()) {
				// String anID=resultSet.getString("announcementID");
				AnnouncementBean tempBean = new AnnouncementBean(resultSet.getString("announcementID"),
						resultSet.getString("userID"), resultSet.getString("announcementTitle"),
						resultSet.getString("announcementContent"), resultSet.getString("publishTime"),
						resultSet.getBoolean("commentAllowed"), resultSet.getString("announcementTags"),
						resultSet.getString("announcementType"), resultSet.getInt("readAmount"));
				announcementBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return announcementBeans;
	}
	
	public static List<AnnouncementBean> GetAnnouncementsByTag(String _tagID){
		List<AnnouncementBean> announcementBeans = new ArrayList<>();

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String strsql = "select * from announcement where announcementTags like '%" + _tagID + "%' order by readAmount desc";
			resultSet = statement.executeQuery(strsql);
			while (resultSet.next()) {
				// String anID=resultSet.getString("announcementID");
				AnnouncementBean tempBean = new AnnouncementBean(resultSet.getString("announcementID"),
						resultSet.getString("userID"), resultSet.getString("announcementTitle"),
						resultSet.getString("announcementContent"), resultSet.getString("publishTime"),
						resultSet.getBoolean("commentAllowed"), resultSet.getString("announcementTags"),
						resultSet.getString("announcementType"), resultSet.getInt("readAmount"));
				announcementBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return announcementBeans;
	}

	public static boolean UpdateAnnouoncement(AnnouncementBean _announcementBean) {
		Date _publishTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		_announcementBean.SetPublishTime(sdf.format(_publishTime));

		Connection connection = DBUtil.GetConnection();
		boolean result = false;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "update announcement set " + "announcementTitle='"
					+ _announcementBean.GetAnnouncementTitle() + "',announcementContent='"
					+ _announcementBean.GetAnnouncementContent() + "',publishTime='"
					+ _announcementBean.GetPublishTime() + "',announcementTags='"
					+ _announcementBean.GetAnnouncementTags() + "',commentAllowed="
					+ (_announcementBean.GetCommentAllowed() ? 1 : 0) + ",announcementType='"
					+ _announcementBean.GetType() + "',readAmount=" + _announcementBean.GetReadAmount()
					+ " where announcementID='" + _announcementBean.GetAnnouncementID() + "'";
			result = statement.execute(sqlstr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static boolean DeleteAnnouncement(String _announcementID) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {

			statement = connection.createStatement();
			String sqlsen = "delete from announcement where announcementID='" + _announcementID + "'";
			result = statement.execute(sqlsen);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static boolean AddAnnouncementReadAmount(String _id, int _amount) {
		boolean result = false;

		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();

			result = statement
					.execute("update announcement set readAmount=" + _amount + " where announcementID='" + _id + "'");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}
}
