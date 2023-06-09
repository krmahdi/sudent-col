package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Annonce;
import com.pfa.colstudent.model.AnnonceSearchDao;
import com.pfa.colstudent.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/v1/annonce")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private AnnonceSearchDao annonceSearchDao;

    @PostMapping("/create")
    public ResponseEntity<Annonce> create(@RequestBody Annonce annonce) {
        Annonce createdAnnonce = annonceService.save(annonce);
        return new ResponseEntity<>(createdAnnonce, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity <List<Annonce>> search(@RequestParam("q") String query) {
        List<Annonce> annonces= annonceService.search(query);
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public List<Annonce> filter(Annonce annonce) {
        return annonceSearchDao.findAllByCriteria(annonce);
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

    @GetMapping("")
    public ResponseEntity<List<Annonce>> findAll() {
        List<Annonce> annonces = annonceService.findAll();
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Annonce> optionalAnnonce = annonceService.findById(id);
        if (optionalAnnonce.isPresent()) {
            annonceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }}