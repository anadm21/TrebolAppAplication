package com.proyecto.trebolapp.main;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.trebolapp.controller.BeneficiarioRestController;
import com.proyecto.trebolapp.model.Beneficiario;

@SpringBootTest
class TrebolAppBeneficiarioTests {

	@Autowired
	BeneficiarioRestController brc;

	Beneficiario b = new Beneficiario();
	int idb;

	//Test de carga del contexto
	@Test
	public void beneficiarioContextLoads() {
		assertNotNull(brc);
	}

	//Test de adición de beneficiario
	@Test
	public void addTest() {
		b.setDNIBeneficiario("05554789-A");
		b.setNombre("Beneficiario");
		b.setApellidos("De ejemplo");
		b.setFecha_ant("2018-04-12");
		b.setFecha_nac("2002-04-12");
		b.setDireccion("Direccion de Ejemplo, 15");
		b.setTelefono("658874789");
		b.setEdad(20);
		brc.save(b);
		idb = b.getIDBeneficiario();
		assertNotNull(brc.find("05554789-A"));
	}
	
	//Test de edición de beneficiario
	@Test
	public void updateTest() {
		if (brc.find(b.getDNIBeneficiario())!=null) {
			b.setIDBeneficiario(idb);
			b.setDNIBeneficiario("05554789-A");
			b.setNombre("Beneficiario");
			b.setApellidos("De ejemplo");
			b.setFecha_ant("2018-05-12");
			b.setFecha_nac("2002-05-12");
			b.setDireccion("Direccion de Ejemplo, 15");
			b.setTelefono("658874789");
			b.setEdad(20);
			brc.save(b);
		}
		assertNotEquals("2002-04-12",b.getFecha_nac());
	}

	//Test de listado de beneficiarios
	@Test
	public void getAllTest() {
		assertNotNull(brc.getAll());
	}

	//Test de eliminación de voluntario
	@Test
	public void deleteTest() {
		brc.deleteByDNI("05554789-A");
		assertNull(brc.find("05554789-A"));
	}

}
