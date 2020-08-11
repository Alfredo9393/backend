/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.model;

import java.io.Serializable;

/**
 *
 * @author alfre
 */
public class JwtLoginModel implements Serializable  {
    	private static final long serialVersionUID = 5926468583005150707L;
    
	private String username;
	private String password;
        private String jwttoken;
          
	//need default constructor for JSON Parsing
	public JwtLoginModel()
	{
		
	}
        
	public JwtLoginModel(String username, String password) {
            this.setUsername(username);
            this.setPassword(password);
	}
	public String getUsername() {
            return this.username;
	}
	public void setUsername(String username) {
            this.username = username;
	}
	public String getPassword() {
            return this.password;
	}
	public void setPassword(String password) {
            this.password = password;
	}

        public String getJwttoken() {
            return jwttoken;
        }

        public void setJwttoken(String jwttoken) {
            this.jwttoken = jwttoken;
        }
        
}
