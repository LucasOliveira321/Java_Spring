package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// adiciona os atributos de outra classe a
	// entidade atual no banco de dados
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public Clientes(){}
	
	public Clientes(String nome, String cpf){
		this.dadosPessoais = new DadosPessoais(nome,cpf);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
}
