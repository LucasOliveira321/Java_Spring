package com.example.springData;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springData.service.CrudCargoService;
import com.example.springData.service.CrudFuncionarioService;
import com.example.springData.service.CrudUnidadeService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Boolean valida = true;
	private	final CrudCargoService crudCargoService;
	private	final CrudFuncionarioService crudFuncionarioService;
	private	final CrudUnidadeService crudUnidadeService;
	
	
	public DemoApplication(CrudCargoService cargo, CrudFuncionarioService funcionario,CrudUnidadeService unidade ) {
		this.crudCargoService = cargo;
		this.crudFuncionarioService = funcionario;
		this.crudUnidadeService = unidade;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(valida) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			
			int action = scanner.nextInt();
			
			switch (action) {
				case 1:
					crudCargoService.inicial(scanner);
					break;
				case 2:
					crudFuncionarioService.inicial(scanner);
					break;
				case 3:
					crudUnidadeService.inicial(scanner);
					break;	
				default:
					valida = false;
			}			
		}
	}

}
