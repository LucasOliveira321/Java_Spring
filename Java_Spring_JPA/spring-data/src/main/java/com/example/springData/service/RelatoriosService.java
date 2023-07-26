package com.example.springData.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import com.example.springData.orm.Funcionario;
import com.example.springData.orm.FuncionarioProjecao;
import com.example.springData.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean valida;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository repository;
	
	public RelatoriosService(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		
		valida = true;
		
		while(valida) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, salario maior e data de contratacao");
			System.out.println("3 - Busca funcionario por data de contratacao igual ou maior");
			System.out.println("4 - Busca funcionario por salario");
			
			int selecao = scanner.nextInt();
			
			switch (selecao) {
				case 1:
					buscaFuncionarioNome(scanner);
					break;
				case 2:
					buscaFuncionarioNomeSalarioMaiorData(scanner);
					break;
				case 3:
					buscaFuncionarioDataContratacao(scanner);
					break;	
				case 4:
					pequisaFuncionarioSalario();
					break;
				default:
					valida = false;
					break;
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String name = scanner.next();
		
		List<Funcionario> list = repository.findByNome(name);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		
		System.out.println("Qual salário igual ou maior que");
		BigDecimal salario = scanner.nextBigDecimal();
		
		System.out.println("Qual data de contratação");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = repository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Qual data contratacao deseja pesquisar");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = repository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
	
	private void pequisaFuncionarioSalario() {
		List<FuncionarioProjecao> list = repository.findFuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionario: id: " + f.getId() + ", nome: "+ f.getNome() + ", salario: " + f.getSalario()));
	}
}
