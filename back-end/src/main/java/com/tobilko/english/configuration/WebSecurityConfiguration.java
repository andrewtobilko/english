package com.tobilko.english.configuration;

import com.tobilko.english.configuration.jwt.JWTAuthenticationFilter;
import com.tobilko.english.configuration.jwt.JWTLoginFilter;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AccountDetailsService accountDetailsService;
    private final List<UnaryOperator<HttpSecurity>> httpSecurityFilters;

    public WebSecurityConfiguration(AccountDetailsService service) {
        httpSecurityFilters = new ArrayList<>();
        accountDetailsService = service;
    }

    @PostConstruct
    public void handlePostConstructCallBack() {
        initialiseHTTPSecurityFilters();
    }

        private void initialiseHTTPSecurityFilters() {
            httpSecurityFilters.add(getFilterPositionAwareForConfiguredJWTLoginFilter());
            httpSecurityFilters.add(getFilterPositionAwareForConfiguredJWTAuthenticationFilter());
        }

            @SneakyThrows
            private UnaryOperator<HttpSecurity> getFilterPositionAwareForConfiguredJWTLoginFilter() {
                AbstractAuthenticationProcessingFilter filter = new JWTLoginFilter("/login");
                filter.setAuthenticationManager(authenticationManager());

                return security -> security.addFilterBefore(
                        filter,
                        UsernamePasswordAuthenticationFilter.class
                );
            }

            private UnaryOperator<HttpSecurity> getFilterPositionAwareForConfiguredJWTAuthenticationFilter() {
                return security -> security.addFilterBefore(
                        new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                );
            }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        disableCSRFWithCurrentSecurityInstance(security);
        configureURLAuthorisationByCurrentSecurityInstance(security);
        applySecurityFiltersToCurrentSecurityInstance(security);
    }

        private void disableCSRFWithCurrentSecurityInstance(HttpSecurity security) throws Exception {
            security.csrf().disable();
        }

    // TODO: 9/2/17
        private void configureURLAuthorisationByCurrentSecurityInstance(HttpSecurity security) throws Exception {
            security.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/accounts").permitAll()
                    .anyRequest().authenticated();
        }

        private void applySecurityFiltersToCurrentSecurityInstance(HttpSecurity security) {
            for (UnaryOperator<HttpSecurity> function : httpSecurityFilters) {
                function.apply(security);
            }
        }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(accountDetailsService);
    }

}
