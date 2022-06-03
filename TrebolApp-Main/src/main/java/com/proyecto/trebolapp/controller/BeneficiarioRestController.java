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

import com.proyecto.trebolapp.model.Beneficiario;
import com.proyecto.trebolapp.service.BeneficiarioService;

@RestController
@RequestMapping(value = "/api/")
public class BeneficiarioRestController {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@GetMapping(value = "/beneficiaries/all")
	public List<Beneficiario> getAll() {
		return beneficiarioService.getAll();
	}

	@GetMapping(value = "/beneficiaries/find/{dni}")
	public Beneficiario find(@PathVariable String dni) {
		return beneficiarioService.findByDNI(dni);
	}

	@PostMapping(value = "/beneficiaries/save")
	public void save(@RequestBody @Valid Beneficiario beneficiario) {
		Beneficiario boriginal = beneficiarioService.findByDNI(beneficiario.getDNIBeneficiario());
		if (boriginal != null) {
			boriginal.setIDBeneficiario(beneficiario.getIDBeneficiario());
			boriginal.setNombre(beneficiario.getNombre());
			boriginal.setApellidos(beneficiario.getApellidos());
			boriginal.setEdad(beneficiario.getEdad());
			boriginal.setDNIBeneficiario(beneficiario.getDNIBeneficiario());
			boriginal.setDireccion(beneficiario.getDireccion());
			boriginal.setFecha_ant(beneficiario.getFecha_ant());
			boriginal.setFecha_nac(beneficiario.getFecha_nac());
			boriginal.setTelefono(beneficiario.getTelefono());
			beneficiarioService.save(boriginal);
		} else {
			beneficiarioService.save(beneficiario);
		}
	}

	@DeleteMapping(value = "/beneficiaries/delete/{dni}")
	public void deleteByDNI(@PathVariable String dni) {
		Beneficiario beneficiario = beneficiarioService.findByDNI(dni);
		if (beneficiario != null) {
			beneficiarioService.deleteByDNI(dni);
		}
	}
}
