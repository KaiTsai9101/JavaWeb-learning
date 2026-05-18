package chapter1.test.aop;

import chapter1.test.mapper.OperateLogMapper;
import chapter1.test.pojo.OperateLog;
import chapter1.test.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(chapter1.test.anno.Log)")
    public Object logOperateLog(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = pjp.proceed();

        // 计算耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        // 获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        // 构建日志实体
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentUserId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(pjp.getTarget().getClass().getName());
        olog.setMethodName(pjp.getSignature().getName());
        olog.setMethodParam(Arrays.toString(pjp.getArgs()));
        olog.setReturnValue(result != null ? result.toString() : "void");
        olog.setCostTime(costTime);

        // 保存日志
        log.info("记录操作日志：{}", olog);
        operateLogMapper.insert(olog);

        return result;
    }

    private Integer getCurrentUserId() {
        // 模拟从当前线程获取当前用户ID
        return CurrentHolder.getCurrentId();
    }
}
