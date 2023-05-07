package com.pfa.colstudent.auth;

import com.pfa.colstudent.model.User;
import com.pfa.colstudent.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request
    ) {
        return service.register(request);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
