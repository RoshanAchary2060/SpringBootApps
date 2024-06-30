package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getEmpByDesg(String cond) throws Exception;
}
