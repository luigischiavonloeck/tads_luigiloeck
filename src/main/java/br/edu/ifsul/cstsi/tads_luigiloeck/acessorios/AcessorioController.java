package br.edu.ifsul.cstsi.tads_luigiloeck.acessorios;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/acessorio")
public class AcessorioController {
    private final AcessorioRepository acessorioRepository;

    public AcessorioController(AcessorioRepository acessorioRepository) {
        this.acessorioRepository = acessorioRepository;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<AcessorioDto>> findAll() {
        return ResponseEntity.ok(acessorioRepository.findAll().stream().map(AcessorioDto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<AcessorioDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(acessorioRepository.findById(id).map(AcessorioDto::new));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<AcessorioDto>> findByDescricao(@PathVariable("descricao") String descricao) {
        List<Acessorio> acessorios = acessorioRepository.findByDescricao(descricao);
        if (acessorios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(acessorios.stream().map(AcessorioDto::new).toList());
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody AcessorioDto acessorioDTO, UriComponentsBuilder uriBuilder) {
        var acessorio = acessorioRepository.save(acessorioDTO.toAcessorio());
        URI uri = uriBuilder.path("/api/v1/acessorio/{id}").buildAndExpand(acessorio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AcessorioDto> update(@PathVariable("id") Long id, @RequestBody AcessorioDto acessorioDTO) {
        return acessorioRepository.findById(id)
                .map(acessorio -> {
                    acessorio.setDescricao(acessorioDTO.descricao());
                    return ResponseEntity.ok(new AcessorioDto(acessorioRepository.save(acessorio)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AcessorioDto> delete(@PathVariable("id") Long id) {
        var acessorio = acessorioRepository.findById(id);
        if (acessorio.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        acessorioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}