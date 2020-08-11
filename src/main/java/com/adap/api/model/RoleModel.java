/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.model;

/**
 *
 * @author alfre
 */
public class RoleModel {

    public RoleModel() {}
    
    
    
    private Integer idRole;
    private String name;
    
    public Integer getIdRole(){
        return idRole;
    }
    
    public void setIdRole(Integer idRole){
        this.idRole = idRole;
    }
    
    public String getName(){
        return name;
    }
       
    public void setName(String name){
        this.name = name;
    }
    
}
