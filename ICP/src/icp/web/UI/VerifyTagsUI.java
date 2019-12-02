package icp.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

@WebServlet("/VerifyTagsUI")
public class VerifyTagsUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VerifyTagsUI() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/VerifyTags.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static String ShowMyTagsOption(String _userID) {
		StringBuffer resultStr = new StringBuffer();
		UserBean userBean = UserDao.GetUserByID(_userID);
		String[] tags = userBean.GetUserTag().split("#");
		for (String tagID : tags) {
			if (tagID.equals("") || TagDao.GetTagByID(tagID).GetTagType())
				continue;
			resultStr.append("<option value=\"" + tagID + "\">" + TagDao.GetTagByID(tagID).GetTagName() + "</option>");
		}
		return resultStr.toString();
	}
}
