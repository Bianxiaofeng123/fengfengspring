package com.eht.hg.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.ocr.AipOcr;
import com.eht.hg.Constants;
import com.eht.hg.service.SampleService;
import com.eht.hg.utils.JsonResult;
import com.eht.hg.utils.QiNiuUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/ocr")
public class SampleController {

	@Autowired
	SampleService sampleService;

	/**
	 * 通用ocr-文字识别
	 * 
	 * @author fengfeng
	 * @param httpHeaders
	 * @param uploadfile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/currency", method = RequestMethod.POST)
	public JsonResult uploadFile(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		Map<String, Object> putMap = new HashMap<>();
		putMap.put("imgUrl", "D://IMG_2195.jpg");
		return result.put(sampleService.OCRcurrency(putMap));
	}

	/**
	 * 通用ocr-身份证识别接口
	 * 
	 * @author fengfeng
	 * @param httpHeaders
	 * @param uploadfile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/idcard", method = RequestMethod.POST)
	public JsonResult identityCard(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		Map<String, Object> putMap = new HashMap<>();
		putMap.put("imgurl", "D://IMG_2195.jpg");
		putMap.put("type", "0");
		return result.put(sampleService.OCRcurrency(putMap));
	}

	public static void main(String[] args) {
		/*// 初始化一个OcrClient
		AipOcr client = new AipOcr(Constants.BAIDU_OCR_APP_ID, Constants.BAIDU_OCR_API_KEY,
				Constants.BAIDU_OCR_SECRET_KEY);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 自定义参数定义
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", Constants.BAIDU_OCR_DETECT_DIRECTION);
		options.put("language_type", Constants.BAIDU_OCR_LANGUAGE_TYPE);
		String genFilePath;
		// genFilePath = "";
		genFilePath = "D://IMG_2195.jpg";
		JSONObject genRes = client.general(genFilePath, options);
		System.out.println(genRes.toString(2));*/
		
		
		
		// RestTemplate restTemplate = new RestTemplate();
		// Gson gson = new Gson();
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
	}
}
