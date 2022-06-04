package com.proyecto.trebolapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.trebolapp.model.Trabajador;
import com.proyecto.trebolapp.service.TrabajadorService;

@RestController
@RequestMapping(value = "/api/")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService trabajadorService;

	//Peticion GET para listar todos los trabajadores
	@GetMapping(value = "/workers/all")
	public List<Trabajador> getAll() {
		return trabajadorService.getAll();
	}

	//Peticion GET para localizar a un trabajador por DNI
	@GetMapping(value = "/workers/find/{dni}")
	public Trabajador find(@PathVariable String dni) {
		return trabajadorService.findByDNI(dni);
	}

	//Peticion POST para añadir/editar trabajadores
	@PostMapping(value = "/workers/save")
	public void save(@RequestBody @Valid Trabajador trabajador) {
		Trabajador toriginal = trabajadorService.findByDNI(trabajador.getDNITrabajador());
		if (toriginal != null) {
			toriginal.setIDTrabajador(trabajador.getIDTrabajador());
			toriginal.setNombre(trabajador.getNombre());
			toriginal.setApellidos(trabajador.getApellidos());
			toriginal.setSalario(trabajador.getSalario());
			toriginal.setDNITrabajador(trabajador.getDNITrabajador());
			toriginal.setDireccion(trabajador.getDireccion());
			toriginal.setFecha_ant(trabajador.getFecha_ant());
			toriginal.setFecha_nac(trabajador.getFecha_nac());
			toriginal.setTelefono(trabajador.getTelefono());
			toriginal.setTurno(trabajador.getTurno());
			toriginal.setTipo_contrato(trabajador.getTipo_contrato());
			toriginal.setNum_SS(trabajador.getNum_SS());
			toriginal.setCuenta_bancaria(trabajador.getCuenta_bancaria());
			trabajadorService.save(toriginal);
		} else {
			trabajadorService.save(trabajador);
		}
	}

	//Peticion DELETE para eliminar trabajadores por DNI
	@DeleteMapping(value = "/workers/delete/{dni}")
	public void deleteByDNI(@PathVariable String dni) {
		Trabajador trabajador = trabajadorService.findByDNI(dni);
		if (trabajador != null) {
			trabajadorService.deleteByDNI(dni);
		}
	}
}
