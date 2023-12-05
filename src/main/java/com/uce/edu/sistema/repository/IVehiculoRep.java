package com.uce.edu.sistema.repository;

import com.uce.edu.sistema.repository.modelo.Vehiculo;

public interface IVehiculoRep {

	public Vehiculo seleccionar(String placa);

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}
