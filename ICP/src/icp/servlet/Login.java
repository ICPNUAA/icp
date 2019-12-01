package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import icp.bean.UserBean;
import icp.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		String userid = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		int loginResult = userDao.CheckLogin(userid, password);
		if (loginResult == 0) {
			// login fail
			request.getRequestDispatcher("LoginUI").forward(request, response);
		} else if(loginResult == 1){
			// login succeed: normal user
			HttpSession session = request.getSession(true);
			session.setAttribute("userID", userid);
			request.getRequestDispatcher("IndexUI").forward(request, response);
		}
		else if(loginResult == 2){
			// login succeed: administrator
			request.getRequestDispatcher("AdminCheckUsersUI").forward(request, response);
		}
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
