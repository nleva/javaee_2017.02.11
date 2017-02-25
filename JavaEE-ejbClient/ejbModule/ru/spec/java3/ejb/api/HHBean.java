package ru.spec.java3.ejb.api;

import javax.ejb.Remote;

@Remote
public interface HHBean {

	long createEmployee(String name);

	String getNameBy(long id);

}
