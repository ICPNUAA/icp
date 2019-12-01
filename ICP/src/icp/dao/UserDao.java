package icp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icp.bean.UserBean;
import icp.database.DBUtil;

public class UserDao {
	/*
	 * Return 0: Login Fail Return 1: Normal User Return 2: Administrator
	 */
	public static int CheckLogin(String username, String password) {
		Connection connection = DBUtil.GetConnection();
		int result = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userid='" + username + "'");
			if (resultSet.next()) {
				// Check userid succeed;
				if (resultSet.getString("userpassword").equalsIgnoreCase(password)) {
					if (resultSet.getBoolean("isAdmin"))
						result = 2;
					else
						result = 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return result;
	}

	public static UserBean GetUserByID(String _userID) {
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userid='" + _userID + "'");
			if (resultSet.next()) {
				userBean = new UserBean();
				userBean.SetUserID(resultSet.getString("userid"));
				userBean.SetPassword(resultSet.getString("userpassword"));
				userBean.SetIsAdmin(resultSet.getBoolean("isAdmin"));
				userBean.SetStudentNumber(resultSet.getString("studentNumber"));
				userBean.SetRealName(resultSet.getString("realName"));
				userBean.SetIsVerified(resultSet.getBoolean("isVerified"));
				userBean.SetUserTag(resultSet.getString("userTags"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return userBean;
	}

	public static boolean UpdateUser(UserBean _userBean) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;

		// check if userid exist
		try {
			statement = connection.createStatement();
			String sqlstr = "update userInfo set userPassword='" + _userBean.GetPassword() + "',isAdmin="
					+ _userBean.GetIsAdmin() + ",studentNumber='" + _userBean.GetStudentNumber() + "',realName='"
					+ _userBean.GetRealName() + "',isVerified=" + _userBean.GetIsVerified() + ",userTags='"
					+ _userBean.GetUserTag() + "' where userID='" + _userBean.GetUserID() + "'";
			statement.execute(sqlstr);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static List<UserBean> GetUserByLikeID(String _userID) {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> userBeans = new ArrayList<UserBean>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userid like '%" + _userID + "%'");
			while (resultSet.next()) {
				UserBean tempBean = new UserBean();
				tempBean.SetUserID(resultSet.getString("userid"));
				tempBean.SetPassword(resultSet.getString("userpassword"));
				tempBean.SetIsAdmin(resultSet.getBoolean("isAdmin"));
				tempBean.SetStudentNumber(resultSet.getString("studentNumber"));
				tempBean.SetRealName(resultSet.getString("realName"));
				tempBean.SetIsVerified(resultSet.getBoolean("isVerified"));
				tempBean.SetUserTag(resultSet.getString("userTags"));
				userBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return userBeans;
	}

	public static List<UserBean> GetUserByTags(String _tagName) {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> userBeans = new ArrayList<UserBean>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userTags like '%" + _tagName + "%'");
			while (resultSet.next()) {
				UserBean tempBean = new UserBean();
				tempBean.SetUserID(resultSet.getString("userid"));
				tempBean.SetPassword(resultSet.getString("userpassword"));
				tempBean.SetIsAdmin(resultSet.getBoolean("isAdmin"));
				tempBean.SetStudentNumber(resultSet.getString("studentNumber"));
				tempBean.SetRealName(resultSet.getString("realName"));
				tempBean.SetIsVerified(resultSet.getBoolean("isVerified"));
				tempBean.SetUserTag(resultSet.getString("userTags"));
				userBeans.add(tempBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return userBeans;
	}

	public static boolean Register(String userID, String password, String realName, String studentNumber) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		// check if userid exist
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userID='" + userID + "'");
			if (resultSet.next()) {
				result = false;
			} else {
				String sqlstr = "insert into userinfo values('" + userID + "','" + password + "',0,'" + studentNumber
						+ "','" + realName + "',0,null)";
				statement.execute(sqlstr);
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return result;
	}

	public static boolean AddCampusCardVerifyApply(String _userID, String _filePath) {
		boolean result = false;
		Connection connection = DBUtil.GetConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sqlstr = "insert into userApply values('" + _userID + "','" + _filePath + "',0)";
			statement.execute(sqlstr);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtil.Close(statement, connection);
		}
		return result;
	}

	public static void AddUserInfo(String UserID, int studentnumber, String realname, String UserTags,
			String filepath) {
		String sql = "";
		String message[];
		message = new String[10];
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// update icpdb.userinfo set `studentNumber`= '312',`realName`='132',
		// `userTags`='#Ωª”—#“Ù¿÷#miao ',`VeriTags`='123' where (`userID`='muyuying');
		int i = 0;
		try {
			sql = "update icpdb.userinfo set `studentNumber`= '" + studentnumber + "', `realName`='" + realname
					+ "', `userTags`='" + UserTags + "' where (`userID`='" + UserID + "');";
			statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
			;
		}
	}

	public static void VerifyUser(String UserID, String VeriTag, String filepath) {
		String sql = "";
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			sql = "update icpdb.userinfo set `VeriTags`='" + VeriTag + "',`VeriPath`='" + filepath
					+ "'where (`userID`='" + UserID + "'); ";
			statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
			;
		}
	}

	public static List<UserBean> getAllAppli() {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> list = new ArrayList();
		String sql = "select * from userinfo where isVerified=0";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				UserBean userBean = new UserBean();
				userBean.SetUserID(resultSet.getString("userID"));
				userBean.SetRealName(resultSet.getString("realName"));
				userBean.SetStudentNumber(resultSet.getString("studentNumber"));
				list.add(userBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
			;
		}
		return list;
	}

	public static List<UserBean> getCheckInfo(String _userID) {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> userBeans = new ArrayList();
		String sql = "select * from userapply where userID='" + _userID + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				UserBean userBean = new UserBean();
				userBeans.add(userBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
			;
		}
		return userBeans;
	}
}
