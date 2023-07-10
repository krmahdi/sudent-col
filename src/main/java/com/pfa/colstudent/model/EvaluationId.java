package com.pfa.colstudent.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class EvaluationId implements Serializable {
private Long annonceId;
private Long userId;

    public EvaluationId(Long annonceId, Long userId) {
    }
   /* @ManyToOne
    @JoinColumn(name = "id_annonce")
    private Annonce annonce;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // standard getters and setters*/
}
