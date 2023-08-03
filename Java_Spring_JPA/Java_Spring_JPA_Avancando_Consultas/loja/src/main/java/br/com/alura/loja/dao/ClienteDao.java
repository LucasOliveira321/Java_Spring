package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import br.com.alura.loja.modelo.Clientes;
import br.com.alura.loja.modelo.Produto;


public class ClienteDao {
	
	private EntityManager em;
	
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Clientes cliente) {
		this.em.persist(cliente);
	}

	public Clientes buscarPorId(long id) {
		return em.find(Clientes.class, id);
	}
	
}
