package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Notebook");
		pedido.setUrlDaImagem("https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/g-series/g15-5530/media-gallery/gray/non-touch/coral/notebook-laptop-g15-5530-gray-gallery-1-v2.psd?fmt=png-alpha&pscan=auto&scl=1&hei=402&wid=554&qlt=100,1&resMode=sharp2&size=554,402&chrss=full");
		pedido.setUrlDoProduto("https://www.dell.com/pt-br/shop/notebooks/novo-notebook-gamer-dell-g15/spd/g-series-15-5530-laptop/g5530u007w");
		pedido.setDescricao("Jogue mais de 100 games para PC de alta qualidade com o novo PC Dell G e um mês de XBOX Game Pass Ultimate (disponível nas configurações com Windows), incluindo o game EA. Adicionamos novos games o tempo todo. Sempre tem alguma novidade. Para games em nuvem com o XBOX Game Pass Ultimate, é obrigatório usar um controlador conectado.");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
