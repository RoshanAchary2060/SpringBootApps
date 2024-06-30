package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws Exception {
		// convert desgs[] into SQL IN clause String condition
		// ('CLERK','MANAGER','SALESMAN')
		StringBuffer buffer = new StringBuffer("(");
		for (int i = 0; i < desgs.length; i++) {
			if (i == desgs.length - 1) { // for the last element of the array
				buffer.append("'" + desgs[i] + "')");
			} else { // for other than last element
				buffer.append("'" + desgs[i] + "',");
			}
		}
		// convert StringBuffer obj to String
		String cond = buffer.toString();
		// use DAO
		List<EmployeeBO> listBO = dao.getEmpByDesg(cond);
		// convert ListBO to ListDTO
		List<EmployeeDTO> listDTO = new ArrayList();
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			// copy each BO class obj data to each DTO class obj
			BeanUtils.copyProperties(bo, dto); // property names and types must match in both java beans
			dto.setSrNo(listDTO.size() + 1);
			// add each obj of DTO class to listDTO
			listDTO.add(dto);
		});

		return listDTO;
	}

}
