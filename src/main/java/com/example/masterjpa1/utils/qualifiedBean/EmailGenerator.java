package com.example.masterjpa1.utils.qualifiedBean;

import com.example.masterjpa1.utils.Generator;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.EMAIL;

//@com.example.masterjpa1.qualifiers.EmailGenerator    <--- basic qualifier
@com.example.masterjpa1.qualifiers.advance.Generator(generatorType = EMAIL)   //<-- qualifier with memeber
public class EmailGenerator  implements Generator {


    @Inject
    private String prefix;

    /*
    @PostConstruct
    private void initPostPrefix(){
        this.postPrefix="@gmail.com";
    }
*/
    @Override
    public String generateString() {
        return prefix+"@gmail.com";
    }
}
