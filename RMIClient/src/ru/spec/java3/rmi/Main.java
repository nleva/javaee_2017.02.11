package ru.spec.java3.rmi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.java3.ejb.api.MySingleton;
import ru.spec.java3.ejb.api.Test;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
//		Hashtable<K, V>
		
		Context ctx = new InitialContext();
		echo(ctx);
//		MySingleton mySingleton = (MySingleton) ctx.lookup("MySingleton");
//		mySingleton.test();
	}

	private static void echo(Context ctx) throws NamingException {
		Test test = (Test) ctx.lookup("My");
		
		
		
		System.out.println(test.getClass().getCanonicalName());
		for(int i =0 ; i<10; i++){
			new Thread(){
				public void run() {
					String resp = test.echo("Hello i`m client");
					System.out.println(resp);
				}
			}.start();
		}
	}

}
