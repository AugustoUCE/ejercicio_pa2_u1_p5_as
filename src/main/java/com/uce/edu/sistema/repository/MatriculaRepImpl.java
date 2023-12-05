package com.uce.edu.sistema.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.sistema.repository.modelo.Matricula;

@Repository
public class MatriculaRepImpl implements IMatriculaRep {
	private static List<Matricula> base = new ArrayList<>();

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);
	}

	@Override
	public Matricula seleccionar(String codigo) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getCodigo().equals(codigo)) {
				Matricula m= new Matricula();
				m.setCodigo(matricula.getCodigo());
				m.setFechaMatricula(matricula.getFechaMatricula());
				m.setPropietario(matricula.getPropietario());
				m.setValorMatricula(matricula.getValorMatricula());
				m.setVehiculo(matricula.getVehiculo());
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getCodigo());
		this.insertar(matricula);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Matricula m= this.seleccionar(codigo);
		base.remove(m);
	}

}
