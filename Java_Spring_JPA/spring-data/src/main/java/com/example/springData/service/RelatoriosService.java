package com.example.springData.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.springData.repository.CargoRepository;

@Service
public class RelatoriosService {

	private Boolean valida;
	
//	public void inicial(Scanner scanner) {
//		
//		valida = true;
//		
//		while(valida) {
//			System.out.println("Qual acao de cargo deseja executar");
//			System.out.println("0 - Sair");
//			System.out.println("1 - Salvar Cargo");
//			System.out.println("2 - Atualizar Cargo");
//			System.out.println("3 - Visualizar Cargos");
//			System.out.println("4 - Deletar Cargos");
//			
//			int selecao = scanner.nextInt();
//			
//			switch (selecao) {
//				case 1:
//					salvar(scanner);
//					break;
//				case 2:
//					atualizarCargo(scanner);
//					break;
//				case 3:
//					visualizar();
//					break;
//				case 4:
//					deletar(scanner);
//					break;		
//				default:
//					valida = false;
//					break;
//			}
//		}
//	}
}
