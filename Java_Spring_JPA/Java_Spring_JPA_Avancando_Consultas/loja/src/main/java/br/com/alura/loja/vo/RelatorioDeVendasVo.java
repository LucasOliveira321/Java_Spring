package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
	
	private String nomeProduto;
	// Não podemos colocar como int pq na query que estamos fazendo
	// estamos aplicando um SUM(), no atributo que é int e o valor
	// retornado é um long
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;
	
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
}
