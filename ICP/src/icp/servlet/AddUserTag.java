package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class AddUserTag
 */
@WebServlet("/AddUserTag")
public class AddUserTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserTag() {
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
		String tagName = request.getParameter("newTagName");
		String tagId = TagDao.AddTag(tagName);

		String userID = request.getSession().getAttribute("userID").toString();
		UserBean userBean = UserDao.GetUserByID(userID);
		String userTags = userBean.GetUserTag();
		if (!userTags.contains("#" + tagId)) {
			userTags += "#" + tagId;
			userBean.SetUserTag(userTags);
			UserDao.UpdateUser(userBean);
		}

		request.getRequestDispatcher("ManageMyTagsUI").forward(request, response);
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

}
