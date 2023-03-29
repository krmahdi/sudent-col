package com.pfa.colstudent.service;
import com.pfa.colstudent.model.Annonce;
import com.pfa.colstudent.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    public Annonce save(Annonce annonce) {
        Annonce save = annonceRepository.save( annonce );
        return save;
    }

    public Optional<Annonce> findById(Long id) {
        return annonceRepository.findById(id);
    }

    public List<Annonce> findAll() {
        return annonceRepository.findAll();
    }

    public void deleteById(Long id) {
        annonceRepository.deleteById(id);
    }
}