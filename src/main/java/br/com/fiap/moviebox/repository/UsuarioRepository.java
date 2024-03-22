package br.com.fiap.moviebox.repository;

import br.com.fiap.moviebox.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
