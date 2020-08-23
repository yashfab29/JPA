package com.capgemini.service;

import com.capgemini.dao.DaoImpl;
import com.capgemini.dao.IDao;

public class ServiceImpl implements IService {
	
	IDao dao = new DaoImpl();

	@Override
	public boolean accountNameIsValid(String name) {
		String pattern = "^[A-Z]{1}+[a-z]{2,}$";
		return name.matches(pattern);

	}

	@Override
	public boolean accountIdIsValid(String id) {
		String pattern = "^[0-9]{7}+[A-Za-z]{4}$";
		return id.matches(pattern);
	}
}