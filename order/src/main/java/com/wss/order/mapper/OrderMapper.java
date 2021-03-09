package com.wss.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wss.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
	void create(Order order);
}