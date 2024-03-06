package com.example.prac.config;

import com.example.prac.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/add-new").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                )
        ;

        return http.build();
    }

////    @Bean
////    public InMemoryUserDetailsManager userDetailsManager() {
////        UserDetails user = User.builder()
////                .username("user")
////                .password("{noop}123")
////                .roles("USER")
////                .build();
////
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("{noop}123")
////                .roles("ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(user, admin);
////    }
////
////
////    @Bean
////    public UserDetailsService userDetailsService() {
////        // The builder will ensure the passwords are encoded before saving in memory
////        User.UserBuilder users = User.withDefaultPasswordEncoder();
////        UserDetails user = users
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
////        UserDetails admin = users
////                .username("admin")
////                .password("password")
////                .roles("USER", "ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(user, admin);
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
//
//        return http.build();
//    }
}