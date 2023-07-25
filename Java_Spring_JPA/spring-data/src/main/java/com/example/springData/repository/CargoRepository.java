package com.example.springData.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.springData.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{
	
}
