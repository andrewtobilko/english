package com.tobilko.english.util;

import org.springframework.core.MethodParameter;

import java.lang.annotation.Annotation;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Created by Andrew Tobilko on 9/4/17.
 */
public final class AnnotationUtils {

    public static <T extends Annotation> Optional<T> findMethodAnnotation(
            Class<T> annotationClass,
            MethodParameter parameter
    ) {
        T annotation = parameter.getParameterAnnotation(annotationClass);

        if (annotation != null) {
            return of(annotation);
        }

        Annotation[] annotationsToSearch = parameter.getParameterAnnotations();
        for (Annotation toSearch : annotationsToSearch) {
            annotation = org.springframework.core.annotation.AnnotationUtils.findAnnotation(toSearch.annotationType(),
                    annotationClass);
            if (annotation != null) {
                return of(annotation);
            }
        }

        return empty();
    }

    private AnnotationUtils() {}

}