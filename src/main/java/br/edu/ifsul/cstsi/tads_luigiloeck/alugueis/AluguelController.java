package br.edu.ifsul.cstsi.tads_luigiloeck.alugueis;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/aluguel")
public class AluguelController {
    private final AluguelRepository aluguelRepository;

    public AluguelController(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<AluguelDto>> findAll() {
        return ResponseEntity.ok(aluguelRepository.findAll().stream().map(AluguelDto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<AluguelDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(aluguelRepository.findById(id).map(AluguelDto::new));
    }

    @GetMapping("/protecaoTerceiro/{protecaoTerceiro}")
    public ResponseEntity<List<AluguelDto>> findByProtecaoTerceiro(@PathVariable("protecaoTerceiro") Boolean protecaoTerceiro) {
        List<Aluguel> alugueis = aluguelRepository.findByProtecaoTerceiro(protecaoTerceiro);
        if (alugueis.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alugueis.stream().map(AluguelDto::new).toList());
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody AluguelDto aluguelDTO, UriComponentsBuilder uriBuilder) {
        var aluguel = aluguelRepository.save(aluguelDTO.toAluguel());
        URI uri = uriBuilder.path("/api/v1/aluguel/{id}").buildAndExpand(aluguel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AluguelDto> update(@PathVariable("id") Long id, @RequestBody AluguelDto aluguelDTO) {
        return aluguelRepository.findById(id)
                .map(aluguel -> {
                    aluguel.setDataPedido(aluguelDTO.dataPedido());
                    aluguel.setDataEntrega(aluguelDTO.dataEntrega());
                    aluguel.setDataDevolucao(aluguelDTO.dataDevolucao());
                    aluguel.setValorTotal(aluguelDTO.valorTotal());
                    aluguel.setValorFranquia(aluguelDTO.valorFranquia());
                    aluguel.setProtecaoTerceiro(aluguelDTO.protecaoTerceiro());
                    aluguel.setProtecaoCausasNaturais(aluguelDTO.protecaoCausasNaturais());
                    aluguel.setProtecaoRoubo(aluguelDTO.protecaoRoubo());
                    return ResponseEntity.ok(new AluguelDto(aluguelRepository.save(aluguel)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AluguelDto> delete(@PathVariable("id") Long id) {
        var aluguel = aluguelRepository.findById(id);
        if (aluguel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        aluguelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}