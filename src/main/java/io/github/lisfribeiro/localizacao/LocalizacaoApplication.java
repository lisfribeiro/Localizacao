package io.github.lisfribeiro.localizacao;

import io.github.lisfribeiro.localizacao.domain.entity.Cidade;
import io.github.lisfribeiro.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		listarCidades();
	}

	@Transactional
	public void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		repository.save(cidade);
	}

	public void listarCidades() {
		repository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}