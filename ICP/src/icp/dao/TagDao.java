package icp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import icp.bean.TagBean;
import icp.database.DBUtil;

public class TagDao {

	public TagBean GetTagByID(String _tagID) {
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
	public String AddTag(String _tagName) {
		String tagID = "ERROR";
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();

			// check if tag exist
			resultSet = statement.executeQuery("select * from tag where tagName='" + _tagName + "'");
			if (resultSet.next()) {
				// get exit tag's id
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

	public boolean VeriTagSuccess(String _tagID) {
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
}
