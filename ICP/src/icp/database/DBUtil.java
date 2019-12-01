package icp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class DBUtil {
	public static String mDBUrl="jdbc:mysql://localhost:3306/icpdb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	
	public static String mDBUser="root";
	
	public static String mDBPassword="123456";
	
	public static Connection GetConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(mDBUrl,mDBUser,mDBPassword);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void Close(Statement statement, Connection connection) {
		if(statement!=null) {
			try {
				statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	 public static void closeConn(Connection conn) {
	        if (null != conn) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                System.out.println("πÿ±’¡¨Ω” ß∞‹£°");
	                e.printStackTrace();
	            }
	        }
	    }
	
	public static void Close(ResultSet resultSet,Statement statement,Connection connection) {
		if(resultSet!=null) {
			try {
				resultSet.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement!=null) {
			try {
				statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
