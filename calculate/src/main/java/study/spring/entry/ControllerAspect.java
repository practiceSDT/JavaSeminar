package study.spring.entry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
public class ControllerAspect {
    @Around("execution(* study.spring.entry..*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
    	log.info("Start : " + point.toString());
    	long beforeTime = System.currentTimeMillis();
        Object obj = point.proceed();
        log.info("End : " + point.toString());
    	long afterTime = System.currentTimeMillis();
    	long execTime = afterTime - beforeTime;
        log.info("Time : " + execTime + " : "+ point.toString());
        return obj;
    }
}
