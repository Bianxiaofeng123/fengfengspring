package com.eht.hg.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eht.hg.controller.LogingController;
import com.eht.hg.controller.UsrControllro;
import com.eht.hg.mybatis.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	@Autowired
	OrderMapper orderMapper;

	public List<Map<String, Object>> getDownroadLiat() {
		List<Map<String, Object>> list = orderMapper.getDownroadLiat();
		return list;
	}

	public boolean loging(Map<String, Object> pramas) {
		Map<String, Object> logingmap = orderMapper.loging(pramas);
		log.info("logingmap:" + logingmap);
		if (logingmap != null && logingmap.get("id") != null) {
			log.info("true");
			return true;
		}
		return false;
	}
}
