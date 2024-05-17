package br.com.fiap.moviebox.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.moviebox.controller.FilmeController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.hateoas.EntityModel;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Filme extends EntityModel<Filme>{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{filme.nome.notblank}")
    @Size(min = 2, max = 100, message = "{filme.nome.size}")
    private String nome;

    public EntityModel<Filme> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(FilmeController.class).get(id)).withSelfRel(),
                linkTo(methodOn(FilmeController.class).destroy(id)).withRel("delete")
        );
    }
}
