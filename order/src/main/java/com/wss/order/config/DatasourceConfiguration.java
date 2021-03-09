package com.wss.order.config;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import org.springframework.context.annotation.Primary;
@Configuration
public class DatasourceConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

	@Primary  //设置首选数据源对象
	@Bean("dataSource")
	public DataSourceProxy dataSource(DataSource druidDataSource){
		return new DataSourceProxy(druidDataSource);
	}
}