package com.nt.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("company")
public class Company {
	private String title;
	private String location;
	private int size;
	
}
