package com.tobilko.english.account.handler;

import com.tobilko.english.account.model.Account;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

/**
 * Created by Andrew Tobilko on 9/2/17.
 */
//@RepositoryEventHandler
//public class AccountEventHandler {
//
//    @HandleBeforeSave
//    @HandleBeforeCreate
//    public void handleAccountBeforeSaveEvent(@Valid Account account) {
//        System.out.println(account);
//    }
//
//}
