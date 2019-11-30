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

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;

@WebServlet("/ManaCheckUI")
public class ManaCheckUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManaCheckUI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao userDao=new UserDao();
 		String userID=request.getParameter("userID");
 		List<UserBean> list=userDao.getCheckInfo(userID);

		String cpMessage=" InputStream in = getServletContext().getResourceAsStream(\r\n" + 
				"	            \""+list.get(0).GetCampusCard()+"/upload/111.jpg\");\r\n" + 
				"	    BufferedImage bfi = ImageIO.read(in);\r\n" + 
				"	    response.reset();" + 
				"	    response.setContentType(\"image/gif\");\r\n" + 
				"	    ImageIO.write(bfi, \"jpg\", response.getOutputStream());\r\n" + 
				"	    out.clear();\r\n" + 
				"	    out = pageContext.pushBody();";
		
		String vpMessage=" InputStream in = getServletContext().getResourceAsStream(\r\n" + 
				"	            \""+list.get(0).GetVeriPath()+"/upload/111.jpg\");\r\n" + 
				"	    BufferedImage bfi = ImageIO.read(in);\r\n" + 
				"	    response.reset();" + 
				"	    response.setContentType(\"image/gif\");\r\n" + 
				"	    ImageIO.write(bfi, \"jpg\", response.getOutputStream());\r\n" + 
				"	    out.clear();\r\n" + 
				"	    out = pageContext.pushBody();";
		//获取图片path并显示在jsp上
		request.setAttribute("cpMessage", cpMessage);
		request.setAttribute("VeriTags", list.get(0).GetVeriTags());
		request.setAttribute("vpMessage",list.get(0).GetVeriPath());
		request.getRequestDispatcher("/WEB-INF/pages/ManaCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
