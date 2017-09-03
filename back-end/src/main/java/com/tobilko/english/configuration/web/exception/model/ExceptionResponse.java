package com.tobilko.english.configuration.web.exception.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Andrew Tobilko on 9/2/17.
 */
@Getter
@RequiredArgsConstructor(staticName = "of")
public final class ExceptionResponse {

    private final String id;

    @JsonSerialize(using = ToStringSerializer.class)
    private final LocalDateTime time;

}
