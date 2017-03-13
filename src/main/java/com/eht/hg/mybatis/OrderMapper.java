package com.eht.hg.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	
	List<Map<String, Object>> getDownroadLiat();
	
	Map<String, Object> loging(Map<String, Object> prams);
	

}
