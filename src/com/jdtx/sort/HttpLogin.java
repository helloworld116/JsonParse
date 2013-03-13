package com.jdtx.sort;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;

public class HttpLogin {

	public static void main(String[] args) throws Exception {
		// 连接地址（通过阅读html源代码获得，即为登陆表单提交的URL）
		String surl = "http://192.168.1.237:80/ucsns/index.php?app=home&mod=Public&act=login_p";

		/**
		 * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
		 * java.net.URL and //java.net.URLConnection
		 */
		URL url = new URL(surl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		/**
		 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
		 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
		 */
		connection.setDoOutput(true);
		connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)"); 
		/**
		 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
		 */
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "UTF-8");
		// 其中的memberName和password也是阅读html代码得知的，即为表单中对应的参数名称
		out.write("email=qwerty@163.com&password=123456"); // post的关键所在！
		// remember to clean up
		out.flush();
		out.close();

		// 取得cookie，相当于记录了身份，供下次访问时使用
		String cookieVal = connection.getHeaderField("Set-Cookie");
//		System.out.println(cookieVal);
		cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
		
		InputStream urlStream = connection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(urlStream));
		String ss = null;
		StringBuilder total = new StringBuilder();
		while ((ss = bufferedReader.readLine()) != null) {
			total.append(ss);
		}
		bufferedReader.close();
		System.out.println(new String(total.toString().getBytes(),"UTF-8"));

		String s = "http://192.168.1.188/ucsns/index.php?app=blog&mod=Index&act=addBlog_p";

		Map<String, String> values = new HashMap<String, String>();
		values.put("title", "测试标题");
		values.put("content", "测试内容");
		values.put("dest_type", "1");
		values.put("dest_id", "5419");
		values.put("dest_name", "深圳市阳光168酒店");
		values.put("d_city_id", "191");
		values.put("ticket", "cf1d4a94fec961d73962800211210-Y2FsbA==");
		send(s, values, cookieVal);
	}

	public static boolean send(String urlAddr, Map<String, String> values,
			String cookieVal) throws Exception {
		HttpURLConnection conn = null;
		StringBuffer params = new StringBuffer();
		Iterator<Entry<String, String>> it = values.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> element = it.next();
			params.append(element.getKey());
			params.append("=");
			params.append(element.getValue());
			params.append("&");
		}
		if (params.length() > 0) {
			params.deleteCharAt(params.length() - 1);
		}
		try {
			URL url = new URL(urlAddr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(true);
			if (cookieVal != null) {
				// 发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
				conn.setRequestProperty("Cookie", cookieVal);
			}
			conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)"); 
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length",
					String.valueOf(params.length()));
			conn.setDoInput(true);
			conn.connect();

			OutputStreamWriter out = new OutputStreamWriter(
					conn.getOutputStream(), "UTF-8");
			out.write(params.toString());
			out.flush();
			out.close();
			InputStream urlStream = conn.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlStream));
			String ss = null;
			StringBuilder total = new StringBuilder();
			while ((ss = bufferedReader.readLine()) != null) {
				total.append(ss);
			}
			bufferedReader.close();
			System.out.println(new String(total.toString().getBytes(),"UTF-8"));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return false;
	}
}
