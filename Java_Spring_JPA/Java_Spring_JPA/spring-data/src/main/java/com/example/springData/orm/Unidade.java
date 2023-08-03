package com.example.springData.orm;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String enderecao;
	
	@ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios;
	
	
	
	
	
	
	public List<Funcionario> getFuncionarios(){
		return this.funcionarios;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEnderecao() {
		return enderecao;
	}
	public void setEnderecao(String enderecao) {
		this.enderecao = enderecao;
	}
	@Override
	public String toString() {
		return "Unidade [id=" + id + ", descricao=" + descricao + ", enderecao=" + enderecao + "]";
	}
}
