package com.crud.crudproject.controller;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudproject.dto.JWTAuthResponse;
import com.crud.crudproject.dto.JsonViews;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.dto.LoginDto;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.model.Role;
import com.crud.crudproject.repository.LeadRepository;
import com.crud.crudproject.repository.RoleRepository;
import com.crud.crudproject.security.JwtTokenProvider;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LeadRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @JsonView(JsonViews.Lead.SignUp.class)LeadDto leadDto){

        // add check for username exists in a DB
        if(userRepository.existsByUsername(leadDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(leadDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Lead lead = new Lead();
        lead.setName(leadDto.getName());
        lead.setUsername(leadDto.getUsername());
        lead.setEmail(leadDto.getEmail());
        lead.setPassword(passwordEncoder.encode(leadDto.getPassword()));

        Role roles = roleRepository.findByName(leadDto.getRoles()).get();
        lead.setRoles(Collections.singleton(roles));

        userRepository.save(lead);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
