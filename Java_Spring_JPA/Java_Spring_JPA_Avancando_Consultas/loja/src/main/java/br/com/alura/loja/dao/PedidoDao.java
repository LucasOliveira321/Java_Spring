package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class PedidoDao {
	
	private EntityManager em;
	
	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	
	// Foi criado uma Query com atributos de três entidades
	// Portando quando vamos criar uma query com colunas
	// de mais de uma entidade precisamos criar uma classe
	// com o nome do relatório que está sendo feito mais o 
	// Vo (Value Object) no final igual está sendo feito abaixo
	
	// Já no SELECT instanciamos a classe criada passando os
	// atributos das outras outras entidades que vão compor
	// a classe Vo e o caminho da classe
	public List<RelatorioDeVendasVo> relatórioDeVendas(){
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade), MAX(pedido.data)) FROM Pedido pedido "+
					  "JOIN pedido.itens item " +
				      "JOIN item.produto produto " +
					  "GROUP BY produto.nome " +
				      "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
	
	// Para carregar uma entidade com os atributos FETCH LAZY
	// podemos criar um método específico para esse carregamento
	// onde vamos informar no SELECT antes do WHERE a informação
	// JOIN FETCH entidade.atributoASerChamado no caso abaixo é
	// p.cliente
	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class).setParameter("id", id).getSingleResult();
	}
	
	
	// O método abaixo é uma busca com os parâmetros opcionais
	// e pode ser utilizado um ou todos o parâmetros do método
	// que será adicionado na query conforme os parâmetros atribuidos.
	// Quando chamar o método os parâmetros que não for utilizar
	// é preciso colocar null.
	public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){
		// O where 1=1 é feito para dar true e facilitar os próxmos if's
		// que estão verificando os parametros passado no método
		String jpql = "SELECT p FROM Produto p WHERE 1=1 ";
		if(nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}
		if(preco != null) {
			jpql = " AND p.preco = :preco ";
		}
		if(dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}
		
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if(nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if(preco != null) {
			query.setParameter("preco", preco);
		}
		if(dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();
	}
	
	// É uma outra maneira de realizar o método com parâmetros
	// opcionais, mas utilizando o Critéria que é uma classe
	// que auxilia na construção do método.
	public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		
		if(nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if(preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if(dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
	}
}
