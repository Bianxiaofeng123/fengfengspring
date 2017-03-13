package com.eht.hg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eht.hg.mybatis.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;
	
	public List<Map<String, Object>> getDownroadLiat() {
		List<Map<String, Object>> list=orderMapper.getDownroadLiat();
		return list;
	}
	
	public boolean loging(Map<String, Object> pramas) {
		Map<String, Object> logingmap=orderMapper.loging(pramas);
		if (logingmap!=null) {
			return true;
		}
		return false;
	}
}
