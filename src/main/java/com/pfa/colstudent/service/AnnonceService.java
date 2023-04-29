package com.pfa.colstudent.service;
import com.pfa.colstudent.model.Annonce;
import com.pfa.colstudent.model.AnnonceSearchDao;
import com.pfa.colstudent.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;
@Autowired
private AnnonceSearchDao annonceSearchDao;
private Annonce annonce;
    public Annonce save(Annonce annonce) {
        Annonce save = annonceRepository.save( annonce );
        return save;
    }

    public List<Annonce> search(String query) {
        List<Annonce> annonces = annonceRepository.findAll();
        List<Annonce> result = new ArrayList<>();
        for (Annonce annonce : annonces) {
            if (annonce.getDescription().contains(query)
                    || annonce.getAdresse().contains(query)) {
                result.add(annonce);
            }
        }
        return result;
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
public List<Annonce> filtering(){
    return annonceSearchDao.findAllByCriteria(annonce);
}
}