package com.uce.edu.sistema.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.sistema.repository.IMatriculaRep;
import com.uce.edu.sistema.repository.IPropietarioRep;
import com.uce.edu.sistema.repository.IVehiculoRep;
import com.uce.edu.sistema.repository.modelo.Matricula;
import com.uce.edu.sistema.repository.modelo.Propietario;
import com.uce.edu.sistema.repository.modelo.Vehiculo;

@Service
public class MatriculaServImpl implements IMatriculaServ {

	@Autowired
	private IMatriculaRep matriculaRep;
	@Autowired
	private IVehiculoRep vehiculoRep;
	@Autowired
	private IPropietarioRep propietarioRep;

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRep.insertar(matricula);
	}

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario p=this.propietarioRep.seleccionar(cedula);
		Vehiculo v=this.vehiculoRep.seleccionar(placa);
		Matricula m= new Matricula();
		BigDecimal precio=v.getPrecio();
		BigDecimal valorMatriculaF=m.getValorMatricula();

			if (v.getTipo().toLowerCase().contains("pesado")) {
			BigDecimal valorM=precio.multiply(new BigDecimal(0.25));
			m.setValorMatricula(valorM);
			this.matriculaRep.actualizar(m);
			valorMatriculaF=valorM;
			
		} else if (v.getTipo().toLowerCase().contains("liviano")) {
			
			BigDecimal valorM=precio.multiply(new BigDecimal(0.20));
			m.setValorMatricula(valorM);
			this.matriculaRep.actualizar(m);
			valorMatriculaF=valorM;
		}
		//descuento
		if (valorMatriculaF.compareTo(new BigDecimal(2200))>0) {
			BigDecimal des=valorMatriculaF.multiply(new BigDecimal(0.05));
			BigDecimal valorMaFiDes=valorMatriculaF.subtract(des);
			m.setValorMatricula(valorMaFiDes);
			this.matriculaRep.actualizar(m);
			valorMatriculaF=valorMaFiDes;
		}
		
		m.setCodigo("m1");
		m.setFechaMatricula(LocalDateTime.now());
		m.setValorMatricula(valorMatriculaF);
		m.setPropietario(p);
		m.setVehiculo(v);
		this.matriculaRep.insertar(m);
		
		}
	

	@Override
	public Matricula seleccionar(String codigo) {
		// TODO Auto-generated method stub
		return this.matriculaRep.seleccionar(codigo);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRep.actualizar(matricula);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.matriculaRep.eliminar(codigo);
	}

}
