package com.utn.ejercicio1.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String calle;
    private int numero;

    @ManyToMany(mappedBy = "domicilios")
    @Builder.Default
    private Set<Persona> personas = new HashSet<>();
}