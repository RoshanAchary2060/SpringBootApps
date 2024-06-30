package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);
		
		// get target spring bean class object from IOC container
		WishMessageGenerator generator = ctx.getBean(WishMessageGenerator.class, "wmg");
		
		// invoke business method
		String result = generator.generateWishMessage("raja");
		System.out.println(result);
		((ConfigurableApplicationContext)ctx).close();
	}

	@Bean("ldt")
	LocalDateTime createLocalDateTime() {
		System.out.println("BootProj1DependencyInjectionApplication.createLocalDateTime()");
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}

}
