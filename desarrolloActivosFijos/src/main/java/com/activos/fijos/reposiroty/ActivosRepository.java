package com.activos.fijos.reposiroty;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activos.fijos.model.ActivosModel;

@Repository
public interface ActivosRepository extends JpaRepository<ActivosModel, Long>{
;
}
