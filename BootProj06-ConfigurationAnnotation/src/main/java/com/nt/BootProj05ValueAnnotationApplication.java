package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.CompanyDetails;
import com.nt.beans.CompanyDetails1;

@SpringBootApplication
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {
		// get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);
		// get spring bean class object
		CompanyDetails details = ctx.getBean("company",CompanyDetails.class);
		CompanyDetails1 details1 = ctx.getBean("company1",CompanyDetails1.class);
		
		System.out.println("company:: " + details);
		System.out.println("company1:: " + details1);
		
		// close container
		ctx.close();
	}

}
