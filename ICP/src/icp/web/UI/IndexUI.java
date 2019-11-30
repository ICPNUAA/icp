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
 * Servlet implementation class IndexUI
 */
@WebServlet("/IndexUI")
public class IndexUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/pages/Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static String ShowAnnouncementByType(String _type) {
		StringBuffer stringBuffer = new StringBuffer();
		AnnouncementDao announcementDao = new AnnouncementDao();
		List<AnnouncementBean> announcementBeans = announcementDao.GetAnnouncementsByType(_type);
		for (AnnouncementBean bean : announcementBeans) {
			stringBuffer.append("<div style=\"font-size:20px;height:30px\"><a style=\"width:500px\" href=\"ShowAnnouncementUI?announcementID="
					+ bean.GetAnnouncementID() + "\">" + bean.GetAnnouncementTitle() + "</a></div>");
		}
		return stringBuffer.toString();
	}

}
