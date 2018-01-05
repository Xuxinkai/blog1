package cn.arice.com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;



public class IPToAddr {
//	public static void main(String[] args) {
//		jiexiip("110.52.125.145");
//	}
/***
 * 
 * @param ip
 * @return ip地址对应的真实地址
 */
	public static String jiexiip(String ip){
		String addr = null;
		String httpUrl = "http://ip.taobao.com/service/getIpInfo.php";
		String httpArg = "ip="+ip;
		String jsonResult = request(httpUrl, httpArg);
//		System.out.println(jsonResult);
		try {
			JSONObject jobj = new JSONObject(jsonResult);
			JSONObject showapi = jobj.getJSONObject("data");
			String country = showapi.getString("country");
			String country_id = showapi.getString("country_id");
			String area = showapi.getString("area");
			String region = showapi.getString("region");
			String city = showapi.getString("city");
			String isp = showapi.getString("isp");
			addr =country+"("+country_id+")"+area+"-"+region+"-"+city+":"+isp;
		} catch (JSONException e) {
			e.printStackTrace();
		}
//		System.out.println(addr);
		return addr;
	}
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	       // connection.setRequestProperty("apikey",  "2a1dbae028ed07d5feb3b3aeadf04b02");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
