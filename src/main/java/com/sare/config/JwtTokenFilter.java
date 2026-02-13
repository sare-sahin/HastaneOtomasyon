package com.sare.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class JwtTokenFilter extends OncePerRequestFilter {

    /**
     * Sunucuya gelen tüm istekler (istisnasız) ilk olarak buraya gelir.
     *
     *                Sunucuya gelen isteğin yapısı:
     *      * - URL    => http://localhost:9090 ...
     *      * - HEADER => Content-Type: application/json, Authorization: Bearer [TOKEN]
     *      * - BODY   => send data, JSON, FILE ..
     *      * - METHOD => POST, GET, HEADER, DELETE ...
     *
     *
     * Header içerisinde yer alan token bilgisi kontrole tabi tutulur.
     *
     *    * 1. İlgili hastanın id si ile doğrulama yapılıp, bir kimlik kartı oluşturulur.
     *    * 2. Spring in oluşan kimlik kartını tanıyacağı bir token oluşturulur. (AuthenticationToken)
     *    * 3. Geçerli oturum içerisine bu token enjekte edilir.                 (Holder içerisine ekleme)
     *
     *
     */

    @Autowired
    private JwtManager jwtManager;
    @Autowired
    private JwtUserDetails jwtUserDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain) throws ServletException, IOException {


        final String requestHeaderAuthorization = request.getHeader("Authorization");                     // reguest içinden header, header içinden authorization bilgisi alınır.
        if(Objects.nonNull(requestHeaderAuthorization) && requestHeaderAuthorization.startsWith("Bearer ")){ // authorization null olmamalı ve Bearer ile başlamalı.
            String token = requestHeaderAuthorization.substring(7);                                // artık gelen istekteki token bilgisine ulaşıldı.
            Optional<Long> hastaId = jwtManager.validateToken(token);                                        // token bilgisi doğrulanmalı.
            if(hastaId.isPresent()){                                                                         // token geçerli ve bir id var olmalı.
                UserDetails userDetails = jwtUserDetails.loadUserById(hastaId.get());                        // JwtUserDetails sınıfını yazdık ve buraya dahil ettik.
                UsernamePasswordAuthenticationToken springToken = new                                        // Spring in algıladığı token üretiyoruz.
                        UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(springToken);                           // Geçerli oturumun içine token'ı yerleştiriyoruz.
            }
        }
        filterChain.doFilter(request,response);



    }
}
