package com.eht.hg.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.aip.ocr.AipOcr;

public class Sample {
	private Logger log = LoggerFactory.getLogger(Sample.class);

	// 设置APPID/AK/SK
	public static final String APP_ID = "9402809";
	public static final String API_KEY = "svWDc1plyHgWlKD2MmGf9nG0";
	public static final String SECRET_KEY = "39yfKa49bmMFyjPHxtZg4v95ygeny5C1";
	public static final String ACCESS_KEY_ID = "ef503624977f4a198a0e1b2e2c0b3c9e";
	public static final String HTTPURL = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
	public static final String TOKENURL = "https://aip.baidubce.com/oauth/2.0/token";

	public static void main(String[] args) {
		// RestTemplate restTemplate = new RestTemplate();
		// Gson gson = new Gson();
		// 初始化一个OcrClient
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 调用身份证识别接口
		// String idFilePath = "IMG_2195.jpg";
		// HashMap<String, String> hasMap = new HashMap<String, String>();
		// JSONObject idcardRes = client.idcard(idFilePath, true, hasMap);// 有疑问
		// System.out.println(idcardRes.toString(2));
		// // 调用银行卡识别接口
		// String bankFilePath = "IMG_2195.jpg";
		// JSONObject bankRes = client.bankcard(bankFilePath);
		// System.out.println(bankRes.toString(2));
		// 调用通用识别接口
		// 自定义参数定义
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", "false");
		options.put("language_type", "JAP");

		String genFilePath = "D://book-ps.jpg";
		JSONObject genRes = client.general(genFilePath, options);
		System.out.println(genRes.toString(2));
	}
}
