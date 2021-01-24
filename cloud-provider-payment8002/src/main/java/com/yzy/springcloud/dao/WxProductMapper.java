package com.yzy.springcloud.dao;

import com.yzy.springcloud.entity.WxProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WxProductMapper {

	int deleteByPrimaryKey(Long productId);

	int insert(WxProduct record);

	WxProduct selectByPrimaryKey(Long productId);

	List<WxProduct> selectAll();

	int updateByPrimaryKey(WxProduct record);
}