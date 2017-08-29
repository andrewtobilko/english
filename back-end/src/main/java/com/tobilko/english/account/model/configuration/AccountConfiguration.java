package com.tobilko.english.account.model.configuration;

import com.tobilko.english.account.dictionary.model.DictionaryService;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

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
