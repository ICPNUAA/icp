package icp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import icp.bean.TagBean;
import icp.database.DBUtil;

public class TagDao {

	public static TagBean GetTagByID(String _tagID) {
		TagBean tagBean = new TagBean();
		tagBean.SetTagID(_tagID);

		Connection connection = DBUtil.GetConnection();
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from tag where tagID='" + _tagID + "'");
			if (resultSet.next()) {
				tagBean.SetTagType(resultSet.getBoolean("tagType"));
				tagBean.SetTagName(resultSet.getString("tagName"));
				tagBean.SetUseNum(resultSet.getInt("useNum"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return tagBean;
	}

	// return an exist tag's id or the new tag's id
	public static String AddTag(String _tagName) {
		String tagID = "ERROR";
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();

			// check if tag exist
			resultSet = statement.executeQuery("select * from tag where tagName='" + _tagName + "'");
			if (resultSet.next() && !resultSet.getBoolean("tagType")) {
				// get exist tag's id
				tagID = resultSet.getString("tagID");
				int useNum = resultSet.getInt("useNum");
				++useNum;
				statement.execute("update tag set useNum=" + useNum + " where tagID='" + tagID + "'");
			} else {
				// add new tag
				tagID = UUID.randomUUID().toString().substring(24);
				String sqlstr = "insert into tag values('" + tagID + "',0,'" + _tagName + "',1)";
				statement.execute(sqlstr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return tagID;
	}

	public static boolean VeriTagSuccess(String _tagID) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			result = statement.execute("update tag set tagType=1 where tagID='" + _tagID + "'");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static List<TagBean> GetTagsByLikeName(String _likeName) {
		List<TagBean> tagBeans = new ArrayList<>();
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "select * from tag where tagName like '%" + _likeName + "%'";
			resultSet = statement.executeQuery(sqlstr);
			while (resultSet.next()) {
				TagBean bean = new TagBean();
				bean.SetTagID(resultSet.getString("tagID"));
				bean.SetTagType(resultSet.getBoolean("tagType"));
				bean.SetTagName(resultSet.getString("tagName"));
				bean.SetUseNum(resultSet.getInt("useNum"));
				tagBeans.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return tagBeans;
	}

	public static boolean DeleteTag(String _tagID) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			// tag use num decrease
			resultSet = statement.executeQuery("select * from tag where tagID='" + _tagID + "'");
			if (resultSet.next()) {
				// get exist tag's id
				int useNum = resultSet.getInt("useNum");
				if (useNum > 0)
					--useNum;
				statement.execute("update tag set useNum=" + useNum + " where tagID='" + _tagID + "'");
				statement.execute("delete from tag where tagID='" + _tagID + "' and useNum=0");
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}
}
