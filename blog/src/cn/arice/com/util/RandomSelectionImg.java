package cn.arice.com.util;


import java.util.List;
import java.util.Random;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.impl.ImgServiceImpl;

/**
 * 
 * @author 徐新凯
 * @date 2017年2月25日 下午8:22:03
 * @description 随机选择一张照片，返回照片类
 */
public class RandomSelectionImg {
	private static ImgBean img = null;
	private static List<ImgBean> imgs = null;
	public static void main(String[] args) {
		System.out.println(getImgSrc().getImgid());
	}
	public static ImgBean getImgSrc(){
		//获得所有的照片
		imgs = new ImgServiceImpl().getAllImg();
		int length = imgs.size()-1;
		int number = new Random().nextInt(length)+1;  //这是产生1-图片个数的随机数
		img = imgs.get(number);
		return img;
	}

}
