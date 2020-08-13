package com.github.zzzzbw.aube.web.starter.aspect;

import com.github.zzzzbw.aube.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author by zzzzbw
 * @since 2020/08/13 10:59
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("@within(com.github.zzzzbw.aube.web.starter.annotation.Log) || @annotation(com.github.zzzzbw.aube.web.starter.annotation.Log)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object recordLog(ProceedingJoinPoint p) throws Throwable {
        long startTime = System.currentTimeMillis();
        startLog(p);
        Object result = p.proceed();
        endLog(p, startTime, result);
        return result;
    }

    private void startLog(ProceedingJoinPoint p) {
        String methodName = getMethodName(p.getSignature());
        String args = JsonUtils.toJson(p.getArgs());
        log.info("Starting method: [{}], args: {}", methodName, args);
    }

    private void endLog(ProceedingJoinPoint p, long startTime, Object result) {
        String methodName = getMethodName(p.getSignature());
        String resultJson = JsonUtils.toJson(result);
        log.info("Ending method: [{}], usage: [{}]ms, result: [{}]",
                methodName, System.currentTimeMillis() - startTime, resultJson);
    }

    private String getMethodName(Signature signature) {
        String method = signature.getName();
        String className = signature.getDeclaringTypeName();
        return className + "#" + method;
    }
}
