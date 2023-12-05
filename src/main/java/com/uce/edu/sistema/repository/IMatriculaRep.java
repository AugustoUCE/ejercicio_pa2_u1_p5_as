package com.uce.edu.sistema.repository;

import com.uce.edu.sistema.repository.modelo.Matricula;

public interface IMatriculaRep {
	public Matricula seleccionar(String codigo);
	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public void eliminar(String codigo);
	
	
}