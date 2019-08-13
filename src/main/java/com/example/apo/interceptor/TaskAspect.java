// package com.example.apo.interceptor;
//
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
//
// /**
//  * Author by Sun, Date on 2019/4/7.
//  * PS: Not easy to write code, please indicate.
//  */
// // @Aspect
// // @Component
// public class TaskAspect {
//
//     private static final Logger logger = LoggerFactory.getLogger(TaskAspect.class);
//
//     @Pointcut("execution(* com.example.request.RequestTemplate.test(..))")
//     private void addTaskAction(){
//         System.out.println("is pointcut");
//     }
//
//     private ThreadLocal<String> tLocal = new ThreadLocal<String>();
//
//     @Before("execution(* com.example.request.RequestTemplate.test())")
//     public void getInterview(){
//         System.out.println("is before");
//         // tLocal.set();
//     }
//
//     @Around("addTaskAction()")
//     public Object aroundInterviewTask(ProceedingJoinPoint pjp) throws Throwable{
//         Object[] args = pjp.getArgs();
//         Object retVal = pjp.proceed(args);
//
//         try {
//             //获取参数
//             String id = args[0].toString();
//             String name = args[2].toString();
//             //业务逻辑处理
//         } catch (Throwable e) {
//             //异常处理
//         }
//
//         return retVal;
//     }
//
//     @AfterReturning(returning="result",pointcut="addTaskAction()")
//     public void addCount(Object result){
//         System.out.println(result);
//     }
// }
