package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.dao.AnnouncementDao;
import icp.dao.TagDao;

/**
 * Servlet implementation class AddAnnouncement
 */
@WebServlet("/AddAnnouncement")
public class AddAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAnnouncement() {
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
		if (request.getSession().getAttribute("token") != null) {
			request.getSession().removeAttribute("token");

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String userid = (String) request.getSession(true).getAttribute("userID");
			String commentallowed = request.getParameter("commentAllowed");
			
			//deal with tags name
			String tags = "#" + request.getParameter("myTags");
			String[] tagNames = request.getParameter("tags").split("#");
			TagDao tagDao=new TagDao();
			for (String name : tagNames) {
				if(name.equals(""))
					continue;
				tags+="#"+tagDao.AddTag(name);
			}
			String types = request.getParameter("announcementType");
			AnnouncementDao announcementDao = new AnnouncementDao();
			announcementDao.AddAnnouncement(userid, title, content, (commentallowed.equals("on") ? true : false), tags,
					types);
		}
		request.getRequestDispatcher("MyAnnouncementUI").forward(request, response);
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
