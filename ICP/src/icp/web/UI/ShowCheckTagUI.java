package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.TagApplyBean;
import icp.bean.TagBean;
import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class ShowCheckTagUI
 */
@WebServlet("/ShowCheckTagUI")
public class ShowCheckTagUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCheckTagUI() {
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
		String tagID = request.getParameter("tagID");
		TagApplyBean tagApplyBean=TagDao.GetTagApply(tagID);
		TagBean tagBean=TagDao.GetTagByID(tagID);
		UserBean userBean=UserDao.GetUserByID(tagApplyBean.GetUserID());
		
		String tagName = tagBean.GetTagName();
		String studentNumber=userBean.GetStudentNumber();
		String realName=userBean.GetRealName();
		String verifyPath=tagApplyBean.GetVerifyPath();
		
		request.setAttribute("tagName", tagName);
		request.setAttribute("studentNumber", studentNumber);
		request.setAttribute("realName", realName);
		request.setAttribute("verifyPath", verifyPath);
		request.setAttribute("tagID", tagID);
		request.getRequestDispatcher("/WEB-INF/pages/ShowCheckTag.jsp").forward(request, response);
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
