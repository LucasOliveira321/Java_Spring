package com.example.springData.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.springData.orm.Unidade;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer>{

}
