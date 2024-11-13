package br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabricante")
public class FabricanteController {
    private final FabricanteRepository fabricanteRepository;

    public FabricanteController(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }
    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<FabricanteDto>> findAll() {
        return ResponseEntity.ok(fabricanteRepository.findAll().stream().map(FabricanteDto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<FabricanteDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(fabricanteRepository.findById(id).map(FabricanteDto::new));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<FabricanteDto>> findByNome(@PathVariable("nome") String nome) {
        List<Fabricante> fabricantes = fabricanteRepository.findByNome(nome);
        if (fabricantes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fabricantes.stream().map(FabricanteDto::new).toList());
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody FabricanteDto fabricanteDTO, UriComponentsBuilder uriBuilder) {
       var fabricante = fabricanteRepository.save(new Fabricante(null,fabricanteDTO.nome()));
       URI uri = uriBuilder.path("/api/v1/fabricante/{id}").buildAndExpand(fabricante.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<FabricanteDto> update(@PathVariable("id") Long id, @RequestBody FabricanteDto fabricanteDTO) {
        return fabricanteRepository.findById(id)
                .map(fabricante -> {
                    fabricante.setNome(fabricanteDTO.nome());
                    return ResponseEntity.ok(new FabricanteDto(fabricanteRepository.save(fabricante)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FabricanteDto> delete(@PathVariable("id") Long id) {
        var fabricante = fabricanteRepository.findById(id);
        if (fabricante.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        fabricanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
