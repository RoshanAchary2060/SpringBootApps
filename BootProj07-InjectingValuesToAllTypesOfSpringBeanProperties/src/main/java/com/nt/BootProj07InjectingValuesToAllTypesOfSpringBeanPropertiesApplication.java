package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj07InjectingValuesToAllTypesOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		// get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj07InjectingValuesToAllTypesOfSpringBeanPropertiesApplication.class, args);
		// get spring bean class object
		Employee emp = ctx.getBean("emp",Employee.class);
		// display data
		System.out.println(emp);
		// close container
		ctx.close();
	}

}
