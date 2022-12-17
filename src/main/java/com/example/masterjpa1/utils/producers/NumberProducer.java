package com.example.masterjpa1.utils.producers;
/*


    ✔
    PRODUCERS ARE USED TO MAKE THIRD-PARTY FRAMEWORKs (Log4j as example) AND APIs MANAGED BY CDI
    fact -> JAVA SE APIs (STRING,DATE...) for example are not packged with java ee archive instead
    they are packaged into rt.jar that doesnt containe beans discriptor so it couldn't be injected
    the solution is to use producers



*/

import jakarta.enterprise.inject.Produces;

import java.util.Random;

import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.POSTFIX;
import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.PREFIX;

public class NumberProducer {
    @Produces @com.example.masterjpa1.qualifiers.advance.NumberProducer(stringProduced = POSTFIX)
    private String postPrifix = "@gmail-produced.com";
    @Produces
    private int random = Math.abs(new Random().nextInt());


    @Produces @com.example.masterjpa1.qualifiers.advance.NumberProducer(stringProduced = PREFIX)
    private String prefix = "produced-username";
}
