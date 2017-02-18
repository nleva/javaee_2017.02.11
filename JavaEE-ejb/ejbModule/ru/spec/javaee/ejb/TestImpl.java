package ru.spec.javaee.ejb;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;

import ru.spec.java3.ejb.api.Test;
import ru.spec.javaee.ejb.aop.LogTime;
import ru.spec.javaee.ejb.aop.ReverseFirstArg;
import ru.spec.javaee.ejb.interceptor.ReverseString;

/**
 * Session Bean implementation class Test
 */
@Stateless(mappedName="My", name="My")
@LocalBean
@LogTime
public class TestImpl implements Test {
    
	int count;
	
	@Inject
	LoginBeanImpl loginBean;

	@LogTime(value=11, date="world")
	@PostConstruct
	void onStart(){
		
	}
	
//	@Inject Event<Integer> bus;
	
    @Override
//    @Interceptors(ReverseString.class)
//    @ReverseString
    @ReverseFirstArg
	public String echo(@LogTime(date="qew") String msg){
    	count++;
System.out.println(count+" : "+msg + " : "+Thread.currentThread().getName());

		//loginBean.login(msg);
		//otherBean.login(msg);
		//Bean.login(msg);
//		Event mybus = bus;
//		Event<String> sbus = mybus;
//		sbus.fire(msg);


    	return "re_"
    			+ count
    			+ "_: "+msg;
    	
    }
    
    

}
