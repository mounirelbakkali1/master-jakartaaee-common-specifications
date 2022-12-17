package com.example.masterjpa1.qualifiers;

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.*;


@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
@Qualifier
public @interface EmailGenerator {
}
