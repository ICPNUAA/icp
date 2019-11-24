package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.dao.AnnouncementDao;

/**
 * Servlet implementation class MyAnnouncementUI
 */
@WebServlet("/MyAnnouncementUI")
public class MyAnnouncementUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyAnnouncementUI() {
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
		request.getRequestDispatcher("/WEB-INF/pages/MyAnnouncement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub\
		doGet(request, response);
	}
	
	public static String ShowMyAnnouncement(String _userID) {
		AnnouncementDao announcementDao = new AnnouncementDao();
		List<AnnouncementBean> announcementBeans = announcementDao.GetAnnouncementsByUserID(_userID);
		StringBuffer resultStr = new StringBuffer();
		int i=0;
		for (AnnouncementBean announcementBean : announcementBeans) {
			++i;
			resultStr.append(
							"<tr height=\"55px\">\r\n" + 
							"   <td >\r\n" + 
							"       <a href=\"/ICP/ShowAnnouncementUI?announcementID="+
									announcementBean.GetAnnouncementID()+
							"\" style=\"font-size:25px;font-family:ºÚÌå; color:black;font-weight:5px;width:500px\">"+
									i+"¡¢"+announcementBean.GetAnnouncementTitle()+
							"</a>\r\n" + 
							"   </td>\r\n" + 
							"   <td >\r\n" + 
							"       <a href=\"/ICP/DeleteAnnouncement?announcementID=" + 
									announcementBean.GetAnnouncementID() + 
							"		\"  onclick=\"alert('É¾³ý³É¹¦')\">É¾³ý</a>\r\n" + 
							"   </td>" + 
							"</tr>"
							);
		}
		return resultStr.toString();
	}

}
