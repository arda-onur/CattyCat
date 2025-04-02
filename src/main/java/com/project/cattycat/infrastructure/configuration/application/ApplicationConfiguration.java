package com.project.cattycat.infrastructure.configuration.application;

import com.project.cattycat.infrastructure.persistence.Entity.User.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration implements WebMvcConfigurer {

    private final UserRepositoryImpl userRepository;
    private final EncoderConfiguration pwdEncoderConfiguration;

    @Bean
    public UserDetailsService userDetailsService() {
        return  email -> (UserDetails) userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public AuthenticationProvider authenticationcationProvider() {
        DaoAuthenticationProvider daoAuthentiProvider = new DaoAuthenticationProvider();
        daoAuthentiProvider.setUserDetailsService(userDetailsService());
        daoAuthentiProvider.setPasswordEncoder(pwdEncoderConfiguration.bCryptPasswordEncoder());
        return daoAuthentiProvider;
    }

}
