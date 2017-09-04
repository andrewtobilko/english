package com.tobilko.english.account.controller;

import com.tobilko.english.account.model.Account;
import com.tobilko.english.configuration.web.resolver.account.CurrentAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrew Tobilko on 9/4/17.
 */
@RestController
public class AccountController {

    @GetMapping(path = "/api/accounts/current")
    public Account getCurrentAccount(@CurrentAccount Account account) {
        return account;
    }

}
