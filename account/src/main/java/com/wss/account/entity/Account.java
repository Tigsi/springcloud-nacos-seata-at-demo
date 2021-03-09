package com.wss.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.math.BigDecimal;

@Data
@TableName("account")
public class Account {
	@TableId(type = IdType.INPUT)
	private Long id;

	@TableField("user_id")
	private Long userId;
	private BigDecimal total;
	private BigDecimal used;
	private BigDecimal residue;
	private BigDecimal frozen;
}