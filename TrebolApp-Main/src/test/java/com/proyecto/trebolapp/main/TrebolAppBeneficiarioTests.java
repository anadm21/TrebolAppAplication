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

	@Test
	public void beneficiarioContextLoads() {
		assertNotNull(brc);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addTest() {
		Date fnac = new Date(12, 04, 2018);
		Date fant = new Date(12, 04, 2002);
		b.setDNIBeneficiario("05554789-A");
		b.setNombre("Beneficiario");
		b.setApellidos("De ejemplo");
		b.setFecha_ant(fant.toString());
		b.setFecha_nac(fnac.toString());
		b.setDireccion("Direccion de Ejemplo, 15");
		b.setTelefono("658874789");
		b.setEdad(20);
		brc.save(b);
		idb = b.getIDBeneficiario();
		assertNotNull(brc.find("05554789-A"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void updateTest() {
		Date fnac = new Date(12, 05, 2018);
		Date fant = new Date(12, 05, 2002);
		if (brc.find(b.getDNIBeneficiario())!=null) {
			b.setIDBeneficiario(idb);
			b.setDNIBeneficiario("05554789-A");
			b.setNombre("Beneficiario");
			b.setApellidos("De ejemplo");
			b.setFecha_ant(fant.toString());
			b.setFecha_nac(fnac.toString());
			b.setDireccion("Direccion de Ejemplo, 15");
			b.setTelefono("658874789");
			b.setEdad(20);
			brc.save(b);
		}
		assertNotEquals("2002-04-12",b.getFecha_nac());
	}

	@Test
	public void getAllTest() {
		assertNotNull(brc.getAll());
	}

	@Test
	public void deleteTest() {
		brc.deleteByDNI("05554789-A");
		assertNull(brc.find("05554789-A"));
	}

}
