package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;
	
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedidos/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoPedido dados) {
		Pedido pedido = dados.toPedido();
		
		repository.save(pedido);
		
		return "pedidos/formulario";
	}
}
