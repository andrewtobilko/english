package com.tobilko.english.definition.model;

import org.springframework.data.redis.core.RedisHash;

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
@RedisHash(value = "definitions")
public class Definition implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String query;

}
