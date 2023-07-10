package com.pfa.colstudent.repository;

import com.pfa.colstudent.model.Evaluation;
import com.pfa.colstudent.model.EvaluationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, EvaluationId> {

//      List<Evaluation> findByAnnonceId(Long annonceId);
//
   Optional<Evaluation> findById(EvaluationId evaluationId);




}

