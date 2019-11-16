package icp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet(urlPatterns="/ServletDemo",initParams={@WebInitParam(name="username",value="张三"),@WebInitParam(name="password",value="123456")})
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String aname;
	String apassword;
	
	public void init(ServletConfig config) throws ServletException {
        //获取初始值
		aname=config.getInitParameter("username");
		apassword=config.getInitParameter("password");
  }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset=UTF-8");
    	response.getWriter().print("name: " + aname + "<br/>" + "password: " + apassword);
    	/**
    	 * 使用response.setCharacterEncoding("UTF-8");只是设置字符的编码方式，
    	 * 只能用"\n"进行换行；
    	 * 而使用response.setContentType("text/html;charset=UTF-8");用于指定文本类型，同时设置了字符的编码方式，
    	 * 因此除了用"\n"还可以用文本标记"<br/>"进行换行；
    	 * 使用response.setHeader("content-type", "text/html;charset=UTF-8");可以对响应头的每一属性进行调整
    	 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
