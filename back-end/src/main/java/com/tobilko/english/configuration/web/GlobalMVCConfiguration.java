package com.tobilko.english.configuration.web;

import com.tobilko.english.configuration.web.resolver.account.CurrentAccountHandlerMethodArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Andrew Tobilko on 9/3/17.
 */
@Configuration
@RequiredArgsConstructor
public class GlobalMVCConfiguration implements WebMvcConfigurer {

    private final CurrentAccountHandlerMethodArgumentResolver currentAccountHandlerMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentAccountHandlerMethodArgumentResolver);
    }

}
