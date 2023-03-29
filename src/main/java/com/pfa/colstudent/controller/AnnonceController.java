package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Annonce;
import com.pfa.colstudent.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping
    public ResponseEntity<Annonce> create(@RequestBody Annonce annonce) {
        Annonce createdAnnonce = annonceService.save(annonce);
        return new ResponseEntity<>(createdAnnonce, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annonce> findById(@PathVariable Long id) {
        Optional<Annonce> optionalAnnonce = annonceService.findById(id);
        if (optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            return new ResponseEntity<>(annonce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> findAll() {
        List<Annonce> annonces = annonceService.findAll();
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> update(@PathVariable Long id, @RequestBody Annonce annonce) {
        Optional<Annonce> optionalAnnonce = annonceService.findById(id);
        if (optionalAnnonce.isPresent()) {
            annonce.setIdAnnonce(id);
            Annonce updatedAnnonce = annonceService.save(annonce);
            return new ResponseEntity<>(updatedAnnonce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Annonce> optionalAnnonce = annonceService.findById(id);
        if (optionalAnnonce.isPresent()) {
            annonceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }}