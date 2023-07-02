package br.com.aosdata.screenmatch.controller;

import br.com.aosdata.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.aosdata.screenmatch.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {
    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }
    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", filmes);

        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados){
        var filme = new Filme(dados);
        filmes.add(filme);

        // O redirect é um comando do Spring que redireciona para alguma URL
        // Neste caso ao cadastrar o filme ele vai direcionar para
        // http://localhost:8080/filmes, que é a URL do comando carregaPaginaListagem
        // fazendo com que seja direcionado a página de lista de filmes com a variável lista.
        return "redirect:/filmes";
    }

}
