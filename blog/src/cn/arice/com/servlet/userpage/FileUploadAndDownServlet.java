package cn.arice.com.servlet.userpage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.ImgService;
import cn.arice.com.service.impl.ImgServiceImpl;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.Random100;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet.userpage:FileUploadAndDownServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
@SuppressWarnings("serial")
public class FileUploadAndDownServlet extends HttpServlet {
	private ImgService imgser = new ImgServiceImpl();
	private int count = 0;//���ͼƬ��������Ϣ
	private int alid = 0;//���id
	private String filename = null;//�ļ���
	private String imgdesc = null;//��ͼƬ������
	private String imgurl= null;//ͼƬ�ĵ�ַ
	private String filesize =null ;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public void fileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.����������
		FileItemFactory factory = new DiskFileItemFactory();
		// 2.�����ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(1024 * 1024 * 50);// �����ļ��ϴ��ܴ�С
		upload.setFileSizeMax(1024 * 1024 * 10);// �����ļ��ϴ���С
		upload.setHeaderEncoding("UTF-8");// �����ı��ļ��ı���ֵ
		// �ж�request�ύ�Ķ��ǲ����ļ��ϴ���
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = upload.parseRequest(request);// ����request�ύ������
				for (FileItem file : list) {
					
					if (file.isFormField()) {
						String value = file.getString();
						value = new String(value.getBytes("ISO-8859-1"),"utf-8");
						if("album".equals(file.getFieldName())){
							alid = Integer.parseInt(value);
						}
						if("imgdesc".equals(file.getFieldName())){
							imgdesc = value;
						}
					} else {
						filesize = String.valueOf(file.getSize()/1024);
						String path = this.getServletContext().getRealPath("/album");
						filename = DateHelper.getDateTimeForNumber()+Random100.getrandom100()+file.getName().substring(file.getName().lastIndexOf("."));
						imgurl = "album/"+filename;
						//��ȡͼƬ�ķֱ���
						BufferedImage src = javax.imageio.ImageIO.read(file.getInputStream()); //����Image����
						int srcWidth = src.getWidth(null); //�õ�Դͼ��
						int srcHeight = src.getHeight(null); //�õ�Դͼ��
						filesize = srcWidth+"px*"+srcHeight+"px|"+filesize+"kb";
						// �ļ��ϴ�
						File f = new File(path, filename);
						file.write(f);
					}
				}
				//�������ݿ�
				count = imgser.addImg(new ImgBean(null, alid, filename, imgurl, imgdesc, filesize, null));
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void downList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�ϴ�Ŀ¼�����������е��ļ����ļ���
		String bathPath = getServletContext().getRealPath("/album");
		ArrayList<String> fileNames = new ArrayList<String>();
		
		//Ŀ¼
		File file = new File(bathPath);
		//Ŀ¼�£������ļ�
		String list[] = file.list();
		if(list != null && list.length >0){
			for(int i = 0;i<list.length;i++){
				String fileName = list[i];
				fileNames.add(fileName);
			}
		}
		request.setAttribute("listfile", fileNames);
		request.getRequestDispatcher("downList.jsp").forward(request, response);
		
	}
	
	public void down(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡҪ���ص��ļ���
		String fileName = request.getParameter("fileName");
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		String path = getServletContext().getRealPath("/upload");
		//��ȡһ���ļ���
		InputStream in = new FileInputStream(new File(path, fileName));
		// ����ļ��������ģ���Ҫ����url����
	    fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("content-disposition", "attachment;fileName=" + fileName);
		//��ȡresponse�ֽ���
		OutputStream out = response.getOutputStream();
		byte[] b= new byte[1024];
		int len = -1;
		while((len = in.read(b)) != -1){
			out.write(b,0,len);
		}
		out.close();
		in.close();
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String method = request.getParameter("method");
		if("upload".equals(method)){
			fileUpload(request , response );
			if(count == 1){
				response.sendRedirect("imgupload.jsp");
			}else{
				response.sendError(404);
			}
		}else if ("downList".equals(method)){
			downList(request , response);
		}else if ("down".equals(method)){
			down(request , response);
		}

	}

}
