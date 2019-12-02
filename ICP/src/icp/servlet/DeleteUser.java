package icp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		boolean result=false;
		HttpSession session = request.getSession(true);
		String UserID=(String) session.getAttribute("userID");
		
		result = UserDao.DeleteUserAll(UserID);
		
		if(result) {
			//sign in succeed
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('注销成功！即将跳转至登陆页面！');");
			response.getWriter().write("location.href='/ICP/LoginUI';");
			response.getWriter().write("</script>");
		}
		else {
			//sign in failed
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('注销失败，重新操作！');");
			response.getWriter().write("location.href='/ICP/LoginUI';");
			response.getWriter().write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}