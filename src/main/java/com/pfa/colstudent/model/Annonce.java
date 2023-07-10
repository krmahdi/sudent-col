package com.pfa.colstudent.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="annonce")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce")
    private Long idAnnonce;
    @Column(name = "description")
    private String description;
    @Column(name = "superficie")
    private float superficie;
    @Column(name = "loyer")
    private double loyer;
    @Column(name = "nbChambre")
    private int nbChambre;
    @Column(name = "nbPersonne")
    private int nbPersonne;
    @Column(name = "Animeaux")
    private boolean animeaux;
    @Column(name = "Fumeurs")
    private boolean fumeurs;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Caution")
    private double caution;
    @Column(name = "supprimé")
    private boolean supprimee;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "altitude")
    private double altitude;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @JsonManagedReference
    @OneToMany(mappedBy = "annonce")
    private List<Photo> photos;
    @JsonManagedReference
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    @JsonManagedReference
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Signalement> signalements;

}
