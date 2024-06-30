package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DEGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN";
	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpByDesg(String cond) throws Exception {
		List<EmployeeBO> listBO = null;
		// try with resources
		try (// get pooled jdbc conn
				Connection conn = ds.getConnection();
				// PreparedStatement obj cannot be used here because no of desgs is dynamic
				// value
				Statement st = conn.createStatement(); // create Statement obj
				// send and execute SQL query in DB s/w
				// select empno,ename,job,sal,deptno,mgr from emp where job in
				// ('CLERK','MANAGER') order by job);
				ResultSet rs = st.executeQuery(GET_EMPS_BY_DEGS + cond + " ORDER BY JOB");
		) {
			System.out.println(ds.getClass());
			// convert RS object records to List of BO class obj
			listBO = new ArrayList<>();
			EmployeeBO bo = null;
			while (rs.next()) {
				bo = new EmployeeBO();
				// copy each record of RS to an object of EmployeeBO class
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getDouble(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				// add each object of EmployeeBO to List Collection
				listBO.add(bo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex; // for Exception propagation
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return listBO;
	}

}
