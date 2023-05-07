package com.pfa.colstudent.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_photo")
private Long idPhoto;
    @Column(name="path_photo")
private String pathPhoto;
    @ManyToOne


    @JoinColumn(name = "id_annonce")
    @JsonIgnore

    private Annonce annonce;

    // getters and setters
}
