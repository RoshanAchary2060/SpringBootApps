package com.nt.beans;

import javax.inject.Named;

//@Component("java")
@Named("java")
public final class JavaCourseMaterial implements ICourseMaterial {
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial.0-param constructor");
	}

	@Override
	public String courseContent() {
		System.out.println("JavaCourseMaterial.courseContent()");
		return "1.Java OOPS, 2.Java Exception Handling, 3.Java Collections and etc";
	}

	@Override
	public double price() {
		System.out.println("JavaCourseMaterial.price()");
		return 400;
	}

}
