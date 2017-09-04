package com.tobilko.english.account.model.configuration;

import com.tobilko.english.dictionary.model.DictionaryService;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
@AssociationOverrides({@AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "priority"))})
public class AccountPreference {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @ManyToMany()
    @JoinTable(name = "account_preference_priorities")
    @MapKeyColumn(name = "priority")
    private Map<Integer, DictionaryService> servicePriorityMap;

}
