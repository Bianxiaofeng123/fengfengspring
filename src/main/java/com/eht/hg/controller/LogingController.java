package com.eht.hg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eht.hg.model.JsonResult;
import com.eht.hg.service.OrderService;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
public class LogingController {
	@Autowired
	OrderService orderService;
//	@RequestParam Map<String, Object> parmas,@RequestHeader HttpHeaders httpHeaders
	/**
	 * 登录
	 * @author fengfeng
	 * @param username
	 * @param password
	 */
	@RequestMapping(value = "/loging", method = RequestMethod.POST)
	public JsonResult loging(@RequestBody Map<String , Object> pramas) {
		JsonResult result=new JsonResult();
		if (orderService.loging(pramas)) {
			result.putSuccess();
		}
		return result.putFailed("账号密码错误");
	}
	
}
