package cn.arice.com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.util:FileUtil.java 文件写入写出
 * @version 1.0
 * @data 2016-5-25
 */
public class FileUtil {
	public String fileReadInAndPutOut(String fileName) throws IOException {
		String content = "";
		FileInputStream fis =new FileInputStream(fileName);
		InputStreamReader isr =new InputStreamReader(fis,"utf-8");
		BufferedReader  br=new BufferedReader(isr);
		String line="";
		while((line=br.readLine())!=null){
			content=content+line+"\n";
		}
		
		br.close();
		isr.close();
		fis.close();
		return content;
	}
	public static void main(String[] args) throws IOException {
		FileUtil fu = new FileUtil();
		File file = new File("");
		System.out.println(file.getAbsolutePath());
		
	}
}
