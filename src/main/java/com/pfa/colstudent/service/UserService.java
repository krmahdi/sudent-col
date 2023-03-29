package com.pfa.colstudent.service;

import com.pfa.colstudent.model.User;
import com.pfa.colstudent.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserService {
   /* @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public void saveUser(User user1) {
        User user = new User();
        user.setNom(user1.getNom()) ;user.setPrenom(user1.getPrenom()) ;
        user.setEmail(user1.getEmail());
        user.setNumTel( user1.getNumTel() );
        user.setAdmin( user1.isAdmin() );
        user.setEcole( user1.getEcole() );
        // encrypt the password using spring security
        user.setMotDePasse(passwordEncoder.encode(user1.getMotDePasse()));


        userRepository.save(user);
    }
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new EntityNotFoundException("L'User avec l'id " + id + " n'existe pas");
        }
    }

   /* public User saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }*/

   /* public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("L'User avec l'id " + id + " n'existe pas");
        }
    }*/
}
