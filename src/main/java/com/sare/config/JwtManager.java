package com.sare.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class JwtManager {

    @Value("${my-jwt.secret-key}")
    private String secretKey;
    private final String issuer = "SareSahin";
    private final Long expirationDate = 1000L * 60 * 60 * 5;


    public String createToken(Long hastaId) {
        String token;
        Long now = System.currentTimeMillis();
        Date issuerAt = new Date(now);
        Date expiration = new Date(now + expirationDate);
        Algorithm algorithm = Algorithm.HMAC512(secretKey);
        token = JWT.create()
                .withAudience()
                .withIssuer(issuer)
                .withIssuedAt(issuerAt)
                .withExpiresAt(expiration)
                .withClaim("hastaId", hastaId)
                .withClaim("HastaneOtomasyon", "Yeni bir uygulama yazdım.")
                .withClaim("log", "şuan saat tam olarak " + (new Date()))
                .sign(algorithm);
        return token;
    }


    public Optional<Long> validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier =  JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(Objects.isNull(decodedJWT))
                return Optional.empty();
            Long hastaId = decodedJWT.getClaim("hastaId").asLong();
            return Optional.of(hastaId);
        }catch (Exception exception){
            return Optional.empty();
        }
    }


}