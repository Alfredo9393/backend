/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.controller;

import com.adap.api.config.JwtTokenUtil;
import com.adap.api.model.JwtLoginModel;
import com.adap.api.service.JwtLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author alfre
 */

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class JwtLoginConroller {
    
    
    @Autowired
    private JwtLoginService jwtLoginService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public JwtLoginModel createAuthenticationToken(@RequestBody JwtLoginModel jwtLoginModel) throws Exception {
        authenticate(jwtLoginModel.getUsername(), jwtLoginModel.getPassword());
        final UserDetails userDetails = jwtLoginService.loadUserByUsername(jwtLoginModel.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        jwtLoginModel.setJwttoken(token);        
        jwtLoginModel.setPassword(null);
        return jwtLoginModel;
    }
        
        
    private void authenticate(String username, String password) throws Exception {
        try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
        

     
 
}
