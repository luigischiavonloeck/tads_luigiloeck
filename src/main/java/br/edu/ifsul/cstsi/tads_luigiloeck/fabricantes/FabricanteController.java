package br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabricante")
public class FabricanteController {
    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll() {
        return ResponseEntity.ok(fabricanteRepository.findAll());
    }


}
