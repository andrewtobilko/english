package com.tobilko.english.account.model.configuration;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
public class AccountConfiguration {

    @Id
    @GeneratedValue
    private Long id;

    //private Map<Integer, DictionaryService> servicePriorityMap;

}
