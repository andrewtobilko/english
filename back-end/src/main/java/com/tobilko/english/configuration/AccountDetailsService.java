package com.tobilko.english.configuration;

import com.tobilko.english.account.model.information.AuthorisationAccountInformation;
import com.tobilko.english.account.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AuthorisationAccountInformation> optionalInformation = accountRepository.findAuthorisationInformationByEmail(email);


        return turnAuthorisationAccountInformationIntoUserDetails(optionalInformation.orElseThrow(() -> new UsernameNotFoundException("Account has not been found! " + email)));
    }

    private UserDetails turnAuthorisationAccountInformationIntoUserDetails(AuthorisationAccountInformation information) {
        return new User(information.getEmail(), information.getPassword(), Collections.emptyList());
    }

}
