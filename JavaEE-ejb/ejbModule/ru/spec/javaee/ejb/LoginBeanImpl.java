package ru.spec.javaee.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import ru.spec.java3.ejb.api.LoginBean;

@Stateless
@LocalBean
public class LoginBeanImpl implements LoginBean {

//	ThreadLocal<String> local;

	@Asynchronous
	public Future<String> getString(){
		///
		///
		return new AsyncResult<String>("hello wolrd");
	}
	
	@Override
	public void login(String login, String pass) throws Exception {
		
	}
	
	public void test(Object m){
		System.out.println("+-+-+-+ "+m);
	}
	
	public void/*User*/ reg(/*Request*/){
		// DB
		// User
	}
}
