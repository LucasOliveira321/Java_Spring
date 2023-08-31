package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    // Este atributo Autowired faz a injeção de dependências, instanciando automaticamente este atributo
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>>  listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        // findAll() - é um método que busca todos os valores
        // já o atributo colocado no findAll(paginacao) é um metodo que monta
        // a query com um esquema de páginação

        // findAllByAtivoTrue(paginacao) - é um método que criamos com o padrão
        // de nomenclatura utilizado no métodos. Por ter esse padrão a query
        // vai ser criada de forma automática para filtrar na coluna ativo os
        // usuarios com situação do ativo = true

        var pag = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

        return ResponseEntity.ok(pag);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformações(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        //ResponseEntity é uma classe do Spring utilizada para o tratamento em relação ao retorno do HTTP
        //Por padrão ele sempre retorna "200 ok" nas requisições,
        //Neste caso abaixo passa a retornar 204 NoContent que é o mais adequado a se retornar em uma
        //Requisição de DELETE
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
