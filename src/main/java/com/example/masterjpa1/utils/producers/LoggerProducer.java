package com.example.masterjpa1.utils.producers;


import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProducer {

    @Produces
    public Logger getLogger(InjectionPoint in){
        return LoggerFactory.getLogger(in.getMember().getDeclaringClass().getName());
    }
}
