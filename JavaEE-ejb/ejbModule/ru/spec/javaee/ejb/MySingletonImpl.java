package ru.spec.javaee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import ru.spec.java3.ejb.api.MySingleton;

/**
 * Session Bean implementation class MySingletonImpl
 */
@Singleton(mappedName="MySingleton")
@LocalBean
public class MySingletonImpl implements MySingleton {

    public MySingletonImpl() {
        System.out.println("----MySingletonImpl()"+Thread.currentThread());
    }
    
    @PostConstruct
    void init(){
    	System.out.println("++++MySingletonImpl.init()"+Thread.currentThread());
    	
    }
    
    @Override
    @Lock(LockType.READ)
    public void test(){
    	
    }

}
