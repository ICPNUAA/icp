package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class DeleteUserTag
 */
@WebServlet("/DeleteUserTag")
public class DeleteUserTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tagID=request.getParameter("tagID");
		
		String userID=request.getSession().getAttribute("userID").toString();
		UserBean userBean=UserDao.GetUserByID(userID);
		String userTags=userBean.GetUserTag();
		userTags = userTags.replaceAll("#"+tagID, "");
		userBean.SetUserTag(userTags);
		UserDao.UpdateUser(userBean);
		
		TagDao.DeleteTag(tagID);
		
		request.getRequestDispatcher("ManageMyTagsUI").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
