package com.tobilko.english.account.dictionary.model.configuration;

import com.tobilko.english.account.dictionary.model.DictionaryFeature;
import lombok.Data;

import javax.persistence.Embeddable;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Embeddable
public class DictionaryServiceConfiguration {

    private URL baseURL;

    private URI wordSearchURI;
    private URI wordDetailsSearchURI;


    private Map<DictionaryFeature, String> featureToResponseKeyMap;

    // http://api.pearson.com/v2/dictionaries/entries/ID
    // http://api.pearson.com/v2/dictionaries/entries?headword=According

}
