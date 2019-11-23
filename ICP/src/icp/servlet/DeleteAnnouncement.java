package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.dao.AnnouncementDao;
import icp.dao.CommentDao;

/**
 * Servlet implementation class DeleteAnnouncement
 */
@WebServlet("/DeleteAnnouncement")
public class DeleteAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAnnouncement() {
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
		String announcementID = request.getParameter("announcementID");
		
		//delete announcement
		AnnouncementDao announcementDao = new AnnouncementDao();
		announcementDao.DeleteAnnouncement(announcementID);
		
		//delete comment
		CommentDao commentDao=new CommentDao();
		commentDao.DeleteCommentByAnnouncementID(announcementID);
		
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
