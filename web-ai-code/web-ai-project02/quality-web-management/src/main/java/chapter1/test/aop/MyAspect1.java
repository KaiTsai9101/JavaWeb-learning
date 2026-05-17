package chapter1.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
//@Aspect
public class MyAspect1{
    // 定义切入点
    @Pointcut("execution(* chapter1.test.service.impl.*.*(..))")
    public void pointcut(){}

    // 前置通知 - 运行前运行
//    @Before("pointcut()")
    @Before("@annotation(chapter1.test.anno.Log)")     // 匹配指定注解，需要给需要切面的方法添加指定注解
    public void before(JoinPoint joinPoint){
        log.info("before ...");
        // 获取目标对象
        Object target = joinPoint.getTarget();
        log.info("获取目标对象: {}", target);

        // 获取目标类
        String className = joinPoint.getTarget().getClass().getName();  // 获取目标对象 -> 对象所在类 -> 所在类类名
        log.info("获取目标类: {}", className);

        // 获取目标方法
        String methodName = joinPoint.getSignature().getName();
        log.info("获取目标方法: {}", methodName);

        // 获取目标方法参数
        Object[] args = joinPoint.getArgs();
        log.info("获取目标方法参数: {}", Arrays.toString(args));
    }

    // 环绕通知 - 运行时运行
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around before ...");
        Object result = pjp.proceed();
        log.info("around after ...");
        return result;
    }

    // 后置通知 - 运行结束后运行
    @After("pointcut()")
    public void after(){
        log.info("after ...");
    }

    // 返回后通知 - 目标方法运行后运行，出现异常时不运行
    @AfterReturning("pointcut()")
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    // 异常后通知 - 目标方法运行后运行，出现异常时不运行
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }
}
