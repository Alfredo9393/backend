/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.controller;

import com.adap.api.entity.UserEntity;
import com.adap.api.model.UserModel;
import com.adap.api.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfre
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUser",method=RequestMethod.GET)
    public List<UserModel> getUser(){
        System.out.println("UserController: getUser ");        
        return userService.getUser();
    }
  
    @RequestMapping(value="/saveUser",method=RequestMethod.POST)
    public Boolean saveUser(@RequestBody UserEntity userEntity){
        System.out.println("UserController: saveUser ");        
        BCryptPasswordEncoder  PasswordEncoder = new BCryptPasswordEncoder ();
        userEntity.setPassword(PasswordEncoder.encode(userEntity.getPassword()));
        return userService.saveUser(userEntity);
    }
   
    
}
