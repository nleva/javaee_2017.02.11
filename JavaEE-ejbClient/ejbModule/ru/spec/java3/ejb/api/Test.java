package ru.spec.java3.ejb.api;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface Test {

	String echo(String msg);

}