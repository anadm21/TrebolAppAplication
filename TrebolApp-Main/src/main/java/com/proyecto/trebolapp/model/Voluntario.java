package com.proyecto.trebolapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="voluntario")
public class Voluntario {

	@Id
	@Column(name="IDVoluntario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDVoluntario;
	
	@Column(name="DNIVoluntario")
	@NotNull(message = "El DNI no puede ser nulo")
	private String DNIVoluntario;
	
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
	
	@Column(name="Fecha_antiguedad")
	@NotNull(message = "La fecha de antigüedad no puede ser nula")
	private String fecha_ant;
	
	@Column(name="Edad")
	@NotNull(message = "La edad no puede ser nula")
	private int edad;
	
	public int getIDVoluntario() {
		return IDVoluntario;
	}

	public void setIDVoluntario(int iDVoluntario) {
		IDVoluntario = iDVoluntario;
	}

	public String getDNIVoluntario() {
		return DNIVoluntario;
	}

	public void setDNIVoluntario(String dNIVoluntario) {
		DNIVoluntario = dNIVoluntario;
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

	public String getFecha_ant() {
		return fecha_ant;
	}

	public void setFecha_ant(String fecha_ant) {
		this.fecha_ant = fecha_ant;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
