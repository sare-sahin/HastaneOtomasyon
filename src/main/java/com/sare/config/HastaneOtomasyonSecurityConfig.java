package com.sare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class HastaneOtomasyonSecurityConfig {


    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req->
                req
                        .requestMatchers("/swagger-ui/**", "v3/api-docs/**", "/dev/v1/hasta/**")
                        .permitAll()                  //yukarıdaki adreslere izin verir.
                        .anyRequest().authenticated() //kalan tüm adreslere oturum açma zorunluluğu getirir.
        );
        http.csrf(AbstractHttpConfigurer::disable);   //csrf ile doğrulamayı kapatır.
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
