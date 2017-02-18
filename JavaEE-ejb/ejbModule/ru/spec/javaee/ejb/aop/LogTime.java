package ru.spec.javaee.ejb.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogTime {

	int[] value() default 123;
	String date() default "";
	
}
