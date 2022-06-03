package com.proyecto.trebolapp.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.trebolapp.controller.TrabajadorRestController;
import com.proyecto.trebolapp.model.Trabajador;


@SpringBootTest
class TrebolAppTrabajadorTests {

	@Autowired
	TrabajadorRestController trc;

	Trabajador t = new Trabajador();
	int idt;

	@Test
	public void trabajadorContextLoads() {
		assertNotNull(trc);
	}
	
	@Test
	public void addTest() {
		t.setDNITrabajador("05554789-A");
		t.setNombre("Trabajador");
		t.setApellidos("De ejemplo");
		t.setFecha_ant("2018-04-12");
		t.setFecha_nac("2002-04-12");
		t.setSalario(1250);
		t.setTurno("Noche");
		t.setTipo_contrato("Indefinido");
		t.setNum_SS("287478748");
		t.setCuenta_bancaria("ES256985785478955478");
		t.setDireccion("Direccion de Ejemplo, 15");
		t.setTelefono("658874789");
		trc.save(t);
		idt = t.getIDTrabajador();
		assertNotNull(trc.find("05554789-A"));
	}
	
	@Test
	public void updateTest() {
		if (trc.find(t.getDNITrabajador())!=null) {
			t.setIDTrabajador(idt);
			t.setDNITrabajador("05554789-A");
			t.setNombre("Trabajador");
			t.setApellidos("De ejemplo");
			t.setFecha_ant("2018-05-12");
			t.setFecha_nac("2002-05-12");
			t.setSalario(1250);
			t.setTurno("Noche");
			t.setTipo_contrato("Indefinido");
			t.setNum_SS("287478748");
			t.setCuenta_bancaria("ES256985785478955478");
			t.setDireccion("Direccion de Ejemplo, 15");
			t.setTelefono("658874789");
			trc.save(t);
		}
		assertNotEquals("2018-04-12",t.getFecha_nac());
	}


	@Test
	public void getAllTest() {
		assertNotNull(trc.getAll());
	}

	@Test
	public void deleteTest() {
		trc.deleteByDNI("05554789-A");
		assertNull(trc.find("05554789-A"));
	}

}
