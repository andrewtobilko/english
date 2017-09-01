package com.tobilko.english.dictionary.model;

import com.tobilko.english.dictionary.model.configuration.DictionaryServiceConfiguration;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
public class DictionaryService {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    private URL logotypeURL;

    @Embedded
    private DictionaryServiceConfiguration configuration;

}

