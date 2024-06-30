package com.nt.beans;

import javax.inject.Named;

//@Component("dotNet")
@Named("dotNet")
public final class DotNetCourseMaterial implements ICourseMaterial {

	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial.0-param constructor");
	}
	@Override
	public String courseContent() {
		System.out.println("DotNetCourseMaterial.courseContent()");

		return "1.C# OOPS, 2.C# Exception Handling, 3.C# Collections and etc";
	}

	@Override
	public double price() {
		return 300;
	}

}
