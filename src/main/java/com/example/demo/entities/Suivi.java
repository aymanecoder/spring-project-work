package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Suivi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean  offreCommercial;
    private float montant;
    private String compteRendu;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typePrestation_id")
    private TypePrestation typePrestation;

    @OneToOne
    private Pov pov;
}
