package com.nt.beans;

import javax.inject.Named;

//@Component("UI")
@Named("UI")
public final class UICourseMaterial implements ICourseMaterial {

	public UICourseMaterial() {
		System.out.println("UICourseMaterial.0-param constructor");
	}

	@Override
	public String courseContent() {
		System.out.println("UICourseMaterial.courseContent()");

		return "1.html, 2.css, 3.js";
	}

	@Override
	public double price() {
		return 200;
	}

}
