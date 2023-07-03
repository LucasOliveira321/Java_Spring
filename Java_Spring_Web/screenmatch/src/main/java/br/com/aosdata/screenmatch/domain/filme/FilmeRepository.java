package br.com.aosdata.screenmatch.domain.filme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    // A interface JpaRepository já possuí métodos para realizar as operações de CRUD
    // por isso não é necessário criar métodos dentro desta Interface
}
