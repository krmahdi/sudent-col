package com.pfa.colstudent.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class SignalementId implements Serializable {

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annonce")
    private Annonce annonce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
*/
   private Long annonceId;
    private Long userId;
    // standard getters and setters
}
