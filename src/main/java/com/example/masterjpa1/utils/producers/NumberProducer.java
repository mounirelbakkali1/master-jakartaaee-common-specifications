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

public class NumberProducer {
   /* @Produces
    private String postPrifix = "@gmail.com";*/
    @Produces
    private int random = Math.abs(new Random().nextInt());
    @Produces
    private String prefix = "produced-username";
}
