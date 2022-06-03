package com.proyecto.trebolapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.trebolapp.commons.GenericServiceImpl;
import com.proyecto.trebolapp.dao.VoluntarioDAO;
import com.proyecto.trebolapp.model.Voluntario;
import com.proyecto.trebolapp.service.VoluntarioService;

@Service
public class VoluntarioServiceImpl extends GenericServiceImpl<Voluntario, String> implements VoluntarioService {

	@Autowired
	private VoluntarioDAO voluntarioDAO;
	
	@Override
	public CrudRepository<Voluntario, String> getDao() {
		return voluntarioDAO;
	}
	
	@Override
	public Voluntario findByDNI(String dni){
		return voluntarioDAO.findByDNI(dni);
	}
	
	@Override public void deleteByDNI(String dni) {
		voluntarioDAO.deleteByDNI(dni); 
	}
}
