package io.github.lisfribeiro.localizacao.domain.repository;

import io.github.lisfribeiro.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    List<Cidade> findByNome(String nome);

    // Ordenado
    @Query(" select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    // Paginado
    @Query(" select c from Cidade c where lower(c.nome) like lower(?1) ")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);
}
