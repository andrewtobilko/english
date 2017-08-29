package com.tobilko.english.account.persistence;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.model.information.AuthorisationAccountInformation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findOneByAuthorisationInformationEmail(String email);

    default Optional<AuthorisationAccountInformation> findAuthorisationInformationByEmail(String email) {
        Optional<Account> optionalAccount = findOneByAuthorisationInformationEmail(email);

        return optionalAccount.map(Account::getAuthorisationInformation);

    }

}
