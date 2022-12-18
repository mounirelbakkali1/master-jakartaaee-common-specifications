package com.example.masterjpa1.qualifiers;


import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,METHOD,PARAMETER})
@Retention(RUNTIME)
@Qualifier
public @interface UserDataBase {
}
