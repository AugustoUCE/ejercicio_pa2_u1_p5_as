package com.uce.edu.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.sistema.repository.IPropietarioRep;
import com.uce.edu.sistema.repository.modelo.Propietario;

@Service
public class PropietarioServImpl implements IPropietarioServ {

	@Autowired
	private IPropietarioRep propietarioRep;

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRep.seleccionar(cedula);
	}

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRep.insertar(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRep.actualizar(propietario);

	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioRep.eliminar(cedula);
	}

}
