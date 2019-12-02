package icp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import icp.database.DBUtil;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
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
		String keyWord = request.getParameter("keyWord");
		String searchType = request.getParameter("searchType");
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("searchType", searchType);
		request.getRequestDispatcher("WEB-INF/pages/SearchResult.jsp").forward(request, response);
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

	public static String ShowSearchResult(String _keyWord, String _searchType) {
		StringBuffer resultStr = new StringBuffer();
		if (_searchType.equals("通知")) {
			// search announcement
			List<AnnouncementBean> announcementBeans = AnnouncementDao.GetAnnouncementsByTitle(_keyWord);
			if (announcementBeans.size() > 100) {
				announcementBeans = announcementBeans.subList(0, 100);
			}
			for (AnnouncementBean bean : announcementBeans) {
				resultStr.append("<tr height=\"40px\">\r\n" + "   <td >\r\n"
						+ "       <a href=\"/ICP/ShowAnnouncementUI?announcementID=" + bean.GetAnnouncementID()
						+ "\" style=\"font-size:25px;font-family:黑体; color:black;font-weight:5px;width:500px\">"
						+ bean.GetAnnouncementTitle() + "</a>\r\n" + "   </td>\r\n" + "</tr>");
			}
		} else if (_searchType.equals("用户")) {
			// search user
			List<UserBean> userBeans = UserDao.GetUserByLikeID(_keyWord);
			if (userBeans.size() > 100) {
				userBeans = userBeans.subList(0, 100);
			}
			for (UserBean bean : userBeans) {
				if(bean.GetIsAdmin())
					continue;
				resultStr.append("<tr height=\"40px\">\r\n" + "   <td >\r\n" + "       <a href=\"/ICP/UserInfoUI?userID="
						+ bean.GetUserID()
						+ "\" style=\"font-size:25px;font-family:黑体; color:black;font-weight:5px;width:500px\">"
						+ bean.GetUserID() + "</a>\r\n" + "   </td>\r\n" + "</tr>");
			}
		} else {
			// search tags
			List<TagBean> tagBeans = TagDao.GetTagsByLikeName(_keyWord);
			//tag num should less than 10
			if (tagBeans.size() > 10) {
				tagBeans = tagBeans.subList(0, 10);
			}
			
			List<AnnouncementBean> announcementBeans = new ArrayList<>();
			List<UserBean> userBeans = new ArrayList<>();
			for (TagBean tagBean : tagBeans) {
				// for each tag get announcement
				announcementBeans.addAll(AnnouncementDao.GetAnnouncementsByTag(tagBean.GetTagID()));
				if (announcementBeans.size() > 100) {
					announcementBeans = announcementBeans.subList(0, 100);
				}
				// for each tag get userinfo
				userBeans.addAll(UserDao.GetUserByTags(tagBean.GetTagID()));
				if (userBeans.size() > 100) {
					userBeans = userBeans.subList(0, 100);
				}
			}
			
			//insert announcement into resultStr
			resultStr.append("<tr height=\"55px\">\r\n" + 
					"					<td width=\"1000px\">\r\n" + 
					"						<h5\r\n" + 
					"							style=\"font-size: 25px; font-family: 黑体; color: black; font-weight: 5px;\">含类似标签的通知</h5>\r\n" + 
					"					</td>\r\n" + 
					"				</tr>");
			for (AnnouncementBean bean : announcementBeans) {
				resultStr.append("<tr height=\"40px\">\r\n" + "   <td >\r\n"
						+ "       <a href=\"/ICP/ShowAnnouncementUI?announcementID=" + bean.GetAnnouncementID()
						+ "\" style=\"font-size:25px;font-family:黑体; color:black;font-weight:5px;width:500px\">"
						+ bean.GetAnnouncementTitle() + "</a>\r\n" + "   </td>\r\n" + "</tr>");
			}
			//insert userinfo into resultStr
			resultStr.append("<tr height=\"55px\">\r\n" + 
					"					<td width=\"1000px\">\r\n" + 
					"						<h5\r\n" + 
					"							style=\"font-size: 25px; font-family: 黑体; color: black; font-weight: 5px;\">含类似标签的用户</h5>\r\n" + 
					"					</td>\r\n" + 
					"				</tr>");
			for (UserBean bean : userBeans) {
				if(bean.GetIsAdmin())
					continue;
				resultStr.append("<tr height=\"40px\">\r\n" + "   <td >\r\n" + "       <a href=\"/ICP/UserInfoUI?userID="
						+ bean.GetUserID()
						+ "\" style=\"font-size:25px;font-family:黑体; color:black;font-weight:5px;width:500px\">"
						+ bean.GetUserID() + "</a>\r\n" + "   </td>\r\n" + "</tr>");
			}
		}
		return resultStr.toString();
	}
}
