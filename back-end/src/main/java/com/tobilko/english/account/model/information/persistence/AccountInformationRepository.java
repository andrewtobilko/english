package com.tobilko.english.account.model.information.persistence;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.model.information.model.AuthorisationAccountInformation;
import com.tobilko.english.account.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 9/1/17.
 */
@Repository
@RequiredArgsConstructor
public final class AccountInformationRepository {

    private final AccountRepository accountRepository;

    public Optional<AuthorisationAccountInformation> findAuthorisationInformationByEmail(String email) {
        Optional<Account> optionalAccount = accountRepository.findOneByAuthorisationInformationEmail(email);

        return optionalAccount.map(Account::getAuthorisationInformation);

    }

}
