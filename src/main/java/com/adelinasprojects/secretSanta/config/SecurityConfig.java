package com.adelinasprojects.secretSanta.config;

import com.adelinasprojects.secretSanta.entities.User;
import com.adelinasprojects.secretSanta.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
                    .antMatchers("/api/v1/signup").permitAll()
                    .anyRequest().permitAll();
//                    .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .usernameParameter("email")
//                    .permitAll();
       http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {
        webSecurity
                .ignoring()
                // All of Spring Security will ignore the requests
                .antMatchers("/error/**");
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findUserByEmail(email);
//        if(user.isPresent()){
//            return (UserDetails) user.get();
//        }else{
//            throw new UsernameNotFoundException("Not found!");
//        }
//
//    }


//    @Bean
//    @Override
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
