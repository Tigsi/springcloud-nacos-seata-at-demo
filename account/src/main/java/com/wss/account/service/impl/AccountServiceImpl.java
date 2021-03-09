package com.wss.account.service.impl;

import com.wss.account.mapper.AccountMapper;
import com.wss.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper accountMapper;

	@Transactional
	@Override
	public void decrease(Long userId, BigDecimal money) {
		accountMapper.decrease(userId, money);
//
		throw new RuntimeException("模拟异常");
	}
}
