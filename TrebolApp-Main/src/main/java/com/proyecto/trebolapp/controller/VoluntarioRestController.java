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

import com.proyecto.trebolapp.model.Voluntario;
import com.proyecto.trebolapp.service.VoluntarioService;

@RestController
@RequestMapping(value = "/api/")
public class VoluntarioRestController {

	@Autowired
	private VoluntarioService voluntarioService;

	@GetMapping(value = "/volunteers/all")
	public List<Voluntario> getAll() {
		return voluntarioService.getAll();
	}
	
	@GetMapping(value = "/volunteers/find/{dni}")
	public Voluntario find(@PathVariable String dni) {
		return voluntarioService.findByDNI(dni);
	}
	
	@PostMapping(value = "/volunteers/save")
	public void save(@RequestBody @Valid Voluntario voluntario) {
		Voluntario voriginal = voluntarioService.findByDNI(voluntario.getDNIVoluntario());
		if (voriginal!=null) {
			voriginal.setIDVoluntario(voluntario.getIDVoluntario());
			voriginal.setNombre(voluntario.getNombre());
			voriginal.setApellidos(voluntario.getApellidos());
			voriginal.setEdad(voluntario.getEdad());
			voriginal.setDNIVoluntario(voluntario.getDNIVoluntario());
			voriginal.setDireccion(voluntario.getDireccion());
			voriginal.setFecha_ant(voluntario.getFecha_ant());
			voriginal.setFecha_nac(voluntario.getFecha_nac());
			voriginal.setTelefono(voluntario.getTelefono());
			voluntarioService.save(voriginal);
		} else {
			voluntarioService.save(voluntario);
		}
	}
	
	@DeleteMapping(value = "/volunteers/delete/{dni}")
	public void deleteByDNI(@PathVariable String dni) {
		Voluntario voluntario = voluntarioService.findByDNI(dni);
		if (voluntario != null) {
			voluntarioService.deleteByDNI(dni);
		}
	}
}
