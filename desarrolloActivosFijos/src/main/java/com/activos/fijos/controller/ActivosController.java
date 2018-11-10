package com.activos.fijos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.fijos.model.ActivosModel;
import com.activos.fijos.reposiroty.ActivosRepository;

@RestController
@ComponentScan("com.activos.fijos")
@RequestMapping("/activos_empresa")
public class ActivosController {
	
	@Autowired
	private ActivosRepository activosRepository;
	
	/**
	 * Metodo que permite buscar y mostrar todos los activos creados en la empresa.
	 *
	 * **/
	@GetMapping("/activos")
	public List<ActivosModel> findAllActives(){
		return activosRepository.findAll();
		
	}
	
	
	

}
