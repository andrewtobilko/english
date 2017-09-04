package com.tobilko.english.configuration.jwt.filter;

import com.tobilko.english.configuration.jwt.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);

        AuthenticationContextChanger.setAuthenticationToContext(authentication);
        filterChain.doFilter(request, response);
        AuthenticationContextChanger.removeCurrentAuthenticationFromContext();
    }

    private static class AuthenticationContextChanger {

        private static void setAuthenticationToContext(Authentication authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        private static void removeCurrentAuthenticationFromContext() {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

    }

}
