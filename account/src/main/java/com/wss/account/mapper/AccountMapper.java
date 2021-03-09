package com.wss.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wss.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
	void decrease(Long userId, BigDecimal money);
}