/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.repository;
import com.adap.api.entity.UserEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfre
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable>{
   /*
   public abstract UserEntity findByEmail(String email); //regresa un objeto, ya que solo debe haber un email unico
    
   public abstract List<UserEntity> findByName(String name); //lista de nombres
    
   public abstract UserEntity findByIdUser(long idUser);
   */
    
   UserEntity findByName(String name);
            
}
