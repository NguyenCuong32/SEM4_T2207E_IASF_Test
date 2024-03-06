package com.example.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authenticationProvider(authenticationProvider());
//
//        CookieClearingLogoutHandler cookies = new CookieClearingLogoutHandler("our-custom-cookie");
//
//        http.authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/users").authenticated()
//                        .requestMatchers("/account/*").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout
//                        .logoutSuccessUrl("/")
//                )
//        ;
//
//        return http.build();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // The builder will ensure the passwords are encoded before saving in memory
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        UserDetails user = users
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        UserDetails admin = users
//                .username("admin")
//                .password("password")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/users").authenticated()
//                        .requestMatchers("/product/create").hasAnyAuthority("USER", "ADMIN")
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
//
//        return http.build();
//    }
}
