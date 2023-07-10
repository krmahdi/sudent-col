package com.pfa.colstudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int idUser;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="email")
    private String email;
    @Column(name="numTel")
    private String numTel;

    @Column(name="motDePasse")
    private String password;
    @Column(name = "role")

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_ecole")
    private Ecole ecole;
    /*
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
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
