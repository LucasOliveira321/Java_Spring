package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;

public class RequisicaoNovoPedido {
	
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescrcao() {
		return descricao;
	}
	public void setDescrcao(String descrcao) {
		this.descricao = descrcao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlDaImagem(urlImagem);
		pedido.setUrlDoProduto(nomeProduto);
		return pedido;
	}

}