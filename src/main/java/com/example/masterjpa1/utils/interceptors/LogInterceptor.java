package com.example.masterjpa1.utils.interceptors;


import com.example.masterjpa1.qualifiers.advance.Loggeble;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Loggeble
@Priority(Interceptor.Priority.APPLICATION)
public class LogInterceptor {



    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        System.out.println("ENTRING "+ic.getMethod().getName());
        try {
            return ic.proceed();
        }finally {
            System.out.println("EXITING "+ic.getMethod().getName());
        }
    }
}
