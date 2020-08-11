/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.service;

import com.adap.api.entity.UserEntity;
import com.adap.api.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfre
 */
@Service
public class JwtLoginService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
        
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(userName);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN")); // los roles se configurara al final 
        System.out.println("ver por que se eecuta 2 veces ---A");
        System.out.println(userEntity.getPassword());
        System.out.println("ver por que se eecuta 2 veces ---B");
        UserDetails userDetails = new User(userEntity.getName(),userEntity.getPassword(),roles );
        return userDetails;
    }
    
    
    
    
    
}
