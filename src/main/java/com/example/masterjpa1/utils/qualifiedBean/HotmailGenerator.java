package com.example.masterjpa1.utils.qualifiedBean;


import com.example.masterjpa1.utils.Generator;
import jakarta.annotation.PostConstruct;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.HOTMAIL;


//@com.example.masterjpa1.qualifiers.HotmailGenerator
@com.example.masterjpa1.qualifiers.advance.Generator(generatorType = HOTMAIL)
public class HotmailGenerator implements Generator {
    private String postPrefix;
    @PostConstruct
    private void initPostPrefix(){
        this.postPrefix="@hotmail.fr";
    }
    @Override
    public String generateString() {
        return "hotmail-user"+postPrefix;
    }
}
