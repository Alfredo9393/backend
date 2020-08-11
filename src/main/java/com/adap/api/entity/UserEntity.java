/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alfre
 */
@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "[User]", schema = "dbo")
public class UserEntity implements Serializable {

    public UserEntity(){} //este constructor es lo que ocupara hibernate para acceder

    public UserEntity(Long idUser, String name, String email,String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }
 
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser")
    private Long idUser;

       
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Password")
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
