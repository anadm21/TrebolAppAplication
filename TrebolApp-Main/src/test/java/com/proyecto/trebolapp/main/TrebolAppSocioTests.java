package com.proyecto.trebolapp.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.trebolapp.controller.SocioRestController;
import com.proyecto.trebolapp.model.Socio;


@SpringBootTest
class TrebolAppSocioTests {

	@Autowired
	SocioRestController src;

	Socio s = new Socio();
	int ids;

	@Test
	public void socioContextLoads() {
		assertNotNull(src);
	}

	@Test
	public void addTest() {
		s.setDNISocio("05554789-A");
		s.setNombre("Socio");
		s.setApellidos("De ejemplo");
		s.setFecha_nac("2002-04-12");
		s.setCuota(150);
		s.setCuenta_bancaria("ES256985785478955478");
		s.setDireccion("Direccion de Ejemplo, 15");
		s.setTelefono("658874789");
		src.save(s);
		ids = s.getIDSocio();
		assertNotNull(src.find("05554789-A"));
	}
	
	@Test
	public void updateTest() {
		if (src.find(s.getDNISocio())!=null) {
			s.setIDSocio(ids);
			s.setDNISocio("05554789-A");
			s.setNombre("Socio");
			s.setApellidos("De ejemplo");
			s.setFecha_nac("2002-05-12");
			s.setCuota(150);
			s.setCuenta_bancaria("ES256985785478955478");
			s.setDireccion("Direccion de Ejemplo, 15");
			s.setTelefono("658874789");
			src.save(s);
		}
		assertNotEquals("2002-04-12",s.getFecha_nac());
	}

	@Test
	public void getAllTest() {
		assertNotNull(src.getAll());
	}

	@Test
	public void deleteTest() {
		src.deleteByDNI("05554789-A");
		assertNull(src.find("05554789-A"));
	}

}
