package com.tobilko.english.definition.controller;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.account.model.configuration.AccountPreference;
import com.tobilko.english.configuration.web.resolver.account.CurrentAccount;
import com.tobilko.english.definition.model.Definition;
import com.tobilko.english.definition.service.DefinitionLookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 9/5/17.
 */
@RestController
@RequiredArgsConstructor
public class DefinitionLookupController {

    private final DefinitionLookupService service;

    @GetMapping("/api/definitions")
    private Definition lookDefinitionOverPreferableDictionaryServices(
            @RequestParam("query") String definition,
            @CurrentAccount Account account
    ) {
        validateDefinitionQuery(definition);

        return service.lookDefinitionOverPreferableDictionaryServices(
                definition,
                getPreferenceByAccount(account).orElseThrow(() -> new IllegalArgumentException("acc prefs should be set")) // todo
        );
    }

    private void validateDefinitionQuery(String query) {
        // TODO: 9/6/17 cover up all cases
        if (query.isEmpty()) {
            throw new IllegalArgumentException("consider passing a good query");
        }
    }

    private Optional<AccountPreference> getPreferenceByAccount(Account account) {
        return Optional.ofNullable(account.getPreference());
    }

}

