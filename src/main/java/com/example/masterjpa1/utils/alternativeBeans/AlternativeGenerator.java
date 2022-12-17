package com.example.masterjpa1.utils.alternativeBeans;


import com.example.masterjpa1.utils.Generator;
import jakarta.enterprise.inject.Alternative;

/*


    IN CASE WE HAVE @Default QUALIFAIER AND BEAN-DISCOVERY IN BEAN.XML IS SETTED TO 'ALL'

    AND WE HAVE diffrent cenarios for deployment envronments
    :Ex: using AlternativeGeneartor for testing enviroment and diffrent implimentation  in development invironent

    WE CAN USE @Alternative Annotation to tell the bean manager to disable conserdiring this

    implimentation as injectable so we can avoid then ambigous Exeption at the runtime

        by  adding alternative to beans.xml we activate Alternative generator to be qualified as primary

    📌 @V ANNOTATION can not target package

        ITS DECLARATION :
        @Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})

*/

@Alternative
public class AlternativeGenerator implements Generator {
    @Override
    public String generateString() {
        return "alternativeemail@alt.ma";
    }
}
