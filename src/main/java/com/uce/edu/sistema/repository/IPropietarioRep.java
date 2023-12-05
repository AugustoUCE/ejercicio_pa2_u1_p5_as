package com.uce.edu.sistema.repository;

import com.uce.edu.sistema.repository.modelo.Propietario;

public interface IPropietarioRep {

	public Propietario seleccionar(String cedula);

	public void insertar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void eliminar(String cedula);

}
