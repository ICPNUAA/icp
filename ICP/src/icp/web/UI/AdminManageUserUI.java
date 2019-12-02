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

/**
 * Servlet implementation class AdminManageUser
 */
@WebServlet("/AdminManageUserUI")
public class AdminManageUserUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageUserUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchWord = request.getParameter("searchWord");
		if(searchWord==null) {
			searchWord="";
		}else {
			request.setAttribute("searchWord", searchWord);
		}
		request.setAttribute("searchResult", SearchUsers(searchWord));
		request.getRequestDispatcher("/WEB-INF/pages/AdminManageUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static String SearchUsers(String _keyWord) {
		StringBuffer resultStr=new StringBuffer();
		List<UserBean> userBeans=UserDao.GetUserByLikeID(_keyWord);
		for (UserBean bean : userBeans) {
			if(bean.GetIsAdmin())
				continue;
			resultStr.append("\r\n" + 
					"			<tr>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetUserID()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetRealName()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetStudentNumber()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"10%\"><a href=\"/ICP/DeleteUserByAdmin?userID="+bean.GetUserID()+"\">×¢ÏúÓÃ»§</a></td>\r\n" + 
					"			</tr>");
		}
		return resultStr.toString();
	}

}
