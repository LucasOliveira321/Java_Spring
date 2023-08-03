package com.example.springData.service;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import com.example.springData.orm.Unidade;
import com.example.springData.repository.UnidadeRepository;


@Service
public class CrudUnidadeService{
	
	private Boolean valida;
	private final UnidadeRepository repository;
	
	public CrudUnidadeService(UnidadeRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		
		valida = true;
		
		while(valida) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar Unidade");
			System.out.println("2 - Atualizar Unidade");
			System.out.println("3 - Visualizar Unidades");
			System.out.println("4 - Deletar Unidade");
			
			int selecao = scanner.nextInt();
			
			switch (selecao) {
				case 1:
					salvar(scanner);
					break;
				case 2:
					atualizarUnidade(scanner);
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
		System.out.println("Informar descricao");
		String descricao = scanner.next();
		
		System.out.println("Informar endereco");
		String endereco = scanner.next();
		
		Unidade unidade = new Unidade();
		unidade.setDescricao(descricao);
		unidade.setEnderecao(endereco);
		
		repository.save(unidade);	
		System.out.println("Unidade salva");
	}
	
	public void atualizarUnidade(Scanner scanner) {
		System.out.println("Informar id");
		Integer id = scanner.nextInt();
		
		Optional<Unidade> unid = repository.findById(id);
		if(unid.isEmpty()) {
			System.out.println("Este id não existe!");
			atualizarUnidade(scanner);
		}else {
			System.out.println("Informar descricao");
			String descricao = scanner.next();
			
			System.out.println("Informar endereco");
			String endereco = scanner.next();
			
			unid.get().setDescricao(descricao);
			unid.get().setEnderecao(endereco);
		}
		System.out.println("Unidade atualizada");
	}
	
	public void visualizar(){
		Iterable<Unidade> unid = repository.findAll();
		unid.forEach(unidade -> System.out.println(unidade));
	}

	public void deletar(Scanner scanner) {
		System.out.println("Informar o id");
		Integer id = scanner.nextInt();
		
		repository.deleteById(id);
		System.out.println("Unidade deletada");
	}
}