package com.example.masterjpa1.qualifiers.advance;


import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.POSTFIX;
import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.PREFIX;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface NumberProducer {

    /*@Nonbinding*/ StringProcued stringProduced() default PREFIX;



    public enum StringProcued{
        POSTFIX,PREFIX
    }
}
