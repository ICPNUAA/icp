package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.dao.UserDao;

/**
 * Servlet implementation class VerifyCampusCardUI
 */
@WebServlet("/VerifyCampusCardUI")
public class VerifyCampusCardUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCampusCardUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID=request.getSession().getAttribute("userID").toString();
		if(UserDao.GetUserByID(userID).GetIsVerified()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script language=javascript>");
			response.getWriter().write("alert('账号已通过验证');");
			response.getWriter().write("location.href='/ICP/UserCenterUI';");
			response.getWriter().write("</script>");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/pages/VerifyCampusCard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
