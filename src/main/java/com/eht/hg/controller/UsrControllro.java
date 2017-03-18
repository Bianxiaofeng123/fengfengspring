package com.eht.hg.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eht.hg.model.JsonResult;
import com.eht.hg.utils.QiNiuUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/uplod")
public class UsrControllro {

	@RequestMapping(value = "/usr", method = RequestMethod.POST)
	public JsonResult uploadFile(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {
		JsonResult result = new JsonResult();
		String imgKeys = null;
		String imgkey = null;
		String imgUrl = null;
		try {
			imgKeys = QiNiuUtils.uploadPublic(uploadfile.getBytes(), false);
			imgkey = QiNiuUtils.getValByKey4Str(imgKeys, "key");
			imgUrl = QiNiuUtils.getPublicPath(imgkey);
		} catch (Exception e) {
			log.info("上传失败");
		}
		result.put("imgurl", imgUrl);
		result.put("imgkey", imgkey);
		return result;
	}

}
