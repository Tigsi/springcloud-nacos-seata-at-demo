package com.wss.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("order")
public class Order {
	@TableId(type = IdType.INPUT)
	private Long id;
	@TableField("user_id")
	private Long userId;
	@TableField("product_id")
	private Long productId;
	private Integer count;
	private BigDecimal money;
	private Integer status;
}
