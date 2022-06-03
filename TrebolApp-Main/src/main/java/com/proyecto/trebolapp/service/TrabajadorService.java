package com.proyecto.trebolapp.service;

import com.proyecto.trebolapp.commons.GenericService;
import com.proyecto.trebolapp.model.Trabajador;

public interface TrabajadorService extends GenericService<Trabajador, String>  {
	
	public Trabajador findByDNI(String dni);

	public void deleteByDNI(String dni);
}
