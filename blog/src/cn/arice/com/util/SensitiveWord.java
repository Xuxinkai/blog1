package cn.arice.com.util;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.util:SensitiveWord.java Ãô¸Ð´Ê¹ýÂË
 * @version 1.0
 * @data 2016-5-24
 */
public class SensitiveWord {
	private static String[] word = new String[]{"sb","nishishabi","shabi","Éµ±Æ","É§»õ","ÏÂ¼ú","±°±É"};
	public static String filteSensitiveWord(String masssge){
		String mas = masssge;
		for(String s:word){
		mas = mas.replace(s, "***");
			
		}
		return mas;
	}
}
