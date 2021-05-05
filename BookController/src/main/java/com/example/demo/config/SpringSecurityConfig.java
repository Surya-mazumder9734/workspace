package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/books/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
        http.headers().frameOptions().disable();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        //ok for demo
        User.UserBuilder users=User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
        return manager;

    }

}
