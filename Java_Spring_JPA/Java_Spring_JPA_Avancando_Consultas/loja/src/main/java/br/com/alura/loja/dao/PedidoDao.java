package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
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
	
}
