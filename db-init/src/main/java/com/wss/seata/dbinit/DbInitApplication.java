package com.wss.seata.dbinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class DbInitApplication {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DbInitApplication.class, args);
	}

	@PostConstruct //spring boot 初始化完成以后，会自动运行此方法
	public void  init() throws SQLException {
		exec("sql/account.sql");
		exec("sql/order.sql");
		exec("sql/seata-server.sql");
		exec("sql/storage.sql");
	}

	private void exec(String s) throws SQLException {
		ClassPathResource resource = new ClassPathResource(s, DbInitApplication.class.getClassLoader());
		EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
		ScriptUtils.executeSqlScript(dataSource.getConnection(),encodedResource);

	}
}