package com.tobilko.english.definition.persistence;

import com.tobilko.english.definition.model.Definition;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by Andrew Tobilko on 9/4/17.
 */
public interface DefinitionRepository extends PagingAndSortingRepository<Definition, Long> {

    Optional<Definition> findOneByQuery(String query);

}
