package ru.spec.javaee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import ru.spec.java3.ejb.api.EmployeeBean;

/**
 * Session Bean implementation class EmployeeBeanImpl
 */
@Stateful
@LocalBean
public class EmployeeBeanImpl implements EmployeeBean, Serializable {

	int age;
	String name;
	
	@PostConstruct
	@PreDestroy
	@PrePassivate
	@PostActivate
	void f(){
		
	}
    
    @Asynchronous
    void test(){
    	
    }
    
    @Remove
    void kill(){
    	
    }

}
