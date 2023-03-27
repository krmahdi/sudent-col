package com.pfa.colstudent.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Ecole")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ecole")
    private Long idEcole;
    @Column(name="nom_ecole")
    private String nomEcole;
    @Column(name="Adresse_ecole")
    private String adresseEcole;
    @Column(name="Code_Postal")
    private long codePostal;
    @Column(name="Ville")
    private String ville;
    @OneToMany(mappedBy = "ecole")
    private List<User> user;
}
