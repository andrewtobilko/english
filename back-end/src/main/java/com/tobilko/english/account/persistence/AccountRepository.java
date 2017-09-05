package com.tobilko.english.account.persistence;

import com.tobilko.english.account.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@RepositoryRestResource(exported = false)
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    @Override
    @RestResource
    <S extends Account> S save(S account);

    Optional<Account> findOneByAuthorisationInformationEmail(String email);

}
