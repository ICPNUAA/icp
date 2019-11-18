package icp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import icp.bean.UserBean;
import icp.database.DBUtil;

public class UserDao {

	public UserBean CheckLogin(String username,String password) {
		Connection connection=DBUtil.GetConnection();
		UserBean userBean=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from userinfo where userid='"+username+"'");
			if(resultSet.next()) {
				//Check userid succeed;
				if(resultSet.getString("userpassword").equals(password)) {
					userBean=new UserBean();
					userBean.SetUserName(resultSet.getString("userid"));
					userBean.SetPassword(resultSet.getString("userpassword"));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.Close(resultSet, statement, connection);
		}
		return userBean;
	}
	
}
