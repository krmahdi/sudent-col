package com.pfa.colstudent.repository;

import com.pfa.colstudent.model.Annonce;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    //Annonce getAnnonceByAltitudeAndLongitude = new Annonce()0;

}
