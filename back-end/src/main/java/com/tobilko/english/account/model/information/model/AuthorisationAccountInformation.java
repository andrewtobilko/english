package com.tobilko.english.account.model.information.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Embeddable
public class AuthorisationAccountInformation {

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @JsonProperty(access = WRITE_ONLY)
    private String password;

}
