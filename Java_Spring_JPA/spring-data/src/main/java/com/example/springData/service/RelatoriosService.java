package com.example.springData.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.springData.orm.Funcionario;
import com.example.springData.repository.CargoRepository;
import com.example.springData.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean valida;
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
			
			
			int selecao = scanner.nextInt();
			
			switch (selecao) {
				case 1:
					buscaFuncionarioNome(scanner);
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
}
