package com.example.masterjpa1.utils;

import jakarta.annotation.PostConstruct;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.EMAIL;

//@com.example.masterjpa1.qualifiers.EmailGenerator    <--- basic qualifier
@com.example.masterjpa1.qualifiers.advance.Generator(generatorType = EMAIL)   //<-- qualifier with memeber
public class EmailGenerator  implements Generator{



    private String postPrefix;
    @PostConstruct
    private void initPostPrefix(){
        this.postPrefix="@gmail.com";
    }
    @Override
    public String generateString() {
        return "user10"+postPrefix;
    }
}
