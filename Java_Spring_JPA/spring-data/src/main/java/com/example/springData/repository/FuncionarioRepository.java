package com.example.springData.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.springData.orm.Funcionario;


@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
	
	// Derived Queries
	
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, BigDecimal salario, LocalDate data);
	Optional<Funcionario> findById(Integer id);
	void save(Funcionario fun);
	void deleteById(Integer id);
	Page<Funcionario> findAll();
	
	//JPQL - Utiliza as tipagens abaixo
	
	@Query("SELECT f FROM Funcionario f	WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, BigDecimal salario, LocalDate data);
	@Query("""
			select
				f.id
			from
				Funcionario f
			where 
				f.nome = :nome
			""")
	Integer findIdByNome(String nome);
	
	//QUERY - native queries do SQL
	
	@Query(value = "select * from funcionario f where f.data_contratacao >= :data",
		   nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	
	
}
