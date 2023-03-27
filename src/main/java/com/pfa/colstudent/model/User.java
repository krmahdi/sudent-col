package com.pfa.colstudent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Entity
    @Table(name="user")
@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Data

    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_user")
        private Long idUser;
        @Column(name="nom")
        private String nom;
        @Column(name="prenom")
        private String prenom;
        @Column(name="email")
        private String email;
        @Column(name="numTel")
        private String numTel;
        @Column(name="motDePasse")
        private String motDePasse;

    @Column(name = "is_admin")
    private boolean isAdmin;
        @ManyToOne
        @JoinColumn(name = "id_ecole")
        private Ecole ecole;
          //constructeurs, getters, setters, etc.
    }

