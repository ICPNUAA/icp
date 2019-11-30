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
		String message=returnINfo();
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/pages/managerIndex.jsp").forward(request, response);
	}
	public static String returnINfo() 
	{
		String message="";
		UserDao userDao=new UserDao();
		UserBean userBean=new UserBean();
		List<UserBean> list = userDao.getAllAppli();
		//request.setAttribute("applicant", list);
		for(int i=0;i<list.size();i++)
		{
		message+="<tr height=\"70px\">\r\n" + 
				"                <td name=\"userID\" width=\"500px\">\r\n" + 
				"                   来自"+list.get(i).GetUserID()+"用户的申请审核"+
				"                </td>\r\n" + 
				"                <td width=\"100px\">\r\n" + 
				"       <a href=\"/ICP/ManaCheckUI?userID="+
				list.get(i).GetUserID()+
		"\" style=\"font-size:25px;font-family:黑体; color:black;font-weight:5px;width:500spx\">" + 
				"点击审核</a>\r\n"+
				"                </td>\r\n" + 
				"            </tr>";
		}
		return message;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
