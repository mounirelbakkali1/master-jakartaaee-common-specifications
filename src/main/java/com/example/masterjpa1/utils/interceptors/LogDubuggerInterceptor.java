package com.example.masterjpa1.utils.interceptors;

import com.example.masterjpa1.qualifiers.advance.Loggeble;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;

@Interceptor
@Loggeble(debug = true)
@Priority(Interceptor.Priority.APPLICATION+20)
public class LogDubuggerInterceptor {


    @Inject
    Logger log ;

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        log.debug("ENTRING " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            log.debug("EXITING " + ic.getMethod().getName());
        }
    }
}
