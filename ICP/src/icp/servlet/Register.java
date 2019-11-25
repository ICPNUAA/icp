package icp.servlet;

import java.io.IOException;
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
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		UserDao userDao=new UserDao();
		String message=userDao.Register(userid, password, password2);
		if(message.equalsIgnoreCase("")) {
			//login fail 
			//注册成功，未提示错误
			
			request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
		}
		else {
			//sign in fall
			request.setAttribute("message", message);//将提示内容送到前端
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			
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
