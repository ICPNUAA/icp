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
 * Servlet implementation class ShowAnnouncementByTypeUI
 */
@WebServlet("/ShowAnnouncementByTypeUI")
public class ShowAnnouncementByTypeUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAnnouncementByTypeUI() {
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
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		request.setAttribute("showAnnouncementByType", ShowAnnouncementByType(type));
		request.getRequestDispatcher("/WEB-INF/pages/ShowAnnouncementByType.jsp").forward(request, response);
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
	
	public static String ShowAnnouncementByType(String _type) {
		StringBuffer stringBuffer = new StringBuffer();
		List<AnnouncementBean> announcementBeans = AnnouncementDao.GetAnnouncementsByType(_type);
		for (AnnouncementBean bean : announcementBeans) {
			stringBuffer.append(
					"<tr height=\"55px\">\r\n" + 
					"   <td >\r\n" + 
					"       <a href=\"/ICP/ShowAnnouncementUI?announcementID="+
							bean.GetAnnouncementID()+
					"\" style=\"font-size:25px;font-family:ºÚÌå; color:black;font-weight:5px;width:500px\">"+
							bean.GetAnnouncementTitle()+
					"</a>\r\n" + 
					"   </td>\r\n" + 
					"</tr>"
					);
		}
		return stringBuffer.toString();
	}
}
