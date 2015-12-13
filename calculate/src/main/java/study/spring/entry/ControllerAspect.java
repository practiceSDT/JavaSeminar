package study.spring.entry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
public class ControllerAspect {
    @Around("execution(* study.spring..*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
    	log.info("前処理");
    	long beforeTime = System.currentTimeMillis();
        Object obj = point.proceed();
        log.info("後処理");
    	long afterTime = System.currentTimeMillis();
    	long execTime = afterTime - beforeTime;
        log.info("Time : " + execTime);
        return obj;
    }
}
