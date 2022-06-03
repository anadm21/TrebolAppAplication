package com.proyecto.trebolapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.trebolapp.model.Trabajador;

public interface TrabajadorDAO extends CrudRepository<Trabajador, String> {

	@Query (value="SELECT * FROM trabajador WHERE DNITrabajador=?1",nativeQuery = true)
	Trabajador findByDNI(String dni);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from trabajador WHERE DNITrabajador=?1",nativeQuery = true)
	void deleteByDNI(String dni);
	
}
