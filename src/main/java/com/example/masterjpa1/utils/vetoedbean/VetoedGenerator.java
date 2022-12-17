package com.example.masterjpa1.utils.vetoedbean;


import com.example.masterjpa1.utils.Generator;
import jakarta.enterprise.inject.Vetoed;


/*


    IN CASE WE HAVE @Default QUALIFAIER AND BEAN-DISCOVERY IN BEAN.XML IS SETTED TO 'ALL'

    WE CAN USE @Vetoed Annotation to tell the bean manager to egnore conserdiring this

    implimentation as injectable so we can avoid then ambigous Exeption at the runtime

    📌 @Vetoed ANNOTATION could be added to the entier package itself so the become not visible by the CDI

        ITS DECLARATION :
        @Target({ElementType.TYPE, ElementType.PACKAGE})

*/

@Vetoed
public class VetoedGenerator implements Generator {
    @Override
    public String generateString() {
        return null;
    }
}
