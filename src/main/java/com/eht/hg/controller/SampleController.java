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
	@RequestMapping(value = "/general", method = RequestMethod.POST)
	public JsonResult General(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		Map<String, Object> putMap = new HashMap<>();
		putMap.put("imgUrl", "D://IMG_2195.jpg");
		putMap.put("type", "0");
		return result.put(sampleService.OCRcurrency(putMap));
	}

	/**
	 * ocr-身份证识别接口
	 * 
	 * @author fengfeng
	 * @param httpHeaders
	 * @param uploadfile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/idcard", method = RequestMethod.POST)
	public JsonResult IdentityCard(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		Map<String, Object> putMap = new HashMap<>();
		putMap.put("imgurl", "D://IMG_2195.jpg");
		putMap.put("type", "1");
		return result.put(sampleService.OCRcurrency(putMap));
	}

	/**
	 * ocr-银行卡识别接口
	 * 
	 * @author fengfeng
	 * @param httpHeaders
	 * @param uploadfile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bankcard", method = RequestMethod.POST)
	public JsonResult Bankcard(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		Map<String, Object> putMap = new HashMap<>();
		putMap.put("imgurl", "D://IMG_2195.jpg");
		putMap.put("type", "2");
		return result.put(sampleService.OCRcurrency(putMap));
	}

}
