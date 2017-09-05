package com.tobilko.english.account.persistence;

import com.tobilko.english.account.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
// TODO: 9/6/17 exported=false except for POST for registration
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findOneByAuthorisationInformationEmail(String email);

}
