package org.example.baithith.Config;

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
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT user_id, password, is_active FROM members WHERE user_id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer->
                        configurer
                                .requestMatchers("/dashboard/**").hasAnyRole("ADMIN","USER")
                                .anyRequest().authenticated())
                .formLogin(
                        form->form
                                .loginPage("/login")
                                .loginProcessingUrl("/signin")

                                .permitAll()

                ).exceptionHandling(configurer->configurer.accessDeniedPage("/access-denied"))
                .logout(logout ->logout
                        .logoutUrl("/logout")
                        .deleteCookies()
                        .permitAll()
                );
        return httpSecurity.build();
    }
}
