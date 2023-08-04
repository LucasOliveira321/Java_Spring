package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro extends Produto{
	
	private String autor;
	private Integer paginas;
	
	public Livro(){}
	
	public Livro(String autor, Integer paginas) {
		super();
		this.autor = autor;
		this.paginas = paginas;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	
}
