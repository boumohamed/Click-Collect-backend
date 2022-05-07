package com.pfa.clickandcollect.security;

import com.pfa.clickandcollect.security.service.UserDeatilsServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
class SecurityConfig extends WebSecurityConfigurerAdapter {



    private UserDeatilsServiceImpl userDeatilsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDeatilsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/").permitAll();

        http.authorizeHttpRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeHttpRequests().antMatchers("/user/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/manager/**").hasAuthority("MANAGER");
        http.authorizeHttpRequests().anyRequest().authenticated();
    }


}
