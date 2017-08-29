package com.tobilko.english.account.model.information;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Embeddable
public class AuthorisationAccountInformation {

    private String email;
    private String password;

}
