package com.uce.edu.sistema.service;

import com.uce.edu.sistema.repository.modelo.Propietario;

public interface IPropietarioServ {
	public Propietario buscar(String cedula);

	public void guardar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void eliminar(String cedula);

}
