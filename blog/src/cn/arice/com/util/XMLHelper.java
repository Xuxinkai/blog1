package cn.arice.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.arice.com.bean.LoginHistoryBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.util:XMLHelper.java xml文件帮助类
 * @version 1.0
 * @data 2016-5-9
 */
public class XMLHelper {
	private static String path = XMLHelper.class.getResource("/").getPath();
	private static String fileName = path.substring(0, path.lastIndexOf("/")-7)+"loginhistory.xml";
	public static void main(String[] args) {
		XMLHelper xmlh = new XMLHelper();
		System.out.println(fileName);
		System.out.println(path);
//		xmlh.createXml();
//		xmlh.addElement(new LoginHistoryBean("4","123654987","2016-05-09","127.0.0.1"));
//		ArrayList<LoginHistoryBean> list = xmlh.parserXml();
//		System.out.println(list.size());
//		for(LoginHistoryBean his:list){
//			System.out.println(his.getLoginId()+":"+his.getLoginUserId()+":"+his.getLoginTime()+":"+his.getLoginIp());
//		}
//		LoginHistoryBean his = xmlh.getPenultHistory();
//		System.out.println(his.getLoginId()+"::"+his.getLoginUserId()+":"+his.getLoginTime()+":"+his.getLoginIp());
//		System.out.println(path+"\\WebRoot\\config");
	}
	/**
	 * @desc 创建xml
	 * @param fileName
	 */
	
	public void createXml() {
		Document document = DocumentHelper.createDocument();
		document.addElement("loginhistory");//根节点
		try {
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @desc 给xml文件添加数据   不是创建
	 */
	@SuppressWarnings("deprecation")
	public void addElement(LoginHistoryBean his){
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(inputXml);
			Element root = document.getRootElement();//loginhistory
			Element loginId = root.addElement("loginId");
			loginId.setAttributeValue("id", his.getLoginId());
			Element loginUserId = loginId.addElement("loginUserId");
			loginUserId.setText(his.getLoginUserId());
			Element loginTime = loginId.addElement("loginTime");
			loginTime.setText(his.getLoginTime());
			Element loginIp = loginId.addElement("loginIp");
			loginIp.setText(his.getLoginIp());
			
			XMLWriter writer = new XMLWriter( new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	/***
	 * @desc 解析xml
	 * @param fileName
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<LoginHistoryBean> parserXml() {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		ArrayList<LoginHistoryBean> listHis = new ArrayList<LoginHistoryBean>();
		LoginHistoryBean his;
		try {
			Document document = saxReader.read(inputXml);
			Element loginhistory = document.getRootElement();
			for (Iterator i = loginhistory.elementIterator(); i.hasNext();) {
				his = new LoginHistoryBean();
				Element loginId = (Element) i.next();
				his.setLoginId(loginId.attributeValue("id"));
				for (Iterator j = loginId.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					if(node.getName().equals("loginUserId")){
						his.setLoginUserId(node.getText());
					}
					if(node.getName().equals("loginTime")){
						his.setLoginTime(node.getText());
					}
					if(node.getName().equals("loginIp")){
						his.setLoginIp(node.getText());
					}
				}
				listHis.add(his);

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return listHis;
	}
	/**
	 * 获取倒数第二个历史记录
	 */
	public LoginHistoryBean getPenultHistory(){
		LoginHistoryBean his = new LoginHistoryBean();
		ArrayList<LoginHistoryBean> list = parserXml();
		his = list.get(list.size()-2);
		return his;
	}
	/**
	 * 获取历史记录的个数
	 */
	public int getHistoryCount(){
		return parserXml().size();
	}
}
