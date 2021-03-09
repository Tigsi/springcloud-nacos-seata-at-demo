package com.wss.storage.service.impl;
import com.wss.storage.mapper.StorageMapper;
import com.wss.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	private StorageMapper storageMapper;

	@Transactional
	@Override
	public void decrease(Long productId, Integer count) throws Exception {
		storageMapper.decrease(productId,count);
	}
}