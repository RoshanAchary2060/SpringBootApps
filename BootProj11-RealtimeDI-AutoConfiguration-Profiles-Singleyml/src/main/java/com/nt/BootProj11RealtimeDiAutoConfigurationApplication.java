package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
public class BootProj11RealtimeDiAutoConfigurationApplication {
	
	@Autowired
	private Environment env;
	
	@Bean(name="cds")
	@Profile("uat")
	ComboPooledDataSource createC3P0Ds() throws Exception{
		System.out.println("BootProj04RealtimeDiAutoConfigurationApplication.createC3P0Ds()");
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return cds;
	}

	public static void main(String[] args) {
		// read inputs from end user
		Scanner sc = new Scanner(System.in);
		System.out.println("Desgs count::");
		int count = sc.nextInt();
		String [] desgs = null;
		if(count >=1) {
			desgs = new String[count];
		} else {
			System.out.println("Invalid desg count!");
			sc.close();
			return;
		}
		for(int i=0; i<count; i++) {
			System.out.println("Enter desg"+(i+1));
			desgs [i] = sc.next();
		}
		
		// get IOC container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj11RealtimeDiAutoConfigurationApplication.class, args);
		
		// get access to env
//		ConfigurableEnvironment env = ctx.getEnvironment();
//		env.setActiveProfiles("uat");
		
		// get Controller class obj
		MainController controller = ctx.getBean("controller",MainController.class);
		
		// invoke business method
		try {
			List<EmployeeVO> listVO = controller.showEmpsByDesgs(desgs);
			System.out.println("Emp details having " + Arrays.toString(desgs));
			listVO.forEach(vo->{
				System.out.println(vo);
			});
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Some internal problem:: "+ex.getMessage());
		}
		finally {
			sc.close();
			ctx.close();
		}
	}

}
