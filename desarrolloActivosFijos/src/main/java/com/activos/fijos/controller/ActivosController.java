package com.activos.fijos.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activos.fijos.exceptions.RestResponse;
import com.activos.fijos.model.ActivosModel;
import com.activos.fijos.reposiroty.ActivosRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@ComponentScan("com.activos.fijos")
@RequestMapping("/activos_empresa")
public class ActivosController {
	
	protected ObjectMapper mapper;
	
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
	
	/**
	 * Metodo que permite buscar y mostrar todos los activos creados en la empresa.
	 *
	 * **/
    @GetMapping("/activo/{serial_activos}")
    public Optional<ActivosModel> getActivosById(@PathVariable(value = "serial_activos") Long serial_activos) {
    	
    	return activosRepository.findById(serial_activos);	
    	
    }
    
    
    /***
	 * Este metodo permite ingresar nuevos activos a la base de datos y actualizar
	 * los activos de la empresa
	 * 
	 */  
	@RequestMapping(value = "saveorupdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		ActivosModel activosModel = this.mapper.readValue(userJson, ActivosModel.class);

		if (!this.validateCampos(activosModel)) {

			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		this.activosRepository.save(activosModel);

		return new RestResponse(HttpStatus.OK.value(), "Consulta Realizada de forma exitosa");
	}

	/***
	 * Este metodo permite realizar las validaciones de los campos obligatorios
	 * 
	 * */
	private boolean validateCampos(ActivosModel activos) {

		boolean isValid = true;

		if (activos.getNombre() == null || activos.getNombre() == "") {
			isValid = false;
		}

		if (activos.getSerial_activos() == null) {
			isValid = false;
		}

		if (activos.getDescripcion() == null || activos.getDescripcion() == "") {
			isValid = false;
		}
		
		if (activos.getTipo() == null || activos.getTipo() == "") {
			isValid = false;
		}
		
	
		if (activos.getFecha_compra() == null) {
			isValid = false;
		}
		
		if (activos.getFecha_baja() == null) {
			isValid = false;
		}
		
		if (activos.getEstado_actual() == null || activos.getEstado_actual() == "") {
			isValid = false;
		}
		
		if (activos.getColor() == null || activos.getColor() == "") {
			isValid = false;
		}
		
		if (activos.getArea() == null || activos.getArea() == "") {
			isValid = false;
		}
		return isValid;
	}
	
	
}
