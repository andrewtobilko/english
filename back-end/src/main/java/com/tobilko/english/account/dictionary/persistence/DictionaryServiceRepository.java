package com.tobilko.english.account.dictionary.persistence;

import com.tobilko.english.account.dictionary.model.DictionaryService;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
public interface DictionaryServiceRepository extends PagingAndSortingRepository<DictionaryService, Long> {}
