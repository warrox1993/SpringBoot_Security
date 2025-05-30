package com.example.Decouverte_Spring_boot.dal.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name="user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private Integer age;

    /**
     * Le constructeur vide est le constructeur par défaut REQUIS par JPA.
     */
    public User() {}

    /**
     * Notre constructeur pratique
     */
    public User(String nom, String email, Integer age) {
        this.nom = nom;
        this.email = email;
        this.age = age;
    }
}