package cn.arice.com.util;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.util:SensitiveWord.java ���дʹ���
 * @version 1.0
 * @data 2016-5-24
 */
public class SensitiveWord {
	private static String[] word = new String[]{"sb","nishishabi","shabi","ɵ��","ɧ��","�¼�","����"};
	public static String filteSensitiveWord(String masssge){
		String mas = masssge;
		for(String s:word){
		mas = mas.replace(s, "***");
			
		}
		return mas;
	}
}
