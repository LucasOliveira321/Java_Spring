package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	
	/**
	 * Todo relacionamento com final "ToOne" é realizado o join
	 * na classe que está sendo vinculada e assim se repete na
	 * próxima classe, se tiver outro relacionamento "ToOne"
	 * é realizado tambem o join criando um efeito cascata
	 * que dependento da ramificação pode ser realizado um SELECT
	 * por de baixos dos panos muito grande, tornando assim 
	 * mais demorado o processo, mesmo se for instanciar uma
	 * Entidade para buscar apenas um atributo.
	 * Portanto como boa prática é importante colocar o método
	 * fetch = FetchTupe.LAZY que vai quebrar este efeito e deixar
	 * mais performático o código
	 * 
	 * */
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Clientes cliente;
	/**
	 * Ao criar a relação bidirecional(onde é criado a 3ª tabela em uma relação n*n)
	 * é preciso informar do lado 'ToMany' o mappedBy = "nome do atributo que está conectando".
	 * 
	 * Cascade faz com que a entidade ItemPedido só exista com uma outra
	 * entidade Pedido, caso a entidade Pedido seja excluída a entidade ItemPedido
	 * também será excluída.
	 * 
	 * E como boa prática é bom sempre iniciar a lista para não ter que 
	 * criar if's no decorrer do projeto para verificar se a lista foi iniciada.
	 */
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido(Clientes cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Método utilitário adiciona este pedido ao item
	 * e adiciona o item vinculado a este pedido
	 * a lista de itens deste mesmo pedido.
	 * */
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Clientes getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Clientes cliente){
		this.cliente = cliente;
	}
}
