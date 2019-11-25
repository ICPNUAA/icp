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
    
    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // �ϴ�����
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
		//��ǰ�˻�����
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
		//���е�tag
		
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
		//��Ϣ�ı�����ɹ�

		// ����Ƿ�Ϊ��ý���ϴ�
        if (!ServletFileUpload.isMultipartContent(request)) {
            // ���������ֹͣ
            PrintWriter writer = response.getWriter();
            writer.println("Error: ��������� enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8"); 

        // ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
        String filePath ="";
         
        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // ���������������ȡ�ļ�����
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // ����������
                for (FileItem item : formItems) {
                    // �����ڱ��е��ֶ�
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // �ڿ���̨����ļ����ϴ�·��
                        System.out.println("�ļ�·����"+filePath);
                        // �����ļ���Ӳ��
                        item.write(storeFile);
                        request.setAttribute("message",
                            "�ļ��ϴ��ɹ�!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "������Ϣ: " + ex.getMessage());
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
