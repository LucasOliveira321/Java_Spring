package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	// A Tag @EmbeddedId é utilizada para
	// identificar a chave primaria composta
	// e na classe que está sendo referenciada
	// como id é colocado a teg @Embeddable
	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {}
	
	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "XPTO");
	}
	
}
