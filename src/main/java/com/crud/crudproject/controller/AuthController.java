package com.crud.crudproject.controller;

import com.crud.crudproject.dto.LoginDto;
import com.crud.crudproject.dto.SignUpDto;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.model.Role;
import com.crud.crudproject.repositories.LeadRepository;
import com.crud.crudproject.repositories.RoleRepository;

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

import java.util.Collections;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(leadRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(leadRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        // create user object
        Lead lead = new Lead();
        lead.setName(signUpDto.getName());
        lead.setUsername(signUpDto.getUsername());
        lead.setEmail(signUpDto.getEmail());
        lead.setConfirmPassword(signUpDto.getConfirmPassword());
        lead.setCountry(signUpDto.getCountry());       
        lead.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
       
         
        Role roles = roleRepository.findByName(signUpDto.getRolename()).get();
        lead.setRoles(Collections.singleton(roles));
        leadRepository.save(lead);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    }