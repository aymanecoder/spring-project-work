package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypePrestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typePrestation_id")
    private Long id;
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "typePrestation",cascade = CascadeType.ALL)
    private List<Suivi> suivis;
}
