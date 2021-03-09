package com.wss.storage.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("storage")
public class Storage {
	@TableId(type = IdType.INPUT)
	private Long id;
	@TableField("product_id")
	private Long productId;
	private Integer total;
	private Integer used;
	private Integer residue;
	private Integer frozen;
}