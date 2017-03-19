package com.eht.hg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.aip.ocr.AipOcr;
import com.eht.hg.Constants;
import com.eht.hg.mybatis.OrderMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {

	@Autowired
	OrderMapper orderMapper;

	public List<Map<String, Object>> OCRcurrency(Map<String, Object> params) {
		List<Map<String, Object>> list = new ArrayList<>();
		// 初始化一个OcrClient
		AipOcr client = new AipOcr(Constants.BAIDU_OCR_APP_ID, Constants.BAIDU_OCR_API_KEY,
				Constants.BAIDU_OCR_SECRET_KEY);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 自定义参数定义
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", Constants.BAIDU_OCR_DETECT_DIRECTION);
		options.put("language_type", Constants.BAIDU_OCR_LANGUAGE_TYPE);
		String jsonstr = "";
		if (params != null && params.get("type") != null && Integer.parseInt(params.get("type").toString()) == 0) {
			String genFilePath = params.get("imgurl").toString();
			JSONObject genRes = client.general(genFilePath, options);
			if (genRes == null) {
				return list;
			}
			jsonstr = genRes.toString(2);
			// 参数为本地图片文件二进制数组
			// byte[] file = readImageFile(imagePath);
			// JSONObject response = client.general(file);
			// System.out.println(response.toString());
		} else if (params != null && params.get("type") != null
				&& Integer.parseInt(params.get("type").toString()) == 1) {
			String idFilePath = params.get("imgurl").toString();
			HashMap<String, String> hasMap = new HashMap<String, String>();
			JSONObject idcardRes = client.idcard(idFilePath, true, hasMap);// 有疑问
			if (idcardRes == null) {
				return list;
			}
			jsonstr = idcardRes.toString(2);
		} else if (params != null && params.get("type") != null
				&& Integer.parseInt(params.get("type").toString()) == 2) {
			String bankFilePath = params.get("imgurl").toString();
			JSONObject bankRes = client.bankcard(bankFilePath);
			if (bankRes == null) {
				return list;
			}
			jsonstr = bankRes.toString(2);
		} else {
			return list;
		}
		// gson处理
		Gson gson = new Gson();
		list = gson.fromJson(jsonstr.toString(), new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		return list;
	}

	// 图片转二进制字符集
	/*
	 * public byte[] SetImageToByteArray(String fileName) { FileStream fs = new
	 * FileStream(fileName, FileMode.Open); int streamLength = (int) fs.Length;
	 * byte[] image = new byte[streamLength]; fs.Read(image, 0, streamLength);
	 * fs.Close(); return image; }
	 */
}
