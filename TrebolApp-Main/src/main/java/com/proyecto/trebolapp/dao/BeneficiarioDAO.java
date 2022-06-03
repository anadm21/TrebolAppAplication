package com.proyecto.trebolapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.trebolapp.model.Beneficiario;

public interface BeneficiarioDAO extends CrudRepository<Beneficiario, String> {
	
	@Query (value="SELECT * FROM beneficiario WHERE DNIBeneficiario=?1",nativeQuery = true)
	Beneficiario findByDNI(String dni);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from beneficiario WHERE DNIBeneficiario=?1",nativeQuery = true)
	void deleteByDNI(String dni);
}
