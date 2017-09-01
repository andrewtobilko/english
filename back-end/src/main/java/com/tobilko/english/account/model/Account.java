package com.tobilko.english.account.model;

import com.tobilko.english.account.model.configuration.AccountConfiguration;
import com.tobilko.english.account.model.information.model.AuthorisationAccountInformation;
import com.tobilko.english.account.model.information.model.GeneralAccountInformation;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private AuthorisationAccountInformation authorisationInformation;

    @Embedded
    private GeneralAccountInformation generalInformation;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private AccountConfiguration configuration;

}
