package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.TagBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class ManageMyTagsUI
 */
@WebServlet("/ManageMyTagsUI")
public class ManageMyTagsUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageMyTagsUI() {
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
		request.getRequestDispatcher("WEB-INF/pages/ManageMyTags.jsp").forward(request, response);
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

	public static String ShowMyTags(String _userID) {
		UserDao userDao = new UserDao();
		TagDao tagDao = new TagDao();
		String[] tags = userDao.GetUserByID(_userID).GetUserTag().split("#");
		StringBuffer resultStr = new StringBuffer();
		for (String tagID : tags) {
			if (tagID.equals(""))
				continue;
			TagBean tagBean = tagDao.GetTagByID(tagID);
			resultStr.append("<tr>\r\n" + "	<td><span style=\"color: " + (tagBean.GetTagType() ? "gold" : "black")
					+ "\">" + tagBean.GetTagName() + "</span></td>\r\n" + "	<td><a href=\"/ICP/DeleteUserTag?tagID="
					+ tagBean.GetTagID() + "\">É¾³ý±êÇ©</a></td>\r\n" + "</tr>");
		}
		return resultStr.toString();
	}

}
