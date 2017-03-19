package com.eht.hg.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eht.hg.model.JsonResult;
import com.eht.hg.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
public class LogingController {
	@Autowired
	OrderService orderService;
	/**
	 * 登录
	 * @author fengfeng
	 * @param username
	 * @param password
	 */
	@RequestMapping(value = "/loging", method = RequestMethod.GET)
	public JsonResult loging(@RequestParam Map<String , Object> pramas) {
		log.info("pramas:"+pramas);
		JsonResult result=new JsonResult();
		if (orderService.loging(pramas)) {
			return result.putSuccess();
		}
		return result.putFailed("账号密码错误");
	}
	
}
