package com.eht.hg.controller;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.eht.hg.Constants;

public class Sample {

	

	public static void main(String[] args) {
		// RestTemplate restTemplate = new RestTemplate();
		// Gson gson = new Gson();
		// 初始化一个OcrClient
		AipOcr client = new AipOcr(Constants.BAIDU_OCR_APP_ID, Constants.BAIDU_OCR_API_KEY, Constants.BAIDU_OCR_SECRET_KEY);
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
		options.put("detect_direction", Constants.BAIDU_OCR_DETECT_DIRECTION);
		options.put("language_type", Constants.BAIDU_OCR_LANGUAGE_TYPE);
		
		String genFilePath = "D://book-ps.jpg";
		JSONObject genRes = client.general(genFilePath, options);
		System.out.println(genRes.toString(2));
	}
}
