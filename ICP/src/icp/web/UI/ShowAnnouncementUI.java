package icp.web.UI;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.dao.AnnouncementDao;

/**
 * Servlet implementation class ShowAnnouncementUI
 */
@WebServlet("/ShowAnnouncementUI")
public class ShowAnnouncementUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String announcementID;
	private static boolean commentAllowed;

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
		announcementID = (String) request.getParameter("announcementID");
		AnnouncementBean announcementBean = announcementDao.GetAnnouncementByID(announcementID);
		announcementBean.SetReadAmount(announcementBean.GetReadAmount() + 1);
		announcementDao.UpdateAnnouoncement(announcementBean);
		request.setAttribute("announcementTitle", announcementBean.GetAnnouncementTitle());
		request.setAttribute("announcementContent", announcementBean.GetAnnouncementContent());
		int readAmount = announcementBean.GetReadAmount();
		if (readAmount <= 10000)
			request.setAttribute("readAmount", announcementBean.GetReadAmount());
		else
			request.setAttribute("readAmount", "10000+");
		request.setAttribute("publishTime", announcementBean.GetPublishTime());
		commentAllowed = announcementBean.GetCommentAllowed();
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
		if (!commentAllowed)
			return "";
		StringBuffer resultStr=new StringBuffer();
		resultStr.append("<div class=\"comt layui-clear\" name=\"comment\">\r\n" 
				+ "<p class=\"pull-left\">评论</p>\r\n"
				+ "<a href=\"/ICP/AddCommentUI?announcementID=" + announcementID
				+ "\" class=\"pull-right\" >写评论</a>\r\n" + "</div>");
		//show comments
//		"<div class=\"info-item\">\r\n" + 
//		"                                <img class=\"info-img\" src=\"css&js/res/static/images/info-img.png\" alt=\"\">\r\n" + 
//		"                                <div class=\"info-text\">\r\n" + 
//		"                                    <p class=\"title count\">\r\n" + 
//		"                                        <span class=\"name\">同学A</span>\r\n" + 
//		"                                        <span class=\"info-img like\"><i class=\"layui-icon layui-icon-praise\"></i>5.8万</span>\r\n" + 
//		"                                    </p>\r\n" + 
//		"                                    <p class=\"info-intr\">好棒棒哦</p>\r\n" + 
//		"                                </div>\r\n" + 
//		"                            </div>"
		return resultStr.toString();
	}

}
