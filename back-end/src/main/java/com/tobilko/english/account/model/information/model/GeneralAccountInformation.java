package com.tobilko.english.account.model.information.model;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by Andrew Tobilko on 8/27/17.
 */
@Data
@Embeddable
public class GeneralAccountInformation {

    private String firstName;
    private String lastName;

}
