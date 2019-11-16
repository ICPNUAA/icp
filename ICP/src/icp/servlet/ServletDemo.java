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
@WebServlet(urlPatterns="/ServletDemo",initParams={@WebInitParam(name="username",value="����"),@WebInitParam(name="password",value="123456")})
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String aname;
	String apassword;
	
	public void init(ServletConfig config) throws ServletException {
        //��ȡ��ʼֵ
		aname=config.getInitParameter("username");
		apassword=config.getInitParameter("password");
  }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset=UTF-8");
    	response.getWriter().print("name: " + aname + "<br/>" + "password: " + apassword);
    	/**
    	 * ʹ��response.setCharacterEncoding("UTF-8");ֻ�������ַ��ı��뷽ʽ��
    	 * ֻ����"\n"���л��У�
    	 * ��ʹ��response.setContentType("text/html;charset=UTF-8");����ָ���ı����ͣ�ͬʱ�������ַ��ı��뷽ʽ��
    	 * ��˳�����"\n"���������ı����"<br/>"���л��У�
    	 * ʹ��response.setHeader("content-type", "text/html;charset=UTF-8");���Զ���Ӧͷ��ÿһ���Խ��е���
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
