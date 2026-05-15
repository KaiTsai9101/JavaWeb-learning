package chapter1.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect     // 标识当前类为AOP类（切面类）
@Component
public class RecordTimeAspect {

    @Around("execution(* chapter1.test.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 记录方法运行的开始时间
        long begin = System.currentTimeMillis();

        // 执行原始的方法
        Object result = pjp.proceed();

        // 记录方法运行的结束时间，记录耗时
        long end = System.currentTimeMillis();
        log.info("方法 {} 运行耗时：{}ms", pjp.getSignature(),end - begin);
        return result;
    }
}
