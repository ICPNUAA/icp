package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.AnnouncementBean;
import icp.dao.AnnouncementDao;

/**
 * Servlet implementation class AddCommentUI
 */
@WebServlet("/AddCommentUI")
public class AddCommentUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnnouncementDao announcementDao = new AnnouncementDao();
		String announcementID = (String) request.getParameter("announcementID");
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
		request.getRequestDispatcher("/WEB-INF/pages/AddComment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
