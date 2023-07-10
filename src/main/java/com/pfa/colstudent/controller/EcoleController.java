package com.pfa.colstudent.controller;

import com.pfa.colstudent.model.Ecole;
import com.pfa.colstudent.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecoles")
public class EcoleController {

    @Autowired
    private EcoleService ecoleService;
    @GetMapping
    public List<Ecole> getAllEcoles() {
        return ecoleService.getAllEcoles();
    }

    @GetMapping("/{id}")
    public Ecole getEcoleById(@PathVariable Long id) {
        return ecoleService.getEcoleById(id);
    }

    @PostMapping("/post")
    public Ecole saveEcole(@RequestBody Ecole ecole) {
        return ecoleService.saveEcole(ecole);
    }

    @DeleteMapping("/{id}")
    public void deleteEcole(@PathVariable Long id) {
        ecoleService.deleteEcole(id);
    }
}
