package com.example.springData.service;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import com.example.springData.orm.Cargo;
import com.example.springData.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	
	private Boolean valida;
	private CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		valida = true;
		
		while(valida) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar Cargo");
			System.out.println("2 - Atualizar Cargo");
			System.out.println("3 - Visualizar Cargos");
			System.out.println("4 - Deletar Cargos");
			
			int selecao = scanner.nextInt();
			
			switch (selecao) {
				case 1:
					salvar(scanner);
					break;
				case 2:
					atualizarCargo(scanner);
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
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	
	private void atualizarCargo(Scanner scanner) {
		
		System.out.println("Informar o id do cargo que será atualizada");
		Integer id = scanner.nextInt();
		
		Optional<Cargo> cargo = cargoRepository.findById(id);
		
		if(cargo.equals(Optional.empty())) {
			System.out.println("ID não localizado, informar novamente");
			atualizarCargo(scanner);
		}else {
			System.out.println("Informar a descricao para alteracao");
			String descricao = scanner.next();
			
			cargo.get().setDescricao(descricao);
			System.out.println("Atualizado");
		}	
	}

	private void visualizar() {
		Iterable<Cargo> cargoIterable = cargoRepository.findAll();
		cargoIterable.forEach(cargo -> System.out.println(cargo));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Informar o ID");
		Integer id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Cargo deletado");
	}
}
 