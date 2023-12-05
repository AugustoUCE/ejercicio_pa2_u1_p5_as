package com.uce.edu.sistema.service;

import com.uce.edu.sistema.repository.modelo.Vehiculo;

public interface IVehiculoServ {
	
	public Vehiculo buscar(String placa);

	public void guardar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}
