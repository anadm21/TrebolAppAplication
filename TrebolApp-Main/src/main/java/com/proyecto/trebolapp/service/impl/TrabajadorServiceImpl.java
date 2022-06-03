package com.proyecto.trebolapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.trebolapp.commons.GenericServiceImpl;
import com.proyecto.trebolapp.dao.TrabajadorDAO;
import com.proyecto.trebolapp.model.Trabajador;
import com.proyecto.trebolapp.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl extends GenericServiceImpl<Trabajador, String> implements TrabajadorService {

	@Autowired
	private TrabajadorDAO trabajadorDAO;
	
	@Override
	public CrudRepository<Trabajador, String> getDao() {
		return trabajadorDAO;
	}
	
	@Override
	public Trabajador findByDNI(String dni){
		return trabajadorDAO.findByDNI(dni);
	}
	
	@Override public void deleteByDNI(String dni) {
		trabajadorDAO.deleteByDNI(dni); 
	}
}
