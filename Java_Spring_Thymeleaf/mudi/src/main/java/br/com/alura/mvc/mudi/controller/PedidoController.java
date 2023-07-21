package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String formulario(@Valid RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedidos/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "pedidos/formulario";
		}
		
		Pedido pedido = requisicaoNovoPedido.toPedido();
		
		repository.save(pedido);
		
		return "pedidos/formulario";
	}
}
