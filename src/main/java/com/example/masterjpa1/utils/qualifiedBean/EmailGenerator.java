package com.example.masterjpa1.utils.qualifiedBean;

import com.example.masterjpa1.qualifiers.advance.NumberProducer;
import com.example.masterjpa1.utils.Generator;
import jakarta.inject.Inject;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.EMAIL;
import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.POSTFIX;
import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.PREFIX;

//@com.example.masterjpa1.qualifiers.EmailGenerator    <--- basic qualifier
@com.example.masterjpa1.qualifiers.advance.Generator(generatorType = EMAIL)   //<-- qualifier with memeber
public class EmailGenerator  implements Generator {


    @Inject @NumberProducer
    private String prefix;
    @Inject @NumberProducer(stringProduced = POSTFIX)
    private String postfix;

    /*
    @PostConstruct
    private void initPostPrefix(){
        this.postPrefix="@gmail.com";
    }
*/
    @Override
    public String generateString() {
        return prefix+postfix;
    }
}
