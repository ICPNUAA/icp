package icp.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.TagApplyBean;
import icp.bean.UserApplyBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class AdminCheckTagsUI
 */
@WebServlet("/AdminCheckTagsUI")
public class AdminCheckTagsUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckTagsUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/AdminCheckTags.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static String ShowToBeVeriedList() {
		StringBuffer resultStr = new StringBuffer();
		List<TagApplyBean> list = TagDao.GetAllTagApply();
		for (TagApplyBean tagApplyBean : list) {
			resultStr.append(
					"<tr height=\"50px\">\r\n" + 
					"	<td width=\"20%\">\r\n" + 
					TagDao.GetTagByID(tagApplyBean.GetTagID()).GetTagName() + 
					"	</td>\r\n" + 
					"	<td width=\"20%\">\r\n" + 
					tagApplyBean.GetUserID() + 
					"	</td>\r\n" + 
					"	<td width=\"10%\">\r\n" + 
					"		<a href=\"/ICP/ShowCheckTagUI?tagID="+tagApplyBean.GetTagID()+"\">查看详细信息</a>\r\n" + 
					"	</td>\r\n" + 
					"</tr>"
					);
		}
		return resultStr.toString();
	}

}
