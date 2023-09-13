package com.alugueltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alugueltech.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByClienteId(@Param("clienteId")Long clienteId);
	
	

}
