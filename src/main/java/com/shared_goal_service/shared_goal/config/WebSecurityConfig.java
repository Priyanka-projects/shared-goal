package com.shared_goal_service.shared_goal.config;


import com.shared_goal_service.shared_goal.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/view/**").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers("/new/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/edit/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/delete/**").hasAuthority("ADMIN")
                        .requestMatchers("/viewall/**").hasAuthority("ADMIN")
                        .requestMatchers("/user/addUser").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());;

        return http.build();
    }

}
