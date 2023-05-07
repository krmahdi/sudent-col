package com.pfa.colstudent.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "signalement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Signalement {
    /*@Id
    @ManyToOne
    @JoinColumn(name = "id_annonce")
    private Annonce annonce;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;*/
    @EmbeddedId
    @Column(name="signal_id")
    private SignalementId id=new SignalementId();

    @ManyToOne
    @MapsId("annonceId") // maps table1PK attribute of embedded id
    @JoinColumn(name = "annonce_id")
    @JsonIgnore

    private Annonce annonce;

    @ManyToOne
    @MapsId("userId") // maps table2PK attribute of embedded id
    @JoinColumn(name = "user_id")
    @JsonIgnore

    User user;
}
