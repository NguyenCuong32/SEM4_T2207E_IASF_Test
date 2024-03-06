package com.example.prac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class SercurityConfiguration {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id,password,is_active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configuration -> {
            configuration
//                    .requestMatchers("/pricing/**")
//                    .hasRole("ADMIN,OPERATOR")
                    .anyRequest()

                    .authenticated();
        }).formLogin(
                form -> form.loginPage("/loginPage")
                        .defaultSuccessUrl("/",true)
                        .loginProcessingUrl("/authenticateUser").permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/exception/access-denied")
        );
        return httpSecurity.build();
    }

}
