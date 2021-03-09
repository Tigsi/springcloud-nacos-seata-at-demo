package com.wss.order.service.impl;


import com.wss.order.entity.Order;
import com.wss.order.feign.AccountClient;
import com.wss.order.feign.StorageClient;
import com.wss.order.mapper.OrderMapper;
import com.wss.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AccountClient accountClient;
	@Autowired
	private StorageClient storageClient;

	@GlobalTransactional(rollbackFor = Exception.class) //全局事务
	@Override
	public void create(Order order) {
		// TODO: 从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
		Long orderId = Long.valueOf(new Random().nextInt(Integer.MAX_VALUE));
		order.setId(orderId);

		orderMapper.create(order);

		// 修改库存
		storageClient.decrease(order.getProductId(), order.getCount());

		// 修改账户余额
		accountClient.decrease(order.getUserId(), order.getMoney());
	}
}