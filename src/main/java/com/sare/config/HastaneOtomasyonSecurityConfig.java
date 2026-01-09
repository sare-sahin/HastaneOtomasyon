package com.sare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HastaneOtomasyonSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req->
                req
                        .requestMatchers("/swagger-ui/**", "v3/api-docs/**", "/dev/v1/kullanici/**")
                        .permitAll()                  //yukarıdaki adreslere izin verir.
                        .anyRequest().authenticated() //kalan tüm adreslere oturum açma zorunluluğu getirir.
        );
        http.csrf(AbstractHttpConfigurer::disable);   //csrf ile doğrulamayı kapatır.
        return http.build();
    }

}
