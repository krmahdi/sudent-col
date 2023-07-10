package com.pfa.colstudent.service;

import com.pfa.colstudent.model.Evaluation;
import com.pfa.colstudent.model.EvaluationId;
import com.pfa.colstudent.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EvaluationService {

    private EvaluationRepository evaluationRepository;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> getEvaluations() {
        return evaluationRepository.findAll( );
    }

    public Optional<Evaluation> getEvaluationByAnnonceIdAndUserId(EvaluationId evaluationId) {
        return evaluationRepository.findById(evaluationId);
    }

    public void saveEvaluation(Evaluation evaluation) {
        evaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(Evaluation evaluation) {
        evaluationRepository.delete(evaluation);
    }

}