package com.mijack.sbbs.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/login.html", "/register.html", "/search.html").permitAll()
                .antMatchers("/api/**").permitAll()
        ;
        //api接口不做csrf处理
        http.csrf().ignoringAntMatchers("/api/**");
    }
}
