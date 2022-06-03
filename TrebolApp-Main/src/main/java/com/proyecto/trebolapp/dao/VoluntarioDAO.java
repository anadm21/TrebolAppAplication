package com.proyecto.trebolapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.trebolapp.model.Voluntario;

public interface VoluntarioDAO extends CrudRepository<Voluntario, String> {

	@Query (value="SELECT * FROM voluntario WHERE DNIVoluntario=?1",nativeQuery = true)
	Voluntario findByDNI(String dni);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from voluntario WHERE DNIVoluntario=?1",nativeQuery = true)
	void deleteByDNI(String dni);
	
}
