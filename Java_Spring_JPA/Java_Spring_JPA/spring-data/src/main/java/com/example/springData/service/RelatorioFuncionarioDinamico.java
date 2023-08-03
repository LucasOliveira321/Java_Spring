package com.example.springData.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.springData.orm.Funcionario;
import com.example.springData.repository.FuncionarioRepository;
import com.example.springData.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scan) {
		System.out.println("Digite um nome");
		String nome = scan.next();
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite um cpf");
		String cpf = scan.next();
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite um salario");
		BigDecimal salario = scan.nextBigDecimal();
		if(salario.equals(BigDecimal.ZERO)) {
			salario = null;
		}
		
		System.out.println("Digite a data de contratação");
		String data = scan.next();
		LocalDate dataContratacao;
		if(data.equalsIgnoreCase("NULL")) {
			dataContratacao = null;
		}else {
			dataContratacao = LocalDate.parse(data, formatter);
		}
		
		List<Funcionario> fun = funcionarioRepository.findAll(
				Specification.where(
					SpecificationFuncionario.nome(nome))
					.or(SpecificationFuncionario.cpf(cpf))
					.or(SpecificationFuncionario.salario(salario))
					.or(SpecificationFuncionario.dataContratacao(dataContratacao))
				);
		fun.forEach(System.out::println);
	}
}
