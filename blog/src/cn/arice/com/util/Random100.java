package cn.arice.com.util;

import java.util.Random;

import org.junit.Test;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.util:Random100.java  ������λ�������
 * @version 1.0
 * @data 2016-5-25
 */
public class Random100 {
	@Test
	public static String  getrandom100(){
		Random r = new Random(); 
		int rs = r.nextInt(900)+100;
		return rs+"";
	}
}
