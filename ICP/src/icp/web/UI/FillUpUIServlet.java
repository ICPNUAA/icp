package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.UserDao;

@WebServlet("/FillUpUIServlet")
public class FillUpUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FillUpUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		if(request.getSession().getAttribute("userid").equals(""))
//		{	
//			request.setAttribute("message", "ÇëÏÈµÇÂ½£¡");
//			request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
//		}
//		else
//		{
		UserDao userDao=new UserDao();
		String tags[]=userDao.Top10Tags();
		request.setAttribute("label1", tags[0]);
		request.setAttribute("label2", tags[1]);
		request.setAttribute("label3", tags[2]);
		request.setAttribute("label4", tags[3]);
		request.setAttribute("label5", tags[4]);
		request.setAttribute("label6", tags[5]);
		request.setAttribute("label7", tags[6]);
		request.setAttribute("label8", tags[7]);
		request.setAttribute("label9", tags[8]);
		request.setAttribute("label10", tags[9]);
			request.getRequestDispatcher("/WEB-INF/pages/FillUserInfo.jsp").forward(request, response);
//		}
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
