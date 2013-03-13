package com.jdtx.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonTest {

	public static void main(String[] args) {
		String str = "{\"ID\":\"1\",\"name\":\"\",\"state\":\"1\",\"description\":\"xxxxx\",\"chapters\":[{\"chapter_id\":\"1\",\"chapter_name\":\"AA\"},{\"chapter_id\":\"1\",\"chapter_name\":\"AA\"}]}";
//		String str = "{\"status\":\"1\",\"pageinfo\":\"{\"currentPage\":\"1\",\"pageSize\":\"3\",\"totalNum\":\"30\",\"totalPage\":\"10\"}\",\"dataInfo\":\"[{\"id\":\"108\",\"shop_id\":\"48\",\"img_url\":\"http://192.168.1.19/imgshop/48/1341883758293622826.jpg\",\"img_desc\":\"13\",\"thumb_url\":\"http://192.168.1.19/imgshop/48/1341883758293622826.jpg\",\"img_original\":\"http://192.168.1.19/imgshop/48/1341883758293622826.jpg\"},{\"id\":\"109\",\"shop_id\":\"48\",\"img_url\":\"http://192.168.1.19/imgshop/48/1341883997717042032.jpg\",\"img_desc\":\"14\",\"thumb_url\":\"http://192.168.1.19/imgshop/48/1341883997717042032.jpg\",\"img_original\":\"http://192.168.1.19/imgshop/48/1341883997717042032.jpg\"},{\"id\":\"514\",\"shop_id\":\"48\",\"img_url\":\"http://192.168.1.19/imgshop/48/1343811425084217660_150_150.jpg\",\"img_desc\":\"20060419000055839\",\"thumb_url\":\"http://192.168.1.19/imgshop/48/1343811425084217660_100_100.jpg\",\"img_original\":\"http://192.168.1.19/imgshop/48/1343811425084217660.jpg\"}]\"}";
		DataResult result = JSON.parseObject(str, DataResult.class);
		System.out.println(result.getID());
//		System.out.println(result.getChapters());
//		JSONObject jsonObject = JSON.parseObject(str);
//		System.out.println(jsonObject.get("status"));
//		JSONObject pageInfObject  = jsonObject.getJSONObject("pageInfo");
//		System.out.println(pageInfObject.get("currentPage"));
	}
}