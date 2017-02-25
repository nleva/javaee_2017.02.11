package ru.spec.java3.rmi;

import java.util.Hashtable;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.java3.ejb.api.HHBean;
import ru.spec.java3.ejb.api.MySingleton;
import ru.spec.java3.ejb.api.Test;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
//		Hashtable<K, V>
		
		Context ctx = new InitialContext();
		
		HHBean hh = (HHBean) ctx.lookup("hh");
		System.out.println("Enter user name:");
		Scanner scanner = new Scanner(System.in);
		long employeeId = hh.createEmployee(scanner.nextLine());
		
		System.out.println("user id = "+employeeId);
		
		for(;;){
			System.out.println("Enter user id:");
			String name = hh.getNameBy(scanner.nextLong());
			System.out.println(name);
		}
		
		
//		echo(ctx);
		
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
