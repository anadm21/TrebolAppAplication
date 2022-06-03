package com.proyecto.trebolapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="socio")
public class Socio {

	@Id
	@Column(name="IDSocio")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDSocio;
	
	@Column(name="DNISocio")
	@NotNull(message = "El DNI no puede ser nulo")
	private String DNISocio;
	
	@Column(name="Nombre")
	@NotNull(message = "El nombre no puede ser nulo")
	private String nombre;
	
	@Column(name="Apellidos")
	@NotNull(message = "Los apellidos no pueden ser nulos")
	private String apellidos;
	
	@Column(name="Direccion")
	@NotNull(message = "La dirección no puede ser nula")
	private String direccion;
	
	@Column(name="Telefono")
	@NotNull(message = "El teléfono no puede ser nulo")
	private String telefono;
	
	@Column(name="Fecha_nac")
	@NotNull(message = "La fecha de nacimiento no puede ser nula")
	private String fecha_nac;

	@Column(name="Cuenta_bancaria")
	@NotNull(message = "El número de cuenta no puede ser nulo")
	private String cuenta_bancaria;

	@Column(name="Cuota")
	@NotNull(message = "La cuota no puede ser nula")
	private double cuota;

	public int getIDSocio() {
		return IDSocio;
	}

	public void setIDSocio(int iDSocio) {
		IDSocio = iDSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDNISocio() {
		return DNISocio;
	}

	public void setDNISocio(String dNISocio) {
		DNISocio = dNISocio;
	}

	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	
}
