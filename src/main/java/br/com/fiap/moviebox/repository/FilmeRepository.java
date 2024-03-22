package br.com.fiap.moviebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.moviebox.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
