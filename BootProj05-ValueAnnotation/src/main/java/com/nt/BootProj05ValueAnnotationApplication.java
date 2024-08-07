package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.BillGenerator;

@SpringBootApplication
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {
		// get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);
		// get spring bean class object
		BillGenerator generator = ctx.getBean("bill",BillGenerator.class);
		System.out.println("data:: " + generator);
		// close container
		ctx.close();
	}

}
