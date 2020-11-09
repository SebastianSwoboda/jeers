package ch.bbc.uek223.jeers.ejb.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Repräsentiert 
 * @author nfeuzc
 *
 */
@LocalBean
@Stateless
public class HelloService {
	
	/**
	 * Gibt Hello World als String zurück
	 * 
	 * @return 
	 */
	public String sayHello(){
		return "Hello World!";
	}

}
