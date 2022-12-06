package io.github.lisfribeiro.localizacao.domain.repository;

import io.github.lisfribeiro.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
