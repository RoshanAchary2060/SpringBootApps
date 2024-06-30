package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class PersistenceConfig {
	@Autowired
	private Environment env;

    @Bean(name = "c3p0ds")
    ComboPooledDataSource createDS() throws Exception {
		System.out.println("PersistenceConfig.createDS()");
		ComboPooledDataSource c3p0ds = new ComboPooledDataSource();
		c3p0ds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		c3p0ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		c3p0ds.setUser(env.getProperty("spring.datasource.username"));
		c3p0ds.setPassword(env.getProperty("spring.datasource.password"));
		return c3p0ds;
	}
}
