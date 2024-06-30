package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class SecurityServiceRunner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SecurityServiceRunner.run()");
		System.out.println("Nonoption args::"+args.getNonOptionArgs()); // only value will be there, no key
		System.out.println("Option args names/keys::"+args.getOptionNames()); // this method gives only keys
		System.out.println("Source args::"+Arrays.toString(args.getSourceArgs()));
	}

}
