package com.proyecto.trebolapp.service;

import com.proyecto.trebolapp.commons.GenericService;
import com.proyecto.trebolapp.model.Voluntario;

public interface VoluntarioService extends GenericService<Voluntario, String>  {
	public Voluntario findByDNI(String dni);

	public void deleteByDNI(String dni);
}
