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
@RequestMapping(value = "/downroad", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	/**
	 * 查看所有下载地址
	 * @author fengfeng
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonResult seeTask()throws Exception{
		JsonResult result=new JsonResult();
		result.put(orderService.getDownroadLiat());
		return result;
	}
	
	
	
}
