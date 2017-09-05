package com.tobilko.english.dictionary.model;

import com.tobilko.english.dictionary.model.configuration.DictionaryServiceConfiguration;
import lombok.Data;

import javax.persistence.*;
import java.net.URL;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
public class DictionaryService {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;
    private String description;

    private URL logotypeURL;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private DictionaryServiceConfiguration configuration;

}

