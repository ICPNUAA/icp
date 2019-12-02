package icp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import icp.bean.UserBean;
import icp.dao.TagDao;
import icp.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/VerifyTags")
public class VerifyTags extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "uploadfile";
 
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyTags() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tagID="";
		
		HttpSession session = request.getSession();
		String UserId=(String) session.getAttribute("userID");
		// �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); 
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        //**************************
        /*  List<FileItem> li = null;
        try {
            li = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        int m = 0;
        if (li != null) {
            Iterator<FileItem> iter = li.iterator();
            while (iter.hasNext()) {
                FileItem fi = (FileItem) iter.next();
                if (fi.isFormField()) {
                	String name=fi.getFieldName();
                	tagID=fi.getString("utf-8");
                    Vector<String> vec = new Vector<String>();
                    String intro = fi.getFieldName();
                }
            }
        }*/
        //****************************
         
        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8"); 

        // ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
        //String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
        String uploadPath=getServletContext().getRealPath("/images");
        String filePath ="";
         
        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
     // ����Ƿ�Ϊ��ý���ϴ�
     		if (!(ServletFileUpload.isMultipartContent(request))) {
                 // ���������ֹͣ
                 PrintWriter writer = response.getWriter();
                 writer.println("Error: ��������� enctype=multipart/form-data");
                 writer.flush();
                 return;
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
                    else if(item.isFormField())
                    {
                    	tagID=item.getString("utf-8");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "������Ϣ: " + ex.getMessage());
        }
        int index=filePath.indexOf("\\ICP");
        filePath=filePath.substring(index);
        String filepath=filePath.replaceAll("\\\\","\\\\\\\\");  
        
        TagDao.AddTagApply(UserId, tagID, filepath);
        
        request.getRequestDispatcher("UserCenterUI").forward(request, response);
	}
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
