package com.nt.beans;

import javax.inject.Inject;
import javax.inject.Named;

import jakarta.annotation.Resource;

//@Component("stud")
@Named("stud") // instead of component
public final class Student {
//	@Autowired
//	@Inject // instead of autowired

	@Resource(name="courseId") // it has multiple purposes
	
//	@Qualifier("courseId") // we cannot pass placeholder here
//@Named("courseId") // instead of qualifier but it is not working
	private ICourseMaterial material;

	public Student() {
		System.out.println("Student.0-param constructor");
	}

	public void preparation(String examName) {
		System.out.println("Preparation started for " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using " + courseContent + " material with price " + price);
		System.out.println("Preparation is completed for " + examName);
	}
}
