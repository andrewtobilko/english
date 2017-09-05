package com.tobilko.english.configuration.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobilko.english.account.model.information.model.AuthorisationAccountInformation;
import com.tobilko.english.configuration.jwt.TokenAuthenticationService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper;

    public JWTLoginFilter(String mappingURL) {
        super(new AntPathRequestMatcher(mappingURL));
        objectMapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException, IOException, ServletException {

        final AuthorisationAccountInformation information = objectMapper.readValue(
                request.getInputStream(),
                AuthorisationAccountInformation.class
        );

        return getAuthenticationManager()
                .authenticate(obtainTokenFromAuthorisationInformation(information));
    }

    private UsernamePasswordAuthenticationToken obtainTokenFromAuthorisationInformation(AuthorisationAccountInformation information) {
        return new UsernamePasswordAuthenticationToken(
                information.getEmail(),
                information.getPassword(),
                Collections.emptyList()
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authentication
    ) throws IOException, ServletException {
        TokenAuthenticationService.addAuthenticationHeaderToResponse(response, authentication.getName()); // todo
    }

}