package com.example.masterjpa1.utils.interceptors;


import com.example.masterjpa1.qualifiers.advance.Auditable;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.ext.InterceptorContext;
import org.slf4j.Logger;

@Interceptor
@Auditable
@Priority(Interceptor.Priority.APPLICATION)
public class AuditInterceptor {


    @Inject
    Logger log ;

    @AroundInvoke
    private Object audit(InvocationContext ic) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            return ic.proceed();
        }finally {
            log.info("Took {}",(System.currentTimeMillis()-begin));
        }
    }

}
