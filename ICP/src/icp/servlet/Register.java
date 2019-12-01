package icp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		String userid=request.getParameter("userID");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String realName=request.getParameter("realName");
		String studentNumber=request.getParameter("studentNumber");
		if(userid.isEmpty()||password.isEmpty()||realName.isEmpty()||studentNumber.isEmpty()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('输入不可为空！请检查输入！');");
			response.getWriter().write("location.href='/ICP/RegisterUI';");
			response.getWriter().write("</script>");
			return;
		}
		if(!password.equals(password2)) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('两次密码输入不一致！请重新输入！');");
			response.getWriter().write("location.href='/ICP/RegisterUI';");
			response.getWriter().write("</script>");
			return;
		}
		UserDao userDao=new UserDao();
		boolean result=userDao.Register(userid, password, realName,studentNumber);
		if(result) {
			//sign in succeed
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('注册成功！即将跳转至登陆页面！');");
			response.getWriter().write("location.href='/ICP/LoginUI';");
			response.getWriter().write("</script>");
		}
		else {
			//sign in failed
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('该用户名已存在！');");
			response.getWriter().write("location.href='/ICP/RegisterUI';");
			response.getWriter().write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
