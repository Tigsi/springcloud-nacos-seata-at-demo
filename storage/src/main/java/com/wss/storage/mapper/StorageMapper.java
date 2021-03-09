package com.wss.storage.mapper;

import com.wss.storage.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
	void decrease(Long productId, Integer count);
}