package org.geon.journey.security.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    {
        log.info("security config");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*").hasRole("USER");
        http.formLogin()
                .loginPage("http://localhost:3000/login")
                .loginProcessingUrl("http://localhost:3000/login_proc")
                .defaultSuccessUrl("http://localhost:3000/");
        http.oauth2Login()
                .loginPage("http://localhost:3000/login")
                .defaultSuccessUrl("http://localhost:3000/");
        http.csrf().disable();
        http.oauth2Login();
    }

}
