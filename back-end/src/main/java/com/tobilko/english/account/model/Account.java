package com.tobilko.english.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tobilko.english.account.model.configuration.AccountPreference;
import com.tobilko.english.account.model.information.model.AuthorisationAccountInformation;
import com.tobilko.english.account.model.information.model.GeneralAccountInformation;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Entity
@RedisHash(value = "accounts")
public class Account implements Serializable {

    @Id
    //@org.springframework.data.annotation.Id
    @JsonIgnore
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Valid
    @NotNull
    @Embedded
    @JsonInclude(NON_NULL)
    private AuthorisationAccountInformation authorisationInformation;

    @Valid
    @NotNull
    @Embedded
    @JsonInclude(NON_NULL)
    private GeneralAccountInformation generalInformation;

    @JsonInclude(NON_NULL)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private AccountPreference configuration;

}
