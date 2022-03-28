package com.ragainfotech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("$2a$10$neShgfY722fdAkI8I5zxF.NENMmGjkqZTfpi9ZCqCgx3TbmgqDMUS")
                .roles("admin")
                .and()
                .withUser("user")
                .password("$2a$10$neShgfY722fdAkI8I5zxF.NENMmGjkqZTfpi9ZCqCgx3TbmgqDMUS")
                .roles("user");

//        System.out.println("Encoded Username:"+passwordEncoder.encode("root"));
//        System.out.println("Encoded password:"+passwordEncoder.encode("rootpassword"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello/Admin").hasRole("admin")
                .antMatchers("/hello").hasRole("user")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
}
