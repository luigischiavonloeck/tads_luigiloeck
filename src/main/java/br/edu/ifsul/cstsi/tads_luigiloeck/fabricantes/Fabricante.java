package br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Fabricante")
@Table(name = "fabricantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fabricante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
