package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.UserDao;
import icp.database.DBUtil;

@WebServlet("/AdminCheckUsersUI")
public class AdminCheckUsersUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminCheckUsersUI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/AdminCheckUsers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static String ShowToBeVeriedList() {
		StringBuffer resultStr = new StringBuffer();
		UserDao userDao = new UserDao();
		List<UserBean> list = userDao.getAllAppli();
		for (UserBean userBean : list) {
			resultStr.append(
					"<tr height=\"50px\">\r\n" + 
					"	<td width=\"20%\">\r\n" + 
					userBean.GetUserID() + 
					"	</td>\r\n" + 
					"	<td width=\"20%\">\r\n" + 
					userBean.GetRealName() + 
					"	</td>\r\n" + 
					"	<td width=\"20%\">\r\n" + 
					userBean.GetStudentNumber() + 
					"	</td>\r\n" + 
					"	<td width=\"10%\">\r\n" + 
					"		<a href=\"/ICP/ManaCheckUI?userID="+userBean.GetUserID()+"\">查看详细信息</a>\r\n" + 
					"	</td>\r\n" + 
					"</tr>"
					);
		}
		return resultStr.toString();
	}

}
