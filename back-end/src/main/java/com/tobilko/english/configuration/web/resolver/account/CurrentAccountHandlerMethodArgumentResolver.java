package com.tobilko.english.configuration.web.resolver.account;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

import static com.tobilko.english.util.AnnotationUtils.findMethodAnnotation;

/**
 * Created by Andrew Tobilko on 9/3/17.
 */
@Component
@RequiredArgsConstructor
public class CurrentAccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final AccountRepository repository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return findMethodAnnotation(CurrentAccount.class, parameter).isPresent() &&
                Objects.equals(Account.class, parameter.getClass());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer container,
            NativeWebRequest request,
            WebDataBinderFactory factory
    ) throws Exception {
        Authentication authentication = fetchCurrentAuthentication();

        if (authentication == null || !findMethodAnnotation(CurrentAccount.class, parameter).isPresent()) {
            return null;
        }

        return repository
                .findOneByAuthorisationInformationEmail(fetchPrincipalUsernameFromFromAuthentication(authentication))
                .orElse(null);
    }

    private Authentication fetchCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private String fetchPrincipalUsernameFromFromAuthentication(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();

        return principal.getUsername();
    }

}

