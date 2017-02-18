package ru.spec.java3.ejb.api;

import javax.ejb.Remote;

@Remote
public interface LoginBean {

	void login(String login, String pass) throws Exception;

}
