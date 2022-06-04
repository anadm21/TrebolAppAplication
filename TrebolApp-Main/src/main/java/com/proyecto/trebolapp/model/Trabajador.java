package com.proyecto.trebolapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="trabajador")
public class Trabajador {

	
	@Id
	@Column(name="IDTrabajador")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDTrabajador;
	
	@Column(name="DNITrabajador")
	@NotNull(message = "El DNI no puede ser nulo")
	private String DNITrabajador;
	
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
	
	@Column(name="Turno")
	@NotNull(message = "El turno no puede ser nulo")
	private String turno;
	
	@Column(name="Tipo_contrato")
	@NotNull(message = "El tipo de contrato no puede ser nulo")
	private String tipo_contrato;
	
	@Column(name="Salario")
	@NotNull(message = "El salario no puede ser nulo")
	private double salario;
	
	@Column(name="Num_SS")
	@NotNull(message = "El número de la seguridad social no puede ser nulo")
	private String num_SS;
	
	@Column(name="Cuenta_bancaria")
	@NotNull(message = "El número de cuenta no puede ser nulo")
	private String cuenta_bancaria;	
	
	public int getIDTrabajador() {
		return IDTrabajador;
	}

	public void setIDTrabajador(int iDTrabajador) {
		IDTrabajador = iDTrabajador;
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

	public String getDNITrabajador() {
		return DNITrabajador;
	}

	public void setDNITrabajador(String dNITrabajador) {
		DNITrabajador = dNITrabajador;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNum_SS() {
		return num_SS;
	}

	public void setNum_SS(String num_SS) {
		this.num_SS = num_SS;
	}

	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
}
