package com.example.masterjpa1.utils.interceptors;


import com.example.masterjpa1.qualifiers.advance.Loggeble;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;

@Interceptor
@Loggeble
@Priority(Interceptor.Priority.APPLICATION+10)
public class LogInterceptor {


    @Inject
    Logger log;
    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        Thread.sleep(100);// to demonstrate that this interceptor will take some time
        log.info("ENTRING "+ic.getMethod().getName());
        try {
            return ic.proceed();
        }finally {
            Thread.sleep(100);
            log.info("EXITING "+ic.getMethod().getName());
        }
    }
}
