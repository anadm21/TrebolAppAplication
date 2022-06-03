package com.proyecto.trebolapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.trebolapp.commons.GenericServiceImpl;
import com.proyecto.trebolapp.dao.BeneficiarioDAO;
import com.proyecto.trebolapp.model.Beneficiario;
import com.proyecto.trebolapp.service.BeneficiarioService;

@Service
public class BeneficiarioServiceImpl extends GenericServiceImpl<Beneficiario, String> implements BeneficiarioService {

	@Autowired
	private BeneficiarioDAO beneficiarioDAO;
	
	@Override
	public CrudRepository<Beneficiario, String> getDao() {
		return beneficiarioDAO;
	}
	
	@Override
	public Beneficiario findByDNI(String dni){
		return beneficiarioDAO.findByDNI(dni);
	}
	
	@Override public void deleteByDNI(String dni) {
		beneficiarioDAO.deleteByDNI(dni); 
	}
	 
}
