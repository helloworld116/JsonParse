package com.jdtx.sort;

import com.google.gson.Gson;

public class GsonTest {

	private static Gson gson = new Gson();

	public static void main(String[] args) {
		 String str = "{\"ID\":\"1\",\"name\":\"\",\"state\":\"1\",\"description\":\"xxxxx\",\"chapters\":[{\"chapter_id\":\"1\",\"chapter_name\":\"AA\"},{\"chapter_id\":\"1\",\"chapter_name\":\"AA\"}]}";
		 Gson gson = new Gson();
		 DataResult result = gson.fromJson(str, DataResult.class);
		 System.out.println(result.getChapters().get(0).getChapter_name());

//		String str = "";
//		// Gson gson = new Gson();
//		// Logins logins = gson.fromJson(str, Logins.class);
//		Logins logins = fromJson("", Logins.class);
//		if (null != logins) {
//			if (null == logins.getId() || "".equals(logins.getId())) {
//				System.out.println("null");
//			} else {
//				System.out.println(logins.getId());
//			}
//		}
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}
}
