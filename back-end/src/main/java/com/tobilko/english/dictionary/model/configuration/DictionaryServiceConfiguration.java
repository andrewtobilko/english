package com.tobilko.english.dictionary.model.configuration;

import lombok.Data;

import javax.persistence.Embeddable;
import java.net.URI;
import java.net.URL;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Embeddable
public class DictionaryServiceConfiguration {

    private URL baseURL;

    private URI wordSearchURI;
    private URI wordDetailsSearchURI;


    //private Map<DictionaryFeature, String> featureToResponseKeyMap;

}
