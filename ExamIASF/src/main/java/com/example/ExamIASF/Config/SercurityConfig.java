package com.example.ExamIASF.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SercurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery
                ("select user_id,password,is_active " +
                        "from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery
                ("select user_id,role from roles where user_id=?");
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsercurity) throws Exception{
        httpsercurity.authorizeHttpRequests(configuration->{
            configuration
//                    .requestMatchers("news/**")
//                    .hasRole("ADMIN,OPERATOR")
                    //kiểu cũ cho việc phân quyền ko db
                    .anyRequest()
                    .authenticated();
        }).formLogin( form->form.loginPage("/loginlogout")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/dashboard",true)
                .permitAll() );
        // "/login" ở đây là endpoint ở request mapping , ko phải html
        return httpsercurity.build();
    }
}
