package icp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import icp.bean.UserBean;
import icp.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/FillUser")
public class FillUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FillUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从前端获数据
		int i=0;
		String Tags="";
		request.setCharacterEncoding("UTF-8");
		String args1[]= {""};
		args1=request.getParameterValues("label1");
		if(!(args1==null))
			Tags+="#"+args1[0];
		String args2[]= {""};
		args2=request.getParameterValues("label2");
		if(!(args2==null))
			Tags+="#"+args2[0];
		String args3[]= {""};
		args3=request.getParameterValues("label3");
		try {
			if(!(args3==null))
				Tags+="#"+request.getAttribute(args3[0]);
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		String args4[]= {""};
		args4=request.getParameterValues("label4");
		if(!(args4==null))
			Tags+="#"+request.getAttribute(args4[0]);
		String args5[]= {""};
		args5=request.getParameterValues("label5");
		if(!(args5==null))
			Tags+="#"+request.getAttribute(args5[0]);
		String args6[]= {""};
		args6=request.getParameterValues("label6");
		if(!(args6==null))
			Tags+="#"+request.getAttribute(args6[0]);
		String args7[]= {""};
		args7=request.getParameterValues("label7");
		if(!(args7==null))
			Tags+="#"+request.getAttribute(args7[0]);
		String args8[]= {""};
		args8=request.getParameterValues("label8");
		if(!(args8==null))
			Tags+="#"+request.getAttribute(args8[0]);
		String args9[]= {""};
		args9=request.getParameterValues("label9");
		if(!(args9==null))
			Tags+="#"+request.getAttribute(args9[0]);
		String args10[]= {""};
		args10=request.getParameterValues("label10");
		if(!(args10==null))
			Tags+="#"+request.getAttribute(args10[0]);
	
		Tags+=request.getParameter("intro");
		//所有的tag
		
		String RealName = (String) request.getParameter("realname");
		String SStuNumber =  request.getParameter("studentnumber");
		int StuNumber = 0;
		try {
			StuNumber=Integer.parseInt(SStuNumber);
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		String VeriTag=(String) request.getParameter("VeriTag");
		UserDao userDao=new UserDao();
		HttpSession session = request.getSession();
		String UserId=(String) session.getAttribute("userid");
		//信息文本插入成功

		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
        String filePath ="";
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println("文件路径："+filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                            "文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        
        userDao.AddUserInfo(UserId, StuNumber, RealName, Tags,filePath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
