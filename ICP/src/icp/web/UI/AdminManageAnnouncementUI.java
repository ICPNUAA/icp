package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.bean.UserBean;
import icp.dao.AnnouncementDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class AdminManageAnnouncementUI
 */
@WebServlet("/AdminManageAnnouncementUI")
public class AdminManageAnnouncementUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageAnnouncementUI() {
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
		request.setAttribute("searchResult", SearchAnnouncement(searchWord));
		request.getRequestDispatcher("/WEB-INF/pages/AdminManageAnnouncement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static String SearchAnnouncement(String _searchWord) {
		StringBuffer resultStr=new StringBuffer();
		List<AnnouncementBean> announcementBeans=AnnouncementDao.GetAnnouncementsByTitle(_searchWord);
		for (AnnouncementBean bean : announcementBeans) {
			resultStr.append("\r\n" + 
					"			<tr>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetAnnouncementTitle()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetUserID()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"20%\">\r\n" + 
					"					<h3 style=\"font-size: 20px; font-weight: 5px;\">"+bean.GetPublishTime()+"</h3>\r\n" + 
					"				</td>\r\n" + 
					"				<td width=\"10%\"><a href=\"/ICP/ShowAnnouncementUI?announcementID="+bean.GetAnnouncementID()+"\">查看通知</a></td>\r\n" + 
					"				<td width=\"10%\"><a href=\"/ICP/DeleteAnnouncement?announcementID="+bean.GetAnnouncementID()+"\">删除通知</a></td>\r\n" + 
					"			</tr>");
		}
		return resultStr.toString();
	}
}
