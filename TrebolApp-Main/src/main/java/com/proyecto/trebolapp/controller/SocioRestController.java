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

import com.proyecto.trebolapp.model.Socio;
import com.proyecto.trebolapp.service.SocioService;

@RestController
@RequestMapping(value = "/api/")
public class SocioRestController {

	@Autowired
	private SocioService socioService;

	@GetMapping(value = "/partners/all")
	public List<Socio> getAll() {
		return socioService.getAll();
	}
	
	@GetMapping(value = "/partners/find/{dni}")
	public Socio find(@PathVariable String dni) {
		return socioService.findByDNI(dni);
	}
	
	@PostMapping(value = "/partners/save")
	public void save(@RequestBody @Valid Socio socio) {
		Socio soriginal = socioService.findByDNI(socio.getDNISocio());
		if (soriginal!=null) {
			soriginal.setIDSocio(socio.getIDSocio());
			soriginal.setNombre(socio.getNombre());
			soriginal.setApellidos(socio.getApellidos());
			soriginal.setCuota(socio.getCuota());
			soriginal.setDNISocio(socio.getDNISocio());
			soriginal.setDireccion(socio.getDireccion());
			soriginal.setFecha_nac(socio.getFecha_nac());
			soriginal.setTelefono(socio.getTelefono());
			soriginal.setCuenta_bancaria(socio.getCuenta_bancaria());
			socioService.save(soriginal);
		} else {
			socioService.save(socio);
		}
	}
	
	@DeleteMapping(value = "/partners/delete/{dni}")
	public void deleteByDNI(@PathVariable String dni) {
		Socio socio = socioService.findByDNI(dni);
		if (socio != null) {
			socioService.deleteByDNI(dni);
		}
	}

}
