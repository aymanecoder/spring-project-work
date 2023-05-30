package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "appliances")
public class Apliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String dbid;
    private String reference;
    @Column(name = "disponibilite", nullable = false)
    private boolean disponibilite;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;


}
