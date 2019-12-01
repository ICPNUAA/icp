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
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import icp.bean.UserBean;
import icp.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/VerifyCampusCard")
public class VerifyCampusCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "uploadfile";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCampusCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String UserId=(String) session.getAttribute("userID");
		String newPath="";
		try{
			request.setCharacterEncoding("UTF-8");
			String storePath=getServletContext().getRealPath("/images");
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//设置临时文件的存放路径
			factory.setRepository(new File(getServletContext().getRealPath("/temp")));
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setProgressListener(new ProgressListener() {
			//pBytesRead:已读字节数
			//pContentLength:文件大小   字节总长度
			//pItems:  FileItem 文件的索引
			public void update(long pBytesRead, long pContentLength, int pItems) {
			////XMLHttpServletRequest:js的对象
			// //把pBytesRead/pContentLength*100，返回到界面上：XML或JSON(AJAX)
			System.out.println("已读"+pBytesRead+",总大小:"+pContentLength+",第几项:"+pItems
			+"!!!上传进度="+(pBytesRead/pContentLength*100)+"%");
			System.out.println(pBytesRead/pContentLength);
			}
			});
			//设置单个文件的大小
			upload.setFileSizeMax(6*1024*1024);
			upload.setSizeMax(20*1024*1024);

			boolean isMultipart=ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
				List<FileItem> items=upload.parseRequest(request);
				for(FileItem item:items){
				if(item.isFormField()){
					String fileName=item.getFieldName();
					String fileValue=item.getString("UTF-8");
					System.out.println(fileName+"="+fileValue);
				}else{
					String mimeType=item.getContentType();
					if(mimeType.startsWith("/image")){
						InputStream in=item.getInputStream();//文件内容的输入流
							String fileName=item.getName();//上传文件的文件名
						if(fileName==null&&"".equals(fileName)){
							continue;
						}
						fileName=fileName.substring(fileName.lastIndexOf("\\")+1);//原来的文件名
						fileName=UUID.randomUUID().toString()+"_"+fileName;//UUID.randomUUID()后的文件名
						System.out.println(request.getRemoteAddr()+"上传了"+fileName);
			
						newPath=makeDir(storePath,fileName);
						OutputStream out=new FileOutputStream(newPath+"\\"+fileName);
			
						int len=-1;
						byte []b=new byte[1024];
						while((len=in.read(b))!=-1){
							out.write(b, 0, len);
						}
						in.close();
						out.close();
						item.delete();//删除临时文件
					}
					}
				}
			}
			}catch(FileSizeLimitExceededException e){
			System.out.println("单个文件不能超过6M");

			}catch(FileUploadBase.SizeLimitExceededException e){
			System.out.println("总文件大小不能超过6M");

			}

			catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);

			}
        
        UserDao.AddCampusCardVerifyApply(UserId, newPath);
        request.getRequestDispatcher("VerifyCampusCardUI").forward(request, response);
	}
	
	private String makeDir(String storePath, String fileName) {
		int hashCode=fileName.hashCode();
		int dir1=hashCode & 0xf;
		int dir2=(hashCode& 0xf0)>>4;
		String newPath=storePath+"\\"+dir1+"\\"+dir2;
		File file=new File(newPath);
		if(!file.exists()){
		file.mkdir();
		}

		return newPath;
		}
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
