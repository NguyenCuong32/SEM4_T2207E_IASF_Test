package org.example.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id, password, is_active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                    authorize-> authorize
                    .requestMatchers("/about", "/privacy").hasAnyRole("ADMIN", "USER")
                    .anyRequest()
                    .authenticated())
                .formLogin(
                        form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/signin")
                        .defaultSuccessUrl("/default", true)
                        .permitAll()
                )
                .exceptionHandling(
                        configurer->configurer
                        .accessDeniedPage("/access-denied"))
                .logout(
                logout->logout
                        .logoutUrl("/logout")
                        .permitAll()
        );
        return httpSecurity.build();
    }
}
