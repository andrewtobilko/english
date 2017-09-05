package com.tobilko.english.definition.service;

import com.tobilko.english.account.model.configuration.AccountPreference;
import com.tobilko.english.definition.model.Definition;
import com.tobilko.english.definition.persistence.DefinitionRepository;
import com.tobilko.english.dictionary.model.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Andrew Tobilko on 9/5/17.
 */
@Service
@RequiredArgsConstructor
public final class DefinitionLookupService {

    private final DefinitionRepository repository;

    public Definition lookDefinitionOverPreferableDictionaryServices(String definition, AccountPreference preference) {
        return repository
                .findOneByQuery(definition)
                .orElseGet(() -> this.getDefinitionFromDictionaryServicesByAccountPreference(preference));
    }

    private Definition getDefinitionFromDictionaryServicesByAccountPreference(AccountPreference preference) {
        Map<Integer, DictionaryService> servicePriorityMap = preference.getServicePriorityMap();

        // todo

        return null;
    }

}
