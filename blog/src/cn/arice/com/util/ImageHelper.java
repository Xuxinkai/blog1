package cn.arice.com.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Arice 徐新凯
 * @description ImageHelper 图片设置帮助类
 * @data 2016-4-3
 */
public class ImageHelper {
	/**
	 * 获取一个指定大小的图片
	 * @param width
	 * @param height
	 * @param imgUrl  图片路径
	 * @return ImagIcon
	 */
	
	public static ImageIcon getScaledIcon(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(smallImg);
	}
	
	/**
	 * 获取一个指定大小的图片
	 * @param width
	 * @param height
	 * @param imgUrl 图片路径
	 * @return Image
	 */
	public static Image getScaledImg(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return smallImg;
	}

}
