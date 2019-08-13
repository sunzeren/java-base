package com.example.proxy.dynamic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Log logger = LogFactory.getLog(MyInvocationHandler.class);

    private Object realObject;

    public MyInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy do");
        String person=null;
        if(proxy instanceof Man){
            person="男人";
        }
        if(proxy instanceof Woman){
            person="女人";
        }
        if (method.getName().equals("doSomething")) {
            logger.info(person+"要说话了");
        }

        return method.invoke(realObject, args);
    }
}
