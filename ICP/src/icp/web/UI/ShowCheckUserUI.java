package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.UserDao;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;

@WebServlet("/ShowCheckUserUI")
public class ShowCheckUserUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCheckUserUI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		UserBean userBean = UserDao.GetUserByID(userID);
		String imgPath = UserDao.GetCampusCardVerifyApply(userID).GetCampusCardPath();
		request.setAttribute("userID", userID);
		request.setAttribute("studentNumber", userBean.GetStudentNumber());
		request.setAttribute("realName", userBean.GetRealName());
		request.setAttribute("campusCardPath", imgPath);
		request.getRequestDispatcher("/WEB-INF/pages/ShowCheckUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
