package com.tobilko.english.dictionary.model.configuration;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.net.URL;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
public class DictionaryServiceConfiguration {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private URL baseURL;

    private URI wordSearchURITemplate;

    //private Map<DictionaryFeature, String> featureToResponseKeyMap;

}
