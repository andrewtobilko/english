package com.tobilko.english.definition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

/**
 * Created by Andrew Tobilko on 9/4/17.
 */
@Entity
public class Definition implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

}
