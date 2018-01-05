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
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet.userpage:FileUploadAndDownServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
@SuppressWarnings("serial")
public class FileUploadAndDownServlet extends HttpServlet {
	private ImgService imgser = new ImgServiceImpl();
	private int count = 0;//添加图片范湖的信息
	private int alid = 0;//相册id
	private String filename = null;//文件名
	private String imgdesc = null;//对图片的描述
	private String imgurl= null;//图片的地址
	private String filesize =null ;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public void fileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.建立工厂类
		FileItemFactory factory = new DiskFileItemFactory();
		// 2.创建上传工具类
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(1024 * 1024 * 50);// 设置文件上传总大小
		upload.setFileSizeMax(1024 * 1024 * 10);// 单个文件上传大小
		upload.setHeaderEncoding("UTF-8");// 设置文本文件的编码值
		// 判断request提交的额是不是文件上传表单
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = upload.parseRequest(request);// 解析request提交的内容
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
						//获取图片的分辨率
						BufferedImage src = javax.imageio.ImageIO.read(file.getInputStream()); //构造Image对象
						int srcWidth = src.getWidth(null); //得到源图宽
						int srcHeight = src.getHeight(null); //得到源图长
						filesize = srcWidth+"px*"+srcHeight+"px|"+filesize+"kb";
						// 文件上传
						File f = new File(path, filename);
						file.write(f);
					}
				}
				//更新数据库
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
		//获取上传目录，及其下所有的文件的文件名
		String bathPath = getServletContext().getRealPath("/album");
		ArrayList<String> fileNames = new ArrayList<String>();
		
		//目录
		File file = new File(bathPath);
		//目录下，所有文件
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
		//获取要下载的文件名
		String fileName = request.getParameter("fileName");
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		String path = getServletContext().getRealPath("/upload");
		//获取一个文件流
		InputStream in = new FileInputStream(new File(path, fileName));
		// 如果文件名是中文，需要进行url编码
	    fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("content-disposition", "attachment;fileName=" + fileName);
		//获取response字节流
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
