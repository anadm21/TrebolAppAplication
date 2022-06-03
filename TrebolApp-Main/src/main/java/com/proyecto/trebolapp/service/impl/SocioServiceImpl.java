package com.proyecto.trebolapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.trebolapp.commons.GenericServiceImpl;
import com.proyecto.trebolapp.dao.SocioDAO;
import com.proyecto.trebolapp.model.Socio;
import com.proyecto.trebolapp.service.SocioService;

@Service
public class SocioServiceImpl extends GenericServiceImpl<Socio, String> implements SocioService {

	@Autowired
	private SocioDAO socioDAO;
	
	@Override
	public CrudRepository<Socio, String> getDao() {
		return socioDAO;
	}
	
	@Override
	public Socio findByDNI(String dni){
		return socioDAO.findByDNI(dni);
	}
	
	@Override public void deleteByDNI(String dni) {
		socioDAO.deleteByDNI(dni); 
	}
}
