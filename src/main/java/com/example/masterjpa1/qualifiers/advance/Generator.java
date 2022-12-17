package com.example.masterjpa1.qualifiers.advance;


import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Generator {


    GeneratorType generatorType();

    public enum GeneratorType{
        EMAIL,HOTMAIL
    }
}
