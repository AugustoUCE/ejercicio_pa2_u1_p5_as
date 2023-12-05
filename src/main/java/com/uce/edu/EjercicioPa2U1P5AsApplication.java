package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.sistema.repository.modelo.Propietario;
import com.uce.edu.sistema.repository.modelo.Vehiculo;
import com.uce.edu.sistema.service.IMatriculaServ;
import com.uce.edu.sistema.service.IPropietarioServ;
import com.uce.edu.sistema.service.IVehiculoServ;

@SpringBootApplication
public class EjercicioPa2U1P5AsApplication implements CommandLineRunner {
	@Autowired
	private IVehiculoServ vehiculoServ;
	
	@Autowired
	private IPropietarioServ propietarioServ;
	
	@Autowired
	private IMatriculaServ matriculaServ;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//vehiculo
		Vehiculo v= new Vehiculo();
		v.setMarca("nissan");
		v.setPlaca("pdt2074");
		v.setPrecio(new BigDecimal(5000));
		v.setTipo("pesado");
		this.vehiculoServ.guardar(v);
		
		System.out.println(this.vehiculoServ.buscar("pdt2074"));
		
		//Propietario
		Propietario p = new Propietario();
		p.setNombre("Augusto");
		p.setApellido("Salazar");
		p.setCedula("1752083905");
		p.setGenero("M");
		this.propietarioServ.guardar(p);
		//actualizar
		p.setNombre("Rony");
		p.setApellido("Quinaucho");
		this.propietarioServ.actualizar(p);
		
		System.out.println(this.propietarioServ.buscar("1752083905"));
		
		this.matriculaServ.matricular("1752083905", "pdt2074");
		System.out.println(this.matriculaServ.seleccionar("m1"));
		
	
		
	}

}
