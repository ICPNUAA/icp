package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.dao.CommentDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID=(String) request.getSession().getAttribute("userID");
		// TODO Auto-generated method stub
		if(userID==null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('请先登录！');");
			response.getWriter().write("location.href='/ICP/LoginUI';");
			response.getWriter().write("</script>");
			return;
		}
		if(!UserDao.GetUserByID(userID).GetIsVerified()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('请先验证身份！');");
			response.getWriter().write("location.href='/ICP/UserCenterUI';");
			response.getWriter().write("</script>");
		}
		if(request.getSession().getAttribute("token")!=null) {
			request.getSession().removeAttribute("token");
			
			String _announcementID = request.getParameter("announcementID");
			String _userID = (String) request.getSession().getAttribute("userID");
			String _commentContent = request.getParameter("commentContent");
			CommentDao commentDao = new CommentDao();
			commentDao.AddComment(_announcementID, _userID, _commentContent);
		}
		request.getRequestDispatcher("ShowAnnouncementUI").forward(request, response);
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
