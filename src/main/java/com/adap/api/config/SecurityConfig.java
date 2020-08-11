/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adap.api.config;

import com.adap.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/**
 *
 * @author alfre
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;
        
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    
    @Autowired
    private BCryptPasswordEncoder bcrypt;
        
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            return bCryptPasswordEncoder;
    }  	
    
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
            // configure AuthenticationManager so that it knows from where to load
            // user for matching credentials
            // Use BCryptPasswordEncoder
            auth.userDetailsService(jwtUserDetailsService).passwordEncoder(bcrypt);
    }

    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
            // We don't need CSRF for this example
            httpSecurity.csrf().disable()
                            // dont authenticate this particular request
                            .authorizeRequests().antMatchers("/api/login/authenticate").permitAll().
                            // all other requests need to be authenticated
                            anyRequest().authenticated().and().
                            // make sure we use stateless session; session won't be used to
                            // store user's state.
                            exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            // Add a filter to validate the tokens with every request
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//        .authorizeRequests()    
//        .antMatchers("/api/user/login").permitAll()
//        .antMatchers("/api/user/getUser").permitAll()
//        .anyRequest()          
//        .authenticated();
////        .and()
////        .httpBasic();
//    }
    

    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("adap")
//                .password("{noop}123")
//                .roles("USER")
//                .and()
//                .withUser("adap 2")
//                .password("{noop}123")
//                .roles("MANAGER");
//    }
    
//   @Override
//    protected void configure(HttpSecurity http) throws Exception {     
//        http
//        .csrf().disable()
//        .authorizeRequests() 
////        .antMatchers("/api/user/getUser").permitAll()
////        .antMatchers("/api/user/saveUser").permitAll()        
////        .antMatchers("/api/user/login").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .httpBasic()
//        .and()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//    }
//        
}
