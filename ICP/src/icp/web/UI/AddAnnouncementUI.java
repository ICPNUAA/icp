package icp.web.UI;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class AddAnnouncementUI
 */
@WebServlet("/AddAnnouncementUI")
public class AddAnnouncementUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAnnouncementUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/AddAnnouncement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static String GetTagsOptionByUserID(String _userID) {
		StringBuffer resultStr = new StringBuffer();
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.GetUserByID(_userID);
		String[] userTags = userBean.GetUserTag().split("#");

		TagDao tagDao = new TagDao();
		for (String tagid : userTags) {
			if (tagid.equals(""))
				continue;
			resultStr.append("<option value=\"" + tagid + "\">" + tagDao.GetTagByID(tagid).GetTagName() + "</option>");
		}
		return resultStr.toString();
	}
}
