package com.jdtx.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpPostChinese {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(sendMessage());
	}
	
	public static String sendMessage() throws UnsupportedEncodingException {
		String url = "http://192.168.1.237/newucai/post.php";
		String postData = "ticket="+URLEncoder.encode("中文","UTF-8");
		System.out.println(postData);
		try {
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl
					.openConnection();
			conn.setConnectTimeout(20000);
			conn.setRequestMethod("POST");
			conn.addRequestProperty("Accept", "*/*");
			conn.addRequestProperty("Accept-Language", "zh-cn");
			conn.addRequestProperty("Content-type", "text/plain");
			conn.addRequestProperty(
					"User-Agent",
					"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
			conn.setDoOutput(true);
			conn.connect();
			conn.getOutputStream().write(postData.getBytes(),0,postData.getBytes().length);
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			InputStream ins = conn.getInputStream();
			InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
			BufferedReader br = new BufferedReader(inr);
			String line = "";
			StringBuffer sb = new StringBuffer();
			do {
				sb.append(line);
				line = br.readLine();
			} while (line != null);
			return sb.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (ProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}