package com.proyecto.trebolapp.commons;

import java.io.Serializable;
import java.util.List;

//Interfaz genérica
public interface GenericService<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID dni);
	
	T get(ID dni);
	
	List<T> getAll();
}
