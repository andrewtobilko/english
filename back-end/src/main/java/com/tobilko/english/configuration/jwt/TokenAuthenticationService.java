package com.tobilko.english.configuration.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
public class TokenAuthenticationService {

    // TODO: 9/3/17 move to the prop file
    private static final long EXPIRATION_TIME = 864_000_000;
    private static final String SECRET_KEY = "ThisIsASecret";
    private static final String BEARER_TOKEN_PREFIX = "Bearer";
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";

    @SneakyThrows
    public static void addAuthenticationHeaderToResponse(HttpServletResponse response, String subject) {
        new ObjectMapper().writeValue(response.getWriter(), generateTokenValueBySubject(subject));
    }

    private static String generateTokenValueBySubject(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, getSecretKeyBytes())
                .compact();
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    }

    private static byte[] getSecretKeyBytes() {
        return SECRET_KEY.getBytes();
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER_KEY);

        if (token == null) {
            return null;
        }

        String principal = parsePrincipalFromTokenValue(token);

        if (principal == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(principal, null, Collections.emptyList());
    }

    private static String parsePrincipalFromTokenValue(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSecretKeyBytes())
                .parseClaimsJws(token.replace(BEARER_TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
    }

}