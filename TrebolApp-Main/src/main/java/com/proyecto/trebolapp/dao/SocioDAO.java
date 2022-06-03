package com.proyecto.trebolapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.trebolapp.model.Socio;

public interface SocioDAO extends CrudRepository<Socio, String> {

	@Query (value="SELECT * FROM socio WHERE DNISocio=?1",nativeQuery = true)
	Socio findByDNI(String dni);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from socio WHERE DNISocio=?1",nativeQuery = true)
	void deleteByDNI(String dni);
}
