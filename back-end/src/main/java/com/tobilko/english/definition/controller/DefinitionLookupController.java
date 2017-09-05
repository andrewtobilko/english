package com.tobilko.english.definition.controller;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.configuration.web.resolver.account.CurrentAccount;
import com.tobilko.english.definition.model.Definition;
import com.tobilko.english.definition.service.DefinitionLookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrew Tobilko on 9/5/17.
 */
@RestController
@RequiredArgsConstructor
public class DefinitionLookupController {

    private final DefinitionLookupService service;

    @GetMapping("/api/definitions?query={definition}")
    private Definition lookDefinitionOverPreferableDictionaryServices(
            @PathVariable("definition") String definition,
            @CurrentAccount Account account
    ) {
        // TODO: 9/5/17 should the definition be validated ?
        return service.lookDefinitionOverPreferableDictionaryServices(
                definition,
                account.getPreference()
        );
    }

}

