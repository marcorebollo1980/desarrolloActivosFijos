package com.activos.fijos.reposiroty;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.activos.fijos.model.ActivosModel;


/**
 * Clase que permite crear un repositorio y se extiende de la interface JpaRepository
 * 
 * ***/
@Repository
public interface ActivosRepository extends JpaRepository<ActivosModel, Long>{
    
	

	
}
