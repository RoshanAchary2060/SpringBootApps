package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

//@SpringBootApplication
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
public class BootProj04RealtimeDiAutoConfigurationApplication {

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
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj04RealtimeDiAutoConfigurationApplication.class, args);
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
