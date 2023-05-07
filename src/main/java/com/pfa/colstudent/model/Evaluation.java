package com.pfa.colstudent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="evaluation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evaluation {

@EmbeddedId
@Column(name="eval_id")
private EvaluationId id=new EvaluationId();
    @JsonIgnore
    @ManyToOne
    @MapsId("annonceId") // maps table1PK attribute of embedded id
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
    @JsonIgnore
    @ManyToOne
    @MapsId("userId") // maps table1PK attribute of embedded id
    @JoinColumn(name = "id_user")
    private User user;
    @Column(name="note")
    private Integer note;
    /*@ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_annonce", referencedColumnName = "id_annonce"),
            @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    })
    private Annonce annonce;*/
}