package com.tobilko.english.account.model.information.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Embeddable
public class AuthorisationAccountInformation implements Serializable {

    @Email
    @NotNull
    @NotEmpty
    @Column(unique = true) // TODO: 9/3/17 modify the exception
    private String email;

    @NotNull
    @JsonProperty(access = WRITE_ONLY)
    private String password;

}
