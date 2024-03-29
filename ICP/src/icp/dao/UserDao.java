package icp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icp.bean.UserBean;
import icp.database.DBUtil;

public class UserDao {
	private Connection conn = null;

	public void DaoImpl(Connection conn) {
		this.conn = conn;
	}

	public UserBean CheckLogin(String username, String password) {
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userinfo where userid='" + username + "'");
			if (resultSet.next()) {
				// Check userid succeed;

				if (resultSet.getString("userpassword").equalsIgnoreCase(password)) {
					userBean = new UserBean();
					userBean.SetUserID(resultSet.getString("userid"));
					userBean.SetPassword(resultSet.getString("userpassword"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return userBean;
	}

	public String Register(String userid, String password, String password2) {
		String sql;
		String message = "";
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		if (userid.equalsIgnoreCase(""))
			message = "用户名不可为空！";
		else if (password.equalsIgnoreCase(""))
			message = "密码不可为空！";
		else if (password2.equalsIgnoreCase(""))
			message = "密码不可为空！";
		else if (!password.equalsIgnoreCase(password2))
			message = "二次输入的密码不同！";
		else {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from userinfo where userid='" + userid + "'");
				if (resultSet.next()) {
					// Check userid succeed;
					message = "改用户名已被占用，请更改！";
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				;
			}
		}

		if (message.equalsIgnoreCase("")) { // TODO: 检查完毕，向数据库插入信息
			try {
				sql = "insert into userinfo values('" + userid + "','" + password + "','0',-1,null,null,0,null)";
				statement.execute(sql);

			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				DBUtil.Close(resultSet, statement, connection);
			}
		}
		return message;

	}

//	public String OfferInfo()
//	{

//	}

	public String[] Top10Tags() {
		String sql = "select * from icpdb.tag order by useNum desc limit 10";
		String message[];
		message = new String[10];
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int i = 0;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				// Check userid succeed;
				message[i] = resultSet.getString("tagName");
				i++;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.Close(resultSet, statement, connection);
			;
		}
		return message;
	}

	public void AddUserInfo(String UserID, int studentnumber, String realname, String UserTags, String filepath) {
		String sql = "";
		String message[];
		message = new String[10];
		Connection connection = DBUtil.GetConnection();
		UserBean userBean = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// update icpdb.userinfo set `studentNumber`= '312',`realName`='132',
		// `userTags`='#交友#音乐#miao ',`VeriTags`='123' where (`userID`='muyuying');
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

	public void VerifyUser(String UserID, String VeriTag, String filepath) {
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

	public List<UserBean> getAllAppli() {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> list = new ArrayList();
		String sql = "select userID from userinfo where isVerified=-1";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				UserBean userBean = new UserBean();
				userBean.SetUserID(resultSet.getString("userID"));
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

	public List<UserBean> getCheckInfo(String UserID) {
		Connection connection = DBUtil.GetConnection();
		List<UserBean> list = new ArrayList();
		String sql = "select CampusCard,VeriTags,VeriPath from userinfo where userID='" + UserID + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				UserBean userBean = new UserBean();
				userBean.SetCampusCard(resultSet.getString("CampusCard"));
				userBean.SetVeriTags(resultSet.getString("VeriTags"));
				userBean.SetVeriPath(resultSet.getString("VeriPath"));
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
}
