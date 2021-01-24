package com.yzy.springcloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.springcloud.dao.WxProductMapper;
import com.yzy.springcloud.entity.WxProduct;
import com.yzy.springcloud.service.WxProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxProductServiceImpl implements WxProductService {

	@Autowired
	private WxProductMapper wxProductMapper;

	public int deleteByPrimaryKey(Long productId) {
		return wxProductMapper.deleteByPrimaryKey(productId);
	}

	public int insert(WxProduct record) {
		return wxProductMapper.insert(record);
	}

	public WxProduct selectByPrimaryKey(Long productId) {
		return wxProductMapper.selectByPrimaryKey(productId);
	}

	public List<WxProduct> selectAll() {
		return wxProductMapper.selectAll();
	}

	public PageInfo<WxProduct> findByPage() {
		PageHelper.startPage(1, 10);
		List<WxProduct> products = wxProductMapper.selectAll();
		PageInfo<WxProduct> appsPageInfo = new PageInfo<WxProduct>(products);
		return appsPageInfo;
	}

}
