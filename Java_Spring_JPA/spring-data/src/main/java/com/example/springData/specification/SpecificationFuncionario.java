package com.example.springData.specification;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.example.springData.orm.Funcionario;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome){
		return(root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Funcionario> cpf(String cpf){
		return(root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(BigDecimal salario){
		return(root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("salario"),salario);
	}
	
	public static Specification<Funcionario> dataContratacao(LocalDate data){
		return(root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("dataContratacao"),  data );
	}
	
}
