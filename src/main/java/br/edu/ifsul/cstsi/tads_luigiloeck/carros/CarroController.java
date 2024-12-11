package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carro")
public class CarroController {
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<CarroDto>> findAll() {
        return ResponseEntity.ok(carroRepository.findAll().stream().map(CarroDto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<CarroDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(carroRepository.findById(id).map(CarroDto::new));
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<List<CarroDto>> findByPlaca(@PathVariable("placa") String placa) {
        List<Carro> carros = carroRepository.findByPlaca(placa);
        if (carros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carros.stream().map(CarroDto::new).toList());
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody CarroDto carroDTO, UriComponentsBuilder uriBuilder) {
        var carro = carroRepository.save(carroDTO.toCarro());
        URI uri = uriBuilder.path("/api/v1/carro/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CarroDto> update(@PathVariable("id") Long id, @RequestBody CarroDto carroDTO) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setPlaca(carroDTO.placa());
                    carro.setChassi(carroDTO.chassi());
                    carro.setCor(carroDTO.cor());
                    carro.setValorDiaria(carroDTO.valorDiaria());
                    return ResponseEntity.ok(new CarroDto(carroRepository.save(carro)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CarroDto> delete(@PathVariable("id") Long id) {
        var carro = carroRepository.findById(id);
        if (carro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}