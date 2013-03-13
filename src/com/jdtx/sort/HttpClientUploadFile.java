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
//		uploadfile(new File("F:\\����.JPG"));
	}

	public static void post() throws Exception {
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(
				"http://192.168.1.237/newucai/post.php");
//		postMethod.getParams().setParameter(
//				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
//		client.getParams().setContentCharset("UTF-8");
//		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		Part[] parts = { new StringPart("ticket", "���İ�","utf-8") };
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
		// ���ϴ����ļ��Ƚϴ� , ���ڴ������������ӳ�ʱʱ��
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(8000);
		try {
			FilePart fp = new FilePart(file.getName(), file);
			StringPart ticket = new StringPart("ticket",
					"3b301f9f9355d50c5122400214292-c29zbzIwMTI=");
			StringPart dest_type = new StringPart("dest_type", "2");// 'Ŀ�ĵ����ͣ�0���У�1�Ƶ꣬2���㣬3�͹ݣ�4���У�5����',
			StringPart dest_id = new StringPart("dest_id", "9867"); // 'Ŀ�ĵ�ID',
			StringPart dest_name = new StringPart("dest_name", "�����ɺ�ֲ��԰ "); // 'Ŀ�ĵ�����',
			StringPart d_city_id = new StringPart("d_city_id", "191");// Ŀ�ĵس���id
			MultipartRequestEntity mrp = new MultipartRequestEntity(new Part[] {
					fp, ticket, dest_type, dest_id, dest_name, d_city_id },
					postMethod.getParams());
			postMethod.setRequestEntity(mrp);

			// ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
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
