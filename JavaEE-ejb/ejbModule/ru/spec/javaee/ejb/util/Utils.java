package ru.spec.javaee.ejb.util;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Utils {

	@Produces
	@Serial
	@PersistenceContext(name="JavaEE-ejb")
	EntityManager serial;
	
	
	@Produces
	public Logger getLogger(InjectionPoint ip){
		return Logger.getLogger(ip.getType().getTypeName());
	}
	
//	@Produces
//	@PersistenceContext(name="JavaEE-ejb-DR")
//	EntityManager dirtyRead;
//	
//	@Produces
//	@PersistenceContext(name="JavaEE-ejb-XA")
//	EntityManager xa;
}
