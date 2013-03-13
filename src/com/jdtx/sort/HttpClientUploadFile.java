package com.jdtx.sort;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUploadFile {
	public static void main(String[] args) throws Exception {
		 post();
//		uploadfile(new File("F:\\测试.JPG"));
	}

	public static void post() throws Exception {
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(
				"http://192.168.1.237/newucai/post.php");
//		postMethod.getParams().setParameter(
//				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
//		client.getParams().setContentCharset("UTF-8");
//		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		Part[] parts = { new StringPart("ticket", "中文啊","utf-8") };
		postMethod.setRequestEntity(new MultipartRequestEntity(parts,
				postMethod.getParams()));
		client.executeMethod(postMethod);
		System.out.println(postMethod.getResponseBodyAsString());
		postMethod.releaseConnection();
	}

	public static String uploadfile(File file) {
		String fromAgentResult = "";
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(
				"http://192.168.1.237/ucsns/index.php?app=photo&mod=Upload&act=uploadPicByPhone");
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");  
		// 若上传的文件比较大 , 可在此设置最大的连接超时时间
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(8000);
		try {
			FilePart fp = new FilePart(file.getName(), file);
			StringPart ticket = new StringPart("ticket",
					"3b301f9f9355d50c5122400214292-c29zbzIwMTI=");
			StringPart dest_type = new StringPart("dest_type", "2");// '目的地类型，0城市，1酒店，2景点，3餐馆，4休闲，5购物',
			StringPart dest_id = new StringPart("dest_id", "9867"); // '目的地ID',
			StringPart dest_name = new StringPart("dest_name", "深圳仙湖植物园 "); // '目的地名称',
			StringPart d_city_id = new StringPart("d_city_id", "191");// 目的地城市id
			MultipartRequestEntity mrp = new MultipartRequestEntity(new Part[] {
					fp, ticket, dest_type, dest_id, dest_name, d_city_id },
					postMethod.getParams());
			postMethod.setRequestEntity(mrp);

			// 使用系统提供的默认的恢复策略
			// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
			// new DefaultHttpMethodRetryHandler());
			int httpStat = client.executeMethod(postMethod);
			if (!(httpStat == HttpStatus.SC_OK)) {
				fromAgentResult = "connected fail:" + httpStat;
			} else if (httpStat == HttpStatus.SC_OK) {
				System.out.println(new String(postMethod.getResponseBody(),
						"UTF-8"));
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		postMethod.releaseConnection();
		return fromAgentResult;
	}
}
