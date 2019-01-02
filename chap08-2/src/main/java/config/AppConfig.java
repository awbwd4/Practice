package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.MemberDao;

@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException();
		}
		
		ds.setJdbcUrl("jdbc:mysql://localhost:3307/spring4fs");
		ds.setUser("user1");
		ds.setPassword("1111");
		return ds;
	}
	
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	
	
	
	
	
	
}
