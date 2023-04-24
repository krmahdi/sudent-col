package com.pfa.colstudent.repository;

import com.pfa.colstudent.model.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Long> {

}

