package com.proyecto.trebolapp.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.trebolapp.controller.VoluntarioRestController;
import com.proyecto.trebolapp.model.Voluntario;

@SpringBootTest
class TrebolAppVoluntarioTests {

	@Autowired
	VoluntarioRestController vrc;

	Voluntario v = new Voluntario();
	int idv;

	@Test
	public void voluntarioContextLoads() {
		assertNotNull(vrc);
	}

	@Test
	public void addTest() {
		v.setDNIVoluntario("05554789-A");
		v.setNombre("Voluntario");
		v.setApellidos("De ejemplo");
		v.setFecha_ant("2020-04-12");
		v.setFecha_nac("2018-04-12");
		v.setDireccion("Direccion de Ejemplo, 15");
		v.setTelefono("658874789");
		v.setEdad(20);
		vrc.save(v);
		idv = vrc.find("05554789-A").getIDVoluntario();
		assertNotEquals(vrc.find("05554789-A"),null);
	}
	
	@Test
	public void updateTest() {
		if (vrc.find(v.getDNIVoluntario())!=null) {
			v.setIDVoluntario(idv);
			v.setDNIVoluntario("05554789-A");
			v.setNombre("Voluntario");
			v.setApellidos("De ejemplo");
			v.setFecha_ant("2020-05-12");
			v.setFecha_nac("2018-05-12");
			v.setDireccion("Direccion de Ejemplo, 15");
			v.setTelefono("658874789");
			v.setEdad(20);
			vrc.save(v);
		}
		assertNotEquals("2018-04-12",v.getFecha_nac());
	}

	@Test
	public void getAllTest() {
		assertNotNull(vrc.getAll());
	}

	@Test
	public void deleteTest() {
		vrc.deleteByDNI("05554789-A");
		assertNull(vrc.find("05554789-A"));
	}

}
