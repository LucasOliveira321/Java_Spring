package br.com.aosdata.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracao;
    private Integer ano;
    private String genero;

    public Filme(){
        // A JPA exige que tenha um construtor "Padrão", sem parâmetros
    }
    public Filme(DadosCadastroFilme dados){
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

    @Override
    public String toString() {
        return "Filme: " + nome + ", duração: "+duracao+", ano de lançamento: "+ano+", gênero: "+genero;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public Integer getAno() {
        return ano;
    }
    public String getGenero() {
        return genero;
    }

    public void atualizaDados(DadosAlteracaoFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }
}
