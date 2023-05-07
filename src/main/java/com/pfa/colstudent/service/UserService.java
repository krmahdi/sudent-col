package com.pfa.colstudent.service;

import com.pfa.colstudent.model.Ecole;
import com.pfa.colstudent.model.User;
import com.pfa.colstudent.repository.EcoleRepository;
import com.pfa.colstudent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private  EcoleService ecoleService;
    private Ecole ecole;
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public User saveUser(User user) {

        return userRepo.save(user);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }


}
