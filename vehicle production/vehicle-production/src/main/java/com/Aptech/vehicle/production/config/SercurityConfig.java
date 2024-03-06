package com.Aptech.vehicle.production.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SercurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select username,password,is_active from members where username=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select username,role from roles where username=?");
        return userDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER").build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("ADMIN").build();
//        return new  InMemoryUserDetailsManager(user,admin);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configuration -> {
            configuration
                    .anyRequest()
                    .authenticated();
        }).formLogin(
                form -> form.loginPage("/login")
                        .defaultSuccessUrl("/",true)
                        .loginProcessingUrl("/authenticateUser").permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/exception/access-denied")

        )
                .logout(config -> config
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );;
        return httpSecurity.build();
    }
}
