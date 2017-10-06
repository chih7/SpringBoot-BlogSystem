package com.mijack.sbbs.config;

import com.mijack.sbbs.auth.filter.RestfulApiAuthenticationProcessingFilter;
import com.mijack.sbbs.auth.provider.RestfulApiAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    RestfulApiAuthenticationProvider restfulApiAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/login.html", "/register.html", "/search.html").permitAll()
                .antMatchers("/api/**").permitAll()
        ;
        //api接口不做csrf处理
        http.csrf().ignoringAntMatchers("/api/**");
        http.addFilterBefore(restfulApiAuthenticationProcessingFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(restfulApiAuthenticationProvider);
    }

    RestfulApiAuthenticationProcessingFilter restfulApiAuthenticationProcessingFilter(AuthenticationManager authenticationManager) {
        RestfulApiAuthenticationProcessingFilter filter = new RestfulApiAuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

}
