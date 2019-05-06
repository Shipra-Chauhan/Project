package com.example.spring_step_1.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Named
//@Component
public class CDIBusiness {

	@Inject
	//@Autowired
	CDI_Dao cdiDao;

	public CDI_Dao getCdiDao() {
		return cdiDao;
	}

	public void setCdiDao(CDI_Dao cdiDao) {
		this.cdiDao = cdiDao;
	}
	
	
}
