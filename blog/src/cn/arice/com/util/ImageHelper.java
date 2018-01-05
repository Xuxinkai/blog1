package cn.arice.com.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Arice ���¿�
 * @description ImageHelper ͼƬ���ð�����
 * @data 2016-4-3
 */
public class ImageHelper {
	/**
	 * ��ȡһ��ָ����С��ͼƬ
	 * @param width
	 * @param height
	 * @param imgUrl  ͼƬ·��
	 * @return ImagIcon
	 */
	
	public static ImageIcon getScaledIcon(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(smallImg);
	}
	
	/**
	 * ��ȡһ��ָ����С��ͼƬ
	 * @param width
	 * @param height
	 * @param imgUrl ͼƬ·��
	 * @return Image
	 */
	public static Image getScaledImg(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return smallImg;
	}

}
