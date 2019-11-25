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
import icp.database.DBUtil;

@WebServlet("/ManaIndexUIServlet")
public class ManaIndexUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManaIndexUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		List<UserBean> list = userDao.getAllAppli();
		request.setAttribute("applicant", list);
		request.getRequestDispatcher("/WEB-INF/pages/managerIndex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
