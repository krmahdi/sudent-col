package com.pfa.colstudent.controller;

import com.pfa.colstudent.service.UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pfa.colstudent.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


   /* @Autowired
    private UserService utilisateurService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user1,
                               BindingResult result,
                               Model model) {
        User existingUser = utilisateurService.findUserByEmail( user1.getEmail() );

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue( "email", null,
                    "There is already an account registered with the same email" );
        } if(result.hasErrors()){
            model.addAttribute("user", user1);
            return "/register";
        }
        System.out.println("Inside registration method...");

        utilisateurService.saveUser(user1);
        return "redirect:/register?success";
    }


        @GetMapping
    public List<User> getAllUtilisateurs() {
        return utilisateurService.getAllUsers();
    }
/*
    @GetMapping("/{id}")
    public User getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUserById(id);
    }

 /*   @PostMapping
    public User saveUtilisateur(@RequestBody User utilisateur) {
        return utilisateurService.saveUser(utilisateur);
    }
*/
    /*@PutMapping("/{id}")
    public User updateUtilisateur(@PathVariable Long id, @RequestBody User utilisateur) {
        if (!id.equals(utilisateur.getIdUser())) {
            throw new IllegalArgumentException("L'id dans l'URL ne correspond pas à l'id de l'utilisateur dans le corps de la requête");
        }
        return utilisateurService.saveUser(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUser(id);
    }*/
}

