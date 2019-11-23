package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.bean.CommentBean;
import icp.dao.AnnouncementDao;
import icp.dao.CommentDao;

/**
 * Servlet implementation class ShowAnnouncementUI
 */
@WebServlet("/ShowAnnouncementUI")
public class ShowAnnouncementUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String mAnnouncementID;
	private static boolean mCommentAllowed;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAnnouncementUI() {
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
		AnnouncementDao announcementDao = new AnnouncementDao();
		mAnnouncementID = (String) request.getParameter("announcementID");
		AnnouncementBean announcementBean = announcementDao.GetAnnouncementByID(mAnnouncementID);
		announcementBean.SetReadAmount(announcementBean.GetReadAmount() + 1);
		announcementDao.AddAnnouncementReadAmount(mAnnouncementID, announcementBean.GetReadAmount());
		request.setAttribute("announcementTitle", announcementBean.GetAnnouncementTitle());
		request.setAttribute("announcementContent", announcementBean.GetAnnouncementContent());
		int readAmount = announcementBean.GetReadAmount();
		if (readAmount <= 10000)
			request.setAttribute("readAmount", announcementBean.GetReadAmount());
		else
			request.setAttribute("readAmount", "10000+");
		request.setAttribute("publishTime", announcementBean.GetPublishTime());
		mCommentAllowed = announcementBean.GetCommentAllowed();
		request.getRequestDispatcher("/WEB-INF/pages/ShowAnnouncement.jsp").forward(request, response);
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

	public static String ShowComment() {
		if (!mCommentAllowed)
			return "";
		StringBuffer resultStr = new StringBuffer();
		resultStr.append("<div class=\"comt layui-clear\" name=\"comment\">\r\n" + "<p class=\"pull-left\">ÆÀÂÛ</p>\r\n"
				+ "<a href=\"/ICP/AddCommentUI?announcementID=" + mAnnouncementID
				+ "\" class=\"pull-right\" >Ð´ÆÀÂÛ</a>\r\n" + "</div>");
		// show comments
		CommentDao commentDao=new CommentDao();
		List<CommentBean> commentBeans=commentDao.GetComments(mAnnouncementID);
		for (CommentBean commentBean : commentBeans) {
			resultStr.append(
					"<div class=\"info-item\" style=\"position:relative;left:-70px;top:-70px\">\r\n" + 
					"    <div class=\"info-text\">\r\n" + 
					"       <p class=\"title count\">\r\n" + 
					"            <span class=\"name\">"+commentBean.GetUserID()+"</span>\r\n" + 
					"             </p>\r\n" + 
					"       <p class=\"info-intr\">"+commentBean.GetCommentContent()+"</p>\r\n" + 
					"     </div>\r\n" + 
					"</div>");
		}
		
		return resultStr.toString();
	}

}
