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
		// ���ӵ�ַ��ͨ���Ķ�htmlԴ�����ã���Ϊ��½���ύ��URL��
		String surl = "http://192.168.1.237:80/ucsns/index.php?app=home&mod=Public&act=login_p";

		/**
		 * ����Ҫ��URL�µ�URLConnection�Ի��� URLConnection���Ժ����׵Ĵ�URL�õ������磺 // Using
		 * java.net.URL and //java.net.URLConnection
		 */
		URL url = new URL(surl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		/**
		 * Ȼ���������Ϊ���ģʽ��URLConnectionͨ����Ϊ������ʹ�ã���������һ��Webҳ��
		 * ͨ����URLConnection��Ϊ���������԰����������Webҳ���͡��������������
		 */
		connection.setDoOutput(true);
		connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)"); 
		/**
		 * ���Ϊ�˵õ�OutputStream�������������Լ����Writer���ҷ���POST��Ϣ�У����磺 ...
		 */
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "UTF-8");
		// ���е�memberName��passwordҲ���Ķ�html�����֪�ģ���Ϊ���ж�Ӧ�Ĳ�������
		out.write("email=qwerty@163.com&password=123456"); // post�Ĺؼ����ڣ�
		// remember to clean up
		out.flush();
		out.close();

		// ȡ��cookie���൱�ڼ�¼����ݣ����´η���ʱʹ��
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
		values.put("title", "���Ա���");
		values.put("content", "��������");
		values.put("dest_type", "1");
		values.put("dest_id", "5419");
		values.put("dest_name", "����������168�Ƶ�");
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
				// ����cookie��Ϣ��ȥ���Ա����Լ�����ݣ�����ᱻ��Ϊû��Ȩ��
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
