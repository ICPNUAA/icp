package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import icp.bean.UserBean;

@WebServlet("/LoginUIServlet")
public class OpenIndexUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OpenIndexUI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
