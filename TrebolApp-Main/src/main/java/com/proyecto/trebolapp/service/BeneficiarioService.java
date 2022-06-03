package com.proyecto.trebolapp.service;


import com.proyecto.trebolapp.commons.GenericService;
import com.proyecto.trebolapp.model.Beneficiario;

public interface BeneficiarioService extends GenericService<Beneficiario, String>  {
	
	public Beneficiario findByDNI(String dni);

	public void deleteByDNI(String dni);
}
