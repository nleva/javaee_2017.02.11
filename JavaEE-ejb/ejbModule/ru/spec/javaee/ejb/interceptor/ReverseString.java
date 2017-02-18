package ru.spec.javaee.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ru.spec.javaee.ejb.aop.ReverseFirstArg;

@Interceptor
@ReverseFirstArg
public class ReverseString {

	public ReverseString() {
		// TODO Auto-generated constructor stub
	}
	
	@AroundInvoke
	public Object reverse(InvocationContext ic) throws Exception {
		
//		ic.getMethod()
		Object[] parameters = ic.getParameters();
		String request = (String) parameters[0];
		System.out.println(parameters.length+" total params "+request);
		request = new StringBuilder(request).reverse().toString();
		parameters[0] = request;
		
		Object result = ic.proceed();
		
		return result;
	}

}
