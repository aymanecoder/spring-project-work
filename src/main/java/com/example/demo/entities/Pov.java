package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "povs")
public class Pov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String description;
    private String compteManager;
    private String ingenieurCybersecurite;
    private String analystCybersecurite;
    private String libellePov;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Client> clients;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Apliance> appliances;

}
