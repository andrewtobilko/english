package com.tobilko.english.configuration.web.resolver.account;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

/**
 * Created by Andrew Tobilko on 9/3/17.
 */
@Component
@RequiredArgsConstructor
public class CurrentAccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final AccountRepository repository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Objects.equals(Account.class, parameter.getParameterType()) &&
                parameter.hasParameterAnnotation(CurrentAccount.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer container,
            NativeWebRequest request,
            WebDataBinderFactory factory
    ) throws Exception {
        Authentication authentication = fetchCurrentAuthentication();

        if (authentication == null) {
            throw new IllegalArgumentException("this request doesn't have a bearer token"); // TODO: 9/6/17
        }

        return repository
                .findOneByAuthorisationInformationEmail(fetchPrincipalUsernameFromFromAuthentication(authentication))
                .orElseThrow(() -> new IllegalArgumentException("auth is wrong; validate token again")); // // TODO: 9/6/17
    }

    private Authentication fetchCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private String fetchPrincipalUsernameFromFromAuthentication(Authentication authentication) {
        return authentication.getPrincipal().toString();
    }

}

