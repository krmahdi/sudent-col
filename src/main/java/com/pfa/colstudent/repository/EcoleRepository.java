package com.pfa.colstudent.repository;

import com.pfa.colstudent.model.Ecole;
import com.pfa.colstudent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Long> {
    Optional<Ecole> findEcoleByNomEcoleEquals(String nom);

}

