package com.proyecto.trebolapp.service;

import com.proyecto.trebolapp.commons.GenericService;
import com.proyecto.trebolapp.model.Socio;

public interface SocioService extends GenericService<Socio, String>  {
	
	public Socio findByDNI(String dni);

	public void deleteByDNI(String dni);
}
