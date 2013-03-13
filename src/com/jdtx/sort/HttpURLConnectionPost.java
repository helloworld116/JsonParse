package com.jdtx.sort;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionPost {
	public static void main(String[] args) {
		String actionUrl = "http://192.168.1.237/newucai/post.php";
		uploadFile(actionUrl);
	}
	private static void uploadFile(String uploadUrl) {
		String BOUNDARY = "------WebKitFormBoundaryMAi0csj4Scqj7L6w"; // 定义数据分隔线
		try {
			URL url = new URL(uploadUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			// 设置每次传输的流大小，可以有效防止手机因为内存不足崩溃
			// 此方法用于在预先不知道内容长度时启用没有进行内部缓冲的 HTTP 请求正文的流。
			httpURLConnection.setChunkedStreamingMode(128 * 1024);// 128K
			// 允许输入输出流
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			// 使用POST方法
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			httpURLConnection.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + BOUNDARY);

			// DataOutputStream dos = new DataOutputStream(
			// httpURLConnection.getOutputStream());
			// dos.writeBytes(twoHyphens + boundary + end);
			// dos.writeBytes("ticket=cf1d4a94fec961d73962800211210-Y2FsbA==");
			// dos.writeBytes(end);
			// dos.writeBytes(twoHyphens + boundary + end);
			// dos.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
			// + srcPath.substring(srcPath.lastIndexOf("/") + 1)
			// + "\""
			// + end);
			// dos.writeBytes(end);
			//
			// FileInputStream fis = new FileInputStream(srcPath);
			// byte[] buffer = new byte[8192]; // 8k
			// int count = 0;
			// // 读取文件
			// while ((count = fis.read(buffer)) != -1) {
			// dos.write(buffer, 0, count);
			// }
			// fis.close();
			//
			// dos.writeBytes(end);
			// dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
			// dos.flush();

			// OutputStream os = httpURLConnection.getOutputStream();
			// os.write(("Content-Disposition: form-data; name=\"file\"; filename=\""
			// + srcPath.substring(srcPath.lastIndexOf("/") + 1) + "\"" )
			// .getBytes());
			// FileInputStream fis = new FileInputStream(srcPath);
			// byte[] buffer = new byte[8192]; // 8k
			// int count = 0;
			// // 读取文件
			// while ((count = fis.read(buffer)) != -1) {
			// os.write(buffer, 0, count);
			// }
			// fis.close();
			// os.flush();
			// os.close();
			OutputStream out = new DataOutputStream(
					httpURLConnection.getOutputStream());
			StringBuilder sb = new StringBuilder();
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"ticket\"\r\n\r\n");
			sb.append("中文");
			sb.append("\r\n");
			sb.append(BOUNDARY);
			// sb.append(BOUNDARY);
			// sb.append("\r\n");
			// sb.append("Content-Disposition: form-data;name=\"file"
			// + "\";filename=\""
			// + srcPath.substring(srcPath.lastIndexOf("/") + 1)
			// + "\"\r\n");
			// sb.append("Content-Type:image/jpeg\r\n");
			// System.out.println(sb.toString());
			// byte[] data = sb.toString().getBytes();
			// out.write(data);
			// DataInputStream in = new DataInputStream(new FileInputStream(
			// srcPath));
			// int bytes = 0;
			// byte[] bufferOut = new byte[1024];
			// while ((bytes = in.read(bufferOut)) != -1) {
			// out.write(bufferOut, 0, bytes);
			// }
			// in.close();

			byte[] data = sb.toString().getBytes();
			httpURLConnection.connect();
			out.write(data);
			System.out.println(sb);
			out.flush();
			out.close();

			InputStream is = httpURLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String res;
			StringBuilder sBuilder = new StringBuilder();
			while (null != (res = br.readLine())) {
				sBuilder.append(res);
			}
			String result = sBuilder.toString();
			System.out.println(result);
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
