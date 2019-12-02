package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.bean.TagBean;
import icp.bean.UserBean;
import icp.dao.AnnouncementDao;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class UserInfoUI
 */
@WebServlet("/UserInfoUI")
public class UserInfoUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUI() {
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
		String userID=request.getParameter("userID");
		UserBean userBean=UserDao.GetUserByID(userID);
		
		// show tags
		if (userBean.GetUserTag()!=null) {
			String[] tagsID = userBean.GetUserTag().split("#");
			StringBuffer officialTags = new StringBuffer();
			StringBuffer normalTags = new StringBuffer();
			for (String tagID : tagsID) {
				if (tagID.equals(""))
					continue;
				TagBean bean = TagDao.GetTagByID(tagID);
				if (bean.GetTagType()) {
					officialTags.append("#" + bean.GetTagName() + " ");
				} else {
					normalTags.append("#" + bean.GetTagName() + " ");
				}
			}
			request.setAttribute("officialTags", officialTags.toString());
			request.setAttribute("normalTags", normalTags.toString());
		}

		request.getRequestDispatcher("WEB-INF/pages/UserInfo.jsp").forward(request, response);
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
	
	public static String ShowMyAnnouncement(String _userID) {
		List<AnnouncementBean> announcementBeans = AnnouncementDao.GetAnnouncementsByUserID(_userID);
		StringBuffer resultStr = new StringBuffer();
		int i=0;
		for (AnnouncementBean announcementBean : announcementBeans) {
			++i;
			resultStr.append(
							"<tr height=\"55px\">\r\n" + 
							"   <td >\r\n" + 
							"       <a href=\"/ICP/ShowAnnouncementUI?announcementID="+
									announcementBean.GetAnnouncementID()+
							"\" style=\"font-size:25px;font-family:ºÚÌå; color:black;font-weight:5px;width:400px\">"+
									i+"¡¢"+announcementBean.GetAnnouncementTitle()+
							"</a>\r\n" + 
							"   </td>\r\n" + 
							"</tr>"
							);
		}
		return resultStr.toString();
	}

}
