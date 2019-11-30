package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import icp.bean.UserBean;

import icp.bean.AnnouncementBean;
public class OpenIndexUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public OpenIndexUI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean userBean=new UserBean();
		HttpSession session = request.getSession();
		String UserId=(String) session.getAttribute("userID");
		session.setAttribute("userID", userBean.GetUserID());
		request.getRequestDispatcher("/WEB-INF/pages/Index.jsp").forward(request, response);
	}

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
