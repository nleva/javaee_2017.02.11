package ru.spec.javaee.ejb;

class Ext extends Base{
	public Ext() {
		System.out.println(super.getClass().getName());
		System.out.println(this.getClass().getName());
	}

	void f(){
		System.out.println("Ext.f()");
	}
}

public abstract class Base {

	
	public Base() {
		super();
		System.out.println(super.getClass().getName());
		System.out.println(this.getClass().getName());
		f();
		
		//provide this
	}
	
	abstract void f();
	
	public static void main(String[] args) {
//		Object b = new Ext();
		Integer i=-200;
		Integer j=-200;
//		for(;i<400;){
//			i++;
//			j++;
//			System.out.println(i+" " + (i==j));
//		}
		
		System.out.println((i==j));
	}
	
}
