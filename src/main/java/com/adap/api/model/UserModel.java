/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.model;

import com.adap.api.entity.UserEntity;

/**
 *
 * @author alfre
 */
public class UserModel {
    
    public UserModel(){}
    
    public UserModel(UserEntity userEntity) { //convierte en entidad a modelo
        this.idUser = userEntity.getIdUser();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.password =userEntity.getPassword();
    }

    public UserModel(Long idUser, String name, String email,String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password =password;
    }
    
    private Long idUser;
    private String name;
    private String email;
    private String password;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

