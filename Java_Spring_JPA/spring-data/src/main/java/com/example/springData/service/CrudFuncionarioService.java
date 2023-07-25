package com.example.springData.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import com.example.springData.orm.Funcionario;
import com.example.springData.repository.CargoRepository;
import com.example.springData.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService{
	
	private Boolean valida;
	private final FuncionarioRepository repository;
	private final CargoRepository cargoRepository;
	
	public CrudFuncionarioService(FuncionarioRepository repository, CargoRepository cargoRepository) {
		this.repository = repository;
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		valida = true;
		
		while(valida) {
			System.out.println("Qual acao do funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar Funcionario");
			System.out.println("2 - Atualizar Funcionario");
			System.out.println("3 - Visualizar Funcionarios");
			System.out.println("4 - Deletar Funcionario");
			
			int selecao = scanner.nextInt();
			
			switch (selecao) {
				case 1:
					salvar(scanner);
					break;
				case 2:
					atualizarFuncionario(scanner);
					break;
				case 3:
					visualizar();
					break;
				case 4:
					deletar(scanner);
					break;		
				default:
					valida = false;
					break;
			}
		}
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Informar nome");
		String nome = scanner.next();
		
		System.out.println("Informar cpf");
		String cpf = scanner.next();
		
		System.out.println("Informar salario");
		BigDecimal salario = scanner.nextBigDecimal();
		
		System.out.println("Informar id do cargo");
		Integer idCargo = scanner.nextInt();
		
		Funcionario fun = new Funcionario();
		fun.setNome(nome);
		fun.setCpf(cpf);
		fun.setSalario(salario);
		fun.setCargo(cargoRepository.findById(idCargo));
		fun.setDataContratacao(LocalDate.now());
		
		repository.save(fun);
		
		System.out.println("Funcionario Cadastrado");	
	}
	
	public void atualizarFuncionario(Scanner scanner) {
		System.out.println("Informar id");
		Integer id = scanner.nextInt();
		Optional<Funcionario> funcionario = repository.findById(id);
		
		if(funcionario.isEmpty()) {
			System.out.println("Este id não existe!");
			atualizarFuncionario(scanner);
		}else {
			System.out.println("Informar nome");
			String nome = scanner.next();
			
			System.out.println("Informar cpf");
			String cpf = scanner.next();
			
			System.out.println("Informar salario");
			BigDecimal salario = scanner.nextBigDecimal();
			
			funcionario.get().setNome(nome);
			funcionario.get().setCpf(cpf);
			funcionario.get().setSalario(salario);
			funcionario.get().setDataContratacao(LocalDate.now());
			
			System.out.println("Funcionario Alterado");
		}
	}

	public void visualizar() {
		Iterable<Funcionario> fun = repository.findAll();
		fun.forEach(funcionario -> System.out.println(funcionario));
	}

	public void deletar(Scanner scanner) {
		System.out.println("Informar o id do funcionario");
		Integer id = scanner.nextInt();
		
		repository.deleteById(id);
		
		System.out.println("Funcionario Deletado");
	}
}
