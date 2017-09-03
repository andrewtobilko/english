package com.tobilko.english.configuration.web.resolver.account;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Andrew Tobilko on 9/3/17.
 */
// TODO: 9/3/17 rewrite entirely
@Component
@RequiredArgsConstructor
public class CurrentAccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final AccountRepository repository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AnnotationUtils.findMethodAnnotation(CurrentAccount.class, parameter).isPresent();
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer container,
            NativeWebRequest request,
            WebDataBinderFactory factory
    ) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !AnnotationUtils.findMethodAnnotation(CurrentAccount.class, parameter).isPresent()) {
            return null;
        }
        User principal = (User) authentication.getPrincipal();

        CurrentAccount annotation = AnnotationUtils.findMethodAnnotation(CurrentAccount.class, parameter).get();
        boolean shouldExceptionBeThrown = annotation.throwExceptionIfNotFound();

        String name = principal.getUsername();

        if (name == null) {
            return null;
        }

        Account account;
        if (shouldExceptionBeThrown) {
            account = utils.findAccountByEmailOrElseThrowAccountNotFoundException(name);
        } else {
            account = utils.findAccountByEmail(name).orElse(null);
        }

        return account;
    }


}
