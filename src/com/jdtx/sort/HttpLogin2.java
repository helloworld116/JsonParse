package com.jdtx.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * A example that demonstrates how HttpClient APIs can be used to perform
 * form-based logon.
 */
public class HttpLogin2 {

	public static void main(String[] args) throws Exception {

		String url = "http://192.168.1.237/ucsns/index.php?app=home&mod=Public&act=login_p";// 论坛的登陆页面
		String url2 = "http://192.168.1.237/ucsns/index.php?app=blog&mod=Index&act=addBlog_p";// 论坛的发贴页面
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setCookiePolicy(
				CookiePolicy.BROWSER_COMPATIBILITY);
		PostMethod postMethod = new PostMethod(url);
		PostMethod postMethod2 = new PostMethod(url2);
		NameValuePair[] data = { new NameValuePair("email", "h@h.com"),
				new NameValuePair("password", "123456") };
		postMethod
				.setRequestHeader(
						"User-Agent",
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2");
		postMethod
				.setRequestHeader("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		postMethod.setRequestBody(data);
		try {
			httpClient.executeMethod(postMethod);
			StringBuffer response = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					postMethod.getResponseBodyAsStream(), "UTF-8"));// 以gb2312编码方式打印从服务器端返回的请求
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line).append(
						System.getProperty("line.separator"));
			}
			reader.close();
			Cookie[] cookies = httpClient.getState().getCookies();// 取出登陆成功后，服务器返回的cookies信息，里面保存了服务器端给的“临时证”
			String tmpcookies = "";
			for (Cookie c : cookies) {
				tmpcookies = tmpcookies + c.toString() + ";";
			}
			System.out.println(response);
			NameValuePair[] data2 = { new NameValuePair("title", "测试标题"),
					new NameValuePair("content", "测试内容"),
					new NameValuePair("dest_type", "1"),
					new NameValuePair("dest_id", "5419"),
					new NameValuePair("dest_name", "深圳市阳光168酒店"),
					new NameValuePair("d_city_id", "191") };
			postMethod2.setRequestHeader("cookie", tmpcookies);// 将“临时证明”放入下一次的发贴请求操作中
			postMethod2.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");// 因为发贴时候有中文，设置一下请求编码
			postMethod2
					.setRequestHeader(
							"User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2");
			postMethod2
					.setRequestHeader("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");// 以上操作是模拟浏览器的操作，使用服务器混淆

			postMethod2.setRequestBody(data2);
			httpClient.executeMethod(postMethod2);
			StringBuffer response1 = new StringBuffer();
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(
					postMethod2.getResponseBodyAsStream(), "UTF-8"));
			String line1;
			while ((line1 = reader1.readLine()) != null) {
				response1.append(line1).append(
						System.getProperty("line.separator"));
			}
			reader1.close();
			System.out.println(response1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			postMethod.releaseConnection();
			postMethod2.releaseConnection();
		}

	}
}
