package com.uce.edu.sistema.service;

import com.uce.edu.sistema.repository.modelo.Matricula;

public interface IMatriculaServ {
	public Matricula seleccionar(String codigo);
	
	public void guardar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public void eliminar(String codigo);
	
	public void matricular(String cedula, String placa);

}
