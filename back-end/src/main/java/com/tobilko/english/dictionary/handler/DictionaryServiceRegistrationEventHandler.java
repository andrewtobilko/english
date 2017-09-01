package com.tobilko.english.dictionary.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

/**
 * Created by Andrew Tobilko on 9/1/17.
 */
@RepositoryEventHandler
public class DictionaryServiceRegistrationEventHandler {

    @HandleBeforeSave
    public void handleBeforeDictionaryGetsPersisted() {

        System.out.println("!");

    }

}

