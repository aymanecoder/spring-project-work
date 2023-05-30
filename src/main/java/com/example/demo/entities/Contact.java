package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nom;
    private String Prenom;

    @Pattern(regexp = "^\\d{10}$", message = "Please enter a valid 10-digit phone number")
    private String Telephone;
    private String Fonction;

    @Email
    private String Email;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
