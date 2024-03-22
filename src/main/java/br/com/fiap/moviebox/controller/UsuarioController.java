package br.com.fiap.moviebox.controller;

import br.com.fiap.moviebox.model.Usuario;
import br.com.fiap.moviebox.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> index() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario: {}", usuario);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return usuarioRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando usuario {}", id);

        verificarSeExisteUsuario(id);
        usuarioRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("atualizando usuario id {} para {}", id, usuario);

        verificarSeExisteUsuario(id);

        usuario.setId(id);
        return usuarioRepository.save(usuario);

    }

    private void verificarSeExisteUsuario(Long id) {
        usuarioRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado" )
                );
    }

}
