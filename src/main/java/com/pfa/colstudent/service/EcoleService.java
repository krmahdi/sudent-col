package com.pfa.colstudent.service;

import com.pfa.colstudent.model.Ecole;
import com.pfa.colstudent.repository.EcoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoleService {

    @Autowired
    private EcoleRepository ecoleRepository;

    public List<Ecole> getAllEcoles() {
        return ecoleRepository.findAll();
    }

    public Ecole getEcoleById(Long id) {
        return ecoleRepository.findById(id).orElse(null);
    }

    public Ecole saveEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    public void deleteEcole(Long id) {
        ecoleRepository.deleteById(id);
    }
}
