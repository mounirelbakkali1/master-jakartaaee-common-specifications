package com.example.masterjpa1.qualifiers;


import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Qualifier
public @interface Price {
    currency currency();
    public enum currency{
        EU,US,DH
    }
}
