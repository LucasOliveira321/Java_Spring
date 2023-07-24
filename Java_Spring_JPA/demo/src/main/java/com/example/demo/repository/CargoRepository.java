package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{
	
}
