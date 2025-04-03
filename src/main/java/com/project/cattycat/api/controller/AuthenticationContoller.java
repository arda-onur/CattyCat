package com.project.cattycat.api.controller;

import com.project.cattycat.application.authentication.AuthenticationService;
import com.project.cattycat.application.dto.RegisterRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationContoller {

    private final AuthenticationService authenticationService;
     @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO){
        return ResponseEntity.ok().body(authenticationService.register(registerRequestDTO));
    }
}















