package br.com.fiap.moviebox.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import br.com.fiap.moviebox.model.Filme;
import br.com.fiap.moviebox.repository.FilmeRepository;

@RestController
@RequestMapping("filme")
@Slf4j
@CacheConfig(cacheNames = "filmes")
@Tag(name = "filmes", description = "Endpoint relacionado com os filmes da plataforma")
public class FilmeController {

    @Autowired
    FilmeRepository filmeRepository;

    @GetMapping
    @Cacheable
    @Operation(summary = "Lista todas as categorias cadastradas no sistema.",
            description = "Endpoint que retorna um array de objetos do tipo filmes")
    public List<Filme> index() {
        return filmeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CacheEvict(allEntries = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro de validação da categoria"),
            @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso")
    })
    public Filme create(@RequestBody Filme filme) {
        log.info("cadastrando filme: {}", filme);
        filmeRepository.save(filme);
        return filme;
    }

    @GetMapping("{id}")
    public ResponseEntity<Filme> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return filmeRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping("{id}")
    @CacheEvict(allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando filme {}", id);

        verificarSeExisteFilme(id);

        filmeRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }


    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Filme filme){
        log.info("atualizando filme id {} para {}", id, filme);

        verificarSeExisteFilme(id);

        filme.setId(id);
        filmeRepository.save(filme);
        return ResponseEntity.ok(filme);
    }


    private void verificarSeExisteFilme(Long id) {
        filmeRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado" )
                );
    }


}
