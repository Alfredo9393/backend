/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.service;

import com.adap.api.entity.UserEntity;
import com.adap.api.model.UserModel;
import com.adap.api.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author alfre
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

     public Boolean saveUser(UserEntity userEntity) {
        try {
            userRepository.save(userEntity);
            return true;
        } catch (Exception e) {
             return false;
        }
    }   

    public List<UserModel> getUser(){
        List<UserModel> userModel = new ArrayList<>();
        List<UserEntity> userEntity = userRepository.findAll();
        for (UserEntity data : userEntity) { 
            userModel.add(new UserModel(data));//convierte entidad a modelo
        } 
        return userModel;
    }


    
    public Boolean updateUser(UserEntity user) {
        try {
             userRepository.save(user);
             return true;
        } catch (Exception e) {
             return false;
        }
    }
    
//    public boolean delete(long idUser){
//        try {
//            UserEntity userEntity = userRepository.findByIdUser(idUser);
//            userRepository.delete(userEntity);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//        
//    }
//        


 
}
