package cn.arice.com.util;


import java.util.List;
import java.util.Random;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.impl.ImgServiceImpl;

/**
 * 
 * @author ���¿�
 * @date 2017��2��25�� ����8:22:03
 * @description ���ѡ��һ����Ƭ��������Ƭ��
 */
public class RandomSelectionImg {
	private static ImgBean img = null;
	private static List<ImgBean> imgs = null;
	public static void main(String[] args) {
		System.out.println(getImgSrc().getImgid());
	}
	public static ImgBean getImgSrc(){
		//������е���Ƭ
		imgs = new ImgServiceImpl().getAllImg();
		int length = imgs.size()-1;
		int number = new Random().nextInt(length)+1;  //���ǲ���1-ͼƬ�����������
		img = imgs.get(number);
		return img;
	}

}
