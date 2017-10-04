package com.mijack.sbbs.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/login.html", "/register.html", "/search.html").permitAll()

        ;
    }

//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/js/**", "/css/**", "/fonts/**", "/**/favicon.ico").permitAll()
//                .antMatchers("/login.html", "/register.html", "/search.html").permitAll()
//                .antMatchers("/api/**").permitAll()
//                .antMatchers("/manager/*").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                .rememberMe().key("remember-me")
//                .rememberMeParameter("remember-me")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//        ;
//        http.csrf().ignoringAntMatchers("/api/**")
//                .ignoringAntMatchers("/file/**")
//                .ignoringAntMatchers("/gridfs.html")
//                .ignoringAntMatchers("/files/**")
//                .ignoringAntMatchers("/login")
//                .ignoringAntMatchers("/fileCenter/**");
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

}
