 package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Evaluation;
import com.pfa.colstudent.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class EvaluationController {

    private EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

//    @GetMapping("/evaluations/{annonceId}")
//    public List<Evaluation> getEvaluationsByAnnonceId(@PathVariable Long annonceId) {
//        return evaluationService.getEvaluationsByAnnonceId(annonceId);
//    }

    @PostMapping("/evaluations")
    public ResponseEntity<String> addEvaluation(@RequestBody Evaluation evaluation) {
        Optional<Evaluation> existingEvaluation = evaluationService.getEvaluationByAnnonceIdAndUserId(
                evaluation.getId());
        if (existingEvaluation.isPresent()) {
            return ResponseEntity.badRequest().body("Evaluation already exists for this user and annonce");
        }

        evaluationService.saveEvaluation(evaluation);
        return ResponseEntity.ok("Evaluation added successfully");
    }

    /* @DeleteMapping("/evaluations/{id}")
    public ResponseEntity<String> deleteEvaluation(@PathVariable(value = "id") Long evaluationId) {
        Evaluation evaluation = evaluationService.getEvaluationById(evaluationId)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluation", "id", evaluationId));

        evaluationService.deleteEvaluation(evaluation);
        return ResponseEntity.ok("Evaluation deleted successfully");
    }*/

}
