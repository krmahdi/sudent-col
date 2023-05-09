package com.pfa.colstudent.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @Column(name="transport")
    @Enumerated(EnumType.STRING)
    private Transport transport;
    @Column(name = "date")
    private Date date;
    @Column(name = "date de disponibilité")
    private Date date_dispo;
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
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "annonce")
    private List<Photo> photos;

    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Signalement> signalements;

}