package com.cafe24.mysite2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect 
{
	@Around("execution(* *..repository.*.*(..)) || execution(* *..service.*.*(..)) || execution(* *..controller.*.*(..)) ")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
	{
		
		// before		
		StopWatch sw = new StopWatch();
		sw.start();
	
		
		// method 실행
		Object result = pjp.proceed();
		
		// after
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "," + methodName;
		
		System.out.println("[Execution Time]["+taskName+"]"+totalTime+"mils");
		
		return result;
	}
}