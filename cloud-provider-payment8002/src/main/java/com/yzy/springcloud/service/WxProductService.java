package com.yzy.springcloud.service;


import com.github.pagehelper.PageInfo;

import com.yzy.springcloud.entity.WxProduct;

import java.util.List;

import org.springframework.stereotype.Component;

public interface  WxProductService {
	int deleteByPrimaryKey(Long productId);

	int insert(WxProduct record);

	WxProduct selectByPrimaryKey(Long productId);

	List<WxProduct> selectAll();
	
	
    PageInfo<WxProduct> findByPage() ;
}
