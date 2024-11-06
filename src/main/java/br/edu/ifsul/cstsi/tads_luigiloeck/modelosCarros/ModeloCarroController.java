package br.edu.ifsul.cstsi.tads_luigiloeck.modelosCarros;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/modeloCarro")
public class ModeloCarroController {
    private final ModeloCarroRepository modeloCarroRepository;

    public ModeloCarroController(ModeloCarroRepository modeloCarroRepository) {
        this.modeloCarroRepository = modeloCarroRepository;
    }

    @GetMapping
    public ResponseEntity<List<ModeloCarroDto>> findAll() {
        return ResponseEntity.ok(modeloCarroRepository.findAll().stream().map(ModeloCarroDto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ModeloCarroDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(modeloCarroRepository.findById(id).map(ModeloCarroDto::new));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<ModeloCarroDto>> findByDescricao(@PathVariable("descricao") String descricao) {
        List<ModeloCarro> modelosCarros = modeloCarroRepository.findByDescricao(descricao);
        if (modelosCarros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelosCarros.stream().map(ModeloCarroDto::new).toList());
    }

    @PostMapping
    public ResponseEntity<URI> insert(@RequestBody ModeloCarroDto modeloCarroDTO, UriComponentsBuilder uriBuilder) {
        var modeloCarro = modeloCarroRepository.save(new ModeloCarro(
                null,
                modeloCarroDTO.descricao(),
                modeloCarroDTO.categoria(),
                modeloCarroDTO.fabricante().toFabricante()
        ));
        URI uri = uriBuilder.path("/api/v1/modeloCarro/{id}").buildAndExpand(modeloCarro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ModeloCarroDto> update(@PathVariable("id") Long id, @RequestBody ModeloCarroDto modeloCarroDTO) {
        return modeloCarroRepository.findById(id)
                .map(modeloCarro -> {
                    modeloCarro.setDescricao(modeloCarroDTO.descricao());
                    modeloCarro.setCategoria(modeloCarroDTO.categoria());
                    modeloCarro.setFabricante(modeloCarroDTO.fabricante().toFabricante());
                    return ResponseEntity.ok(new ModeloCarroDto(modeloCarroRepository.save(modeloCarro)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ModeloCarroDto> delete(@PathVariable("id") Long id) {
        var modeloCarro = modeloCarroRepository.findById(id);
        if (modeloCarro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        modeloCarroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
