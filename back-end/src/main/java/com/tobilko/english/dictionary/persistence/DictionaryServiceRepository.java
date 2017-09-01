package com.tobilko.english.dictionary.persistence;

import com.tobilko.english.dictionary.model.DictionaryService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static com.tobilko.english.dictionary.util.DictionaryServiceConstant.DICTIONARY_SERVICE_REPOSITORY_PATH;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@RepositoryRestResource(path = DICTIONARY_SERVICE_REPOSITORY_PATH)
public interface DictionaryServiceRepository extends PagingAndSortingRepository<DictionaryService, Long> {}
